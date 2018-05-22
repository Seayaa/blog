package com.dh.service.core;

import javax.servlet.http.HttpServletRequest;

import com.dh.entity.core.Blogger;

public interface BloggerService {

	/**
	 * @Description 添加博主信息
	 * @param blogger
	 * @return
	 */
	int addBlogger(Blogger blogger);

	/**
	 * @Author
	 * @Description 身份验证 
	 * @param blogger
	 * @return int 0:密码错误； 1：验证通过； 2：找不到账户
	 */
	int checkBlogger(Blogger blogger, HttpServletRequest request);
}
