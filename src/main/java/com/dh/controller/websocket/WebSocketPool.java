package com.dh.controller.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class WebSocketPool {

	private static final Logger log = LoggerFactory.getLogger(WebSocketPool.class);
	
	/**
	 * websocket对象Map
	 */
	public static ConcurrentHashMap<String, WebSocketService> webSocketMap = new ConcurrentHashMap<>();
	
	/**
	 *  最大连接数
	 */
	public static final int MAX_SOCKET_NUM = 10;
	
	/**
	 * 当前连接数
	 */
	public static int CURRENT_LINK_NUM = 0;
	
	/**
	 * @Author
	 * @Description 添加WebSocket对象到Map集合中
	 * @param webSocketService
	 * @param userName
	 */
	public static void addWebSocketToMap(WebSocketService webSocketService, String userName) {
		if(CURRENT_LINK_NUM < MAX_SOCKET_NUM && !webSocketMap.containsKey(userName)) {
			webSocketMap.put(userName, webSocketService);
			synchronized (log) {
				CURRENT_LINK_NUM ++;				
			}
		}
		else {
			log.error("超出最大连接!");
		}
	}
	
	/**
	 * @Author
	 * @Description 删除指定的WebSocket对象
	 * @param webSocketService
	 */
	public static void removeWebSocketFromMap(String userName) {
		if(webSocketMap.containsKey(userName)) {
			for(String keySet : webSocketMap.keySet()) {
				if(keySet.equals(userName)) {
					webSocketMap.remove(userName);
					break;
				}
			}
			synchronized (log) {
				CURRENT_LINK_NUM --;
			}
		}
		else {
			log.error("找不到指定连接!");
		}
	}
	
	/**
	 * @Author
	 * @Description 发送给指定用户
	 * @param message
	 * @param userName
	 * @param fromName
	 * @throws IOException
	 */
	public static void sendToUser(String message, String toName, String fromName) throws IOException {
		if(!webSocketMap.containsKey(toName)) {
			log.error("没有指定用户!");
		}
		if(StringUtils.isBlank(message) || StringUtils.isBlank(toName)) {
			log.error("参数为空!");
		}
		JSONObject res = new JSONObject();
		res.put("flag", "3");
		res.put("text", message);
		res.put("fromName", fromName);
		for(String key : webSocketMap.keySet()) {
			if(key.equals(toName)) {
				webSocketMap.get(key).getSession().getBasicRemote().sendText(res.toString());
				break;
			}
		}
	}
	
	/**
	 * @Author
	 * @Description 群发
	 * @param message
	 * @param fromName
	 * @throws IOException
	 */
	public static void sendToAll(String message, String fromName) throws IOException {
		if(StringUtils.isBlank(message)) {
			log.error("参数为空!");
		}
		for(String key : webSocketMap.keySet()) {
			if(!key.equals(fromName)) {
				webSocketMap.get(key).getSession().getBasicRemote().sendText("用户：" + fromName + "says: " + message);
			}
		}
	}
	
	/**
	 * @Author
	 * @Description 更新大厅用户
	 * @param fromName
	 * @param users
	 * @throws IOException
	 */
	public static void sendUserInfoToAll(String fromName) throws IOException {
		if(StringUtils.isBlank(fromName)) {
			log.error("参数有误!");
		}
		for(String key : webSocketMap.keySet()) {
			if(!key.equals(fromName)) {
				JSONObject res = new JSONObject();
				res.put("flag", "2");
				res.put("text", fromName);
				webSocketMap.get(key).getSession().getBasicRemote().sendText(res.toString());
			}
		}
	}

}
