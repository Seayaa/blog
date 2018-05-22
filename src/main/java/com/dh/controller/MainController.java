package com.dh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dh.commons.DateFormateService;
import com.dh.entity.core.Blogger;
import com.dh.redis.RedisService;
import com.dh.redis.impl.StringRedisServiceImpl;
import com.dh.service.core.BloggerService;

@Controller
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	private static final SimpleDateFormat df = DateFormateService.getSimpledateFormat();
	
	@Autowired
	private BloggerService bloggerService;
	
	@Autowired
	private RedisService redisService;
	
	/*@Autowired
	private StringRedisServiceImpl redisService;*/
	
	@RequestMapping("login")
	public String login() {
		log.debug(">>---------------login---------------<<");
		return "login";
	}
	
	@RequestMapping("index")
	public String Index() {
		log.debug(">>---------------home---------------<<");
		return "index";
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("chat")
	public String chat() {
		return "Chat";
	}
	
	@RequestMapping("personal")
	public String personal() {
		return "personal/index";
	}
	
	/**
	 * @Author
	 * @Description 注册
	 * @param response
	 * @param request
	 * @param blogger
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping("doRegister")
	@ResponseBody
	public int doRegister(HttpServletResponse response, HttpServletRequest request, Blogger blogger,
			String birth) throws IOException, ParseException {
		int res;
		blogger.setBirthday(df.parse(birth));
		res = bloggerService.addBlogger(blogger);
		return res;
	}
	
	/**
	 * @Author
	 * @Description 登录验证
	 * @param account
	 * @param password
	 * @param code
	 * @param request
	 * @return JSONObject
	 */
	@RequestMapping("loginDo")
	@ResponseBody
	public JSONObject loginDo(@RequestParam("account")String account,
			@RequestParam("password")String password,
			@RequestParam("code")String code,HttpServletRequest request) {
		JSONObject result = new JSONObject();
		String session_code = request.getSession().getAttribute("code").toString();
		if(StringUtils.isBlank(code) || !session_code.equals(code)) {
			result.put("flag", "0");
			result.put("msg", "验证码错误");
			return result;
		}
		Blogger blogger = new Blogger();
		blogger.setAccount(account);
		blogger.setPassword(DigestUtils.md5Hex(password));
		int res = bloggerService.checkBlogger(blogger, request);
		if(res == 1) {
			result.put("flag", "1");
			result.put("msg", "验证通过");
		}
		else if(res == 0) {
			result.put("flag", "0");
			result.put("msg", "密码错误");
		}
		else if(res == 2) {
			result.put("flag", "0");
			result.put("msg", "账号不存在");
		}
		return result;
	}
	
	@RequestMapping("redis")
	public String redis() {
		return "redis";
	}
	
	@GetMapping("set")
	public String testRedis(String key, String value, String duration) {
		redisService.setValue(key, value, Long.parseLong(duration));	
		return "redis";
	}
	
	@GetMapping("get")
	@ResponseBody
	public JSONObject getRedis(String key) {
		JSONObject res = new JSONObject();
		Object num = redisService.getValue(key);
		if(num != null) {
			res.put("res", num.toString());			
		}
		else {
			res.put("res", "null");
		}
		return res;
	}
	
	@RequestMapping("setObj")
	public String setObj(String key, String name, String age) {
		Map<String, Object> obj = new HashMap<>();
		obj.put("name", name);
		obj.put("age", age);
		redisService.setValue(key, obj);
		return "redis";
	}
	
	@RequestMapping("getObj")
	@ResponseBody
	public Map<String, Object> getObj(String key){
		Map<String, Object> res = new HashMap<>();
		System.out.println(new Date().getTime());
		Object obj = redisService.getValue(key);
		System.out.println(new Date().getTime());
		res.put("res", obj.toString());
		return res;
	}
	
	/*@RequestMapping("set")
	public void set(String value) {
		redisService.setValue("num", value);
	}
	
	@RequestMapping("get")
	@ResponseBody
	public Map<String, String> get(){
		Map<String, String> res = new HashMap<>();
		Object num = redisService.getValue("num");
		res.put("msg", num.toString());
		return res;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
