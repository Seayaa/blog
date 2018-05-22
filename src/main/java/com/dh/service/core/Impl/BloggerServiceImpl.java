package com.dh.service.core.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.commons.DateFormateService;
import com.dh.entity.core.Blogger;
import com.dh.entity.core.BloggerExample;
import com.dh.mapper.core.BloggerMapper;
import com.dh.redis.RedisService;
import com.dh.service.core.BloggerService;
import com.dh.util.UUIDUtil;

@Service
public class BloggerServiceImpl implements BloggerService{
	
	private static final long duration = 30L;
	
	private static final SimpleDateFormat df = DateFormateService.getSimpledateFormat();
	
	@Autowired
	private BloggerMapper bloggerMapper;
	
	@Autowired
	private RedisService redisService;
	
	@Override
	public int addBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		int res = -1;
		blogger.setCreateTime(new Date());
		blogger.setUid(UUIDUtil.getUUID());
		blogger.setPassword(DigestUtils.md5Hex(blogger.getPassword()));
		try {
			res = bloggerMapper.insertSelective(blogger);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	/* 
	 * 身份验证 
	 */
	@Override
	public int checkBlogger(Blogger blogger, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int res = 0;
		BloggerExample exam = new BloggerExample();
		exam.or().andAccountEqualTo(blogger.getAccount());
		System.out.println(new Date().getTime());
		List<Blogger> list = bloggerMapper.selectByExample(exam);
		System.out.println(new Date().getTime());
		if(list.size() <= 0) {
			res = 2;
		}
		else {
			Blogger blogg = list.get(0);
			if(blogg.getPassword().equals(blogger.getPassword())) {
				res = 1;
				blogg.setPassword(null);
				request.getSession().setAttribute("blogger", blogg);
				redisService.setValue(request.getSession().getId(), blogg, duration);
			}
		}
		return res;
	}

}
