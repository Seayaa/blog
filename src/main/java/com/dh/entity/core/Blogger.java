package com.dh.entity.core;

import java.io.Serializable;
import java.util.Date;

public class Blogger implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4170112741603110081L;

	/**
     * 
     */
    private Long id;

    /**
     * 博主ID
     */
    private String uid;

    /**
     * 博主账号
     */
    private String account;

    /**
     * 博主昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别。0：男；1：女
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 地区
     */
    private String location;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}