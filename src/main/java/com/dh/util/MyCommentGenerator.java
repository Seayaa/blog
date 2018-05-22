package com.dh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * @Title
 * @Description 自定义注释生成器
 * @author Administrator
 * @date 2018年3月14日
 */
public class MyCommentGenerator implements CommentGenerator{

	private String currentDate;
	
	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public MyCommentGenerator() {
		super();
		this.currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	@Override
	public void addClassAnnotation(InnerClass arg0, IntrospectedTable arg1, Set<FullyQualifiedJavaType> arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClassComment(InnerClass arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub
		arg0.addJavaDocLine("/**");
		StringBuilder ch = new StringBuilder();
		ch.append(" * ");
		ch.append(arg1.getFullyQualifiedTable()).append(" ").append(getCurrentDate());
		arg0.addJavaDocLine(ch.toString().replace("\n", " "));
		arg0.addJavaDocLine(" */");
		
	}

	@Override
	public void addClassComment(InnerClass arg0, IntrospectedTable arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComment(XmlElement arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addConfigurationProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEnumComment(InnerEnum arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFieldAnnotation(Field arg0, IntrospectedTable arg1, Set<FullyQualifiedJavaType> arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFieldAnnotation(Field arg0, IntrospectedTable arg1, IntrospectedColumn arg2,
			Set<FullyQualifiedJavaType> arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFieldComment(Field arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFieldComment(Field arg0, IntrospectedTable arg1, IntrospectedColumn arg2) {
		// TODO Auto-generated method stub
		StringBuilder ch = new StringBuilder();
		arg0.addJavaDocLine("/**");
		ch.append(" * ");
		ch.append(arg2.getRemarks());
		arg0.addJavaDocLine(ch.toString().replace("\n", " "));
		arg0.addJavaDocLine(" */");
	}

	@Override
	public void addGeneralMethodAnnotation(Method arg0, IntrospectedTable arg1, Set<FullyQualifiedJavaType> arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGeneralMethodAnnotation(Method arg0, IntrospectedTable arg1, IntrospectedColumn arg2,
			Set<FullyQualifiedJavaType> arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGeneralMethodComment(Method arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGetterComment(Method arg0, IntrospectedTable arg1, IntrospectedColumn arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJavaFileComment(CompilationUnit arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addModelClassComment(TopLevelClass arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addRootComment(XmlElement arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSetterComment(Method arg0, IntrospectedTable arg1, IntrospectedColumn arg2) {
		// TODO Auto-generated method stub
		
	}

}
