package com.tarena.poll.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/******************
 * 用户
 * @author yejf
 *
 */
@Entity
@Table(name="TBL_TUSER")
public class TUser implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7924133727876679606L;

	/* 主键 */
	private Integer id;
	 
	/* 用户名 */
	private String name;
	 
	/* 密码 */
	private String passwd;
	
	/*真实姓名*/
	private String realName;
	 
	/* 用户类型: 超级管理员1，班主任2，教师3，。。。 */
	private int type;
	
	/* 职位 **/
	private String description ;
	
	/* 用户状态 0代表正常，1代表离职,... **/
	private int status = 0;
	 
	/** 用户邮箱 */
	private String email;
	
	/* 属性用户的调查 */
	private List<TPoll> polls;

	public TUser() {
	}
	
	
	public TUser(String name, String passwd, String realName, int type,
			int status) {
		super();
		this.name = name;
		this.passwd = passwd;
		this.realName = realName;
		this.type = type;
		this.status = status;
	}


	public TUser(String name, String passwd, int type) {
		this.name = name;
		this.passwd = passwd;
		this.type = type;
	}

	public TUser(Integer id, String name, String passwd, int type) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.type = type;
	}

	public TUser(Integer id, String name, String passwd, int type, List<TPoll> polls) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.type = type;
		this.polls = polls;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@Column
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passwd
	 */
	@Column
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the polls
	 */
	@OneToMany(mappedBy="user")
	public List<TPoll> getPolls() {
		return polls;
	}

	/**
	 * @param polls the polls to set
	 */
	public void setPolls(List<TPoll> polls) {
		this.polls = polls;
	}

	/**
	 * @return the type
	 */
	@Column
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	@Column
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
	
}

 
