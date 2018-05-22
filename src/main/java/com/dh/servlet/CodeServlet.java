package com.dh.servlet;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dh.util.CodeImgUtil;

@WebServlet(urlPatterns = "/getCodeImg/*", loadOnStartup = 5)
public class CodeServlet extends HttpServlet{

	private static final long serialVersionUID = -7594368308756733935L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = CodeImgUtil.generateCodeAndPic();
		
		HttpSession session = req.getSession();
		session.setAttribute("code", map.get("code"));
		
		//禁止图像缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Expires", "-1");
		resp.setContentType("img/jpeg");
		
		ServletOutputStream out = null;
		
		try {
			out = resp.getOutputStream();
			ImageIO.write((RenderedImage)map.get("codePic"), "jpeg", out);
			out.close();			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
