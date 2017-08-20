package com.cheng.mybatis.user.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author chengyin
 * @since 2017-08-19
 */
public class User{


	private Integer id;
    /**
     * 用户名
     */
	private String userName;
    /**
     * 用户账号
     */
	private String userAccount;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 备注
     */
	private String remark;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", userName=" + userName +
			", userAccount=" + userAccount +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", remark=" + remark +
			"}";
	}
}
