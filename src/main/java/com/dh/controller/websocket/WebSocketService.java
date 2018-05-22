package com.dh.controller.websocket;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

@ServerEndpoint(value = "/websocket/{userName}")
public class WebSocketService {

	/**
	 *  连接用户
	 */
	private String userName;
	
	private Session session;
	
	private static final Logger log = LoggerFactory.getLogger(WebSocketService.class);
	
	/*
	 * 建立连接
	 */
	@OnOpen
	public void onOpen(@PathParam("userName")String userName, Session session) throws IOException, EncodeException {
		this.userName = userName;
		this.session = session;
		log.info("用户{}建立连接!", userName);
		WebSocketPool.addWebSocketToMap(this, userName);
		
		//返回当前大厅用户
		JSONObject res = new JSONObject();
		StringBuffer str = new StringBuffer();
		for(String key : WebSocketPool.webSocketMap.keySet()) {
			str.append(key).append(";");
		}
		res.put("flag", "1");
		res.put("text", str.deleteCharAt(str.length() - 1).toString());
		this.session.getBasicRemote().sendText(res.toString());
		
		WebSocketPool.sendUserInfoToAll(userName);
	}

	/*
	 * 连接出错
	 */
	@OnError
	public void onError(Throwable error, @PathParam("userName")String userName) {
		error.printStackTrace();
		log.error("用户  {} 连接出错了!", userName);
	}
	
	/**
	 * @Author
	 * @Description 断开连接
	 * @param userName
	 */
	@OnClose
	public void onClose(@PathParam("userName")String userName) {
		log.info("用户{}断开连接!", userName);
		WebSocketPool.removeWebSocketFromMap(userName);
	}
	
	/**
	 * @Author
	 * @Description 发送消息
	 * @param message
	 * @param userName
	 * @throws IOException
	 */
	@OnMessage
	public void onMessage(String message, @PathParam("userName")String userName) throws IOException {
		String[] str = message.split("\\|\\|");
		String text = str[0];
		String toName = str[1];
		if(toName.equals("ALL")) {
			WebSocketPool.sendToAll(text, userName);
		}
		else {
			WebSocketPool.sendToUser(text, toName, userName);			
		}
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
