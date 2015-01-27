package com.tarena.poll.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**********
 * 调查项
 * @author yejf
 * <p>
 * 	此项可采用内存加载XML方式
 * </p>
 */
@Entity
@Table(name="TBL_TPOLLCONTENT")
public class TPollContent implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 主键 */
	private Integer id;
	 
	/* 调查项 */
	private String content;
	
	/* 授课实施  学习管理  问题  */
	private String type;
	
	/* 1.默认   2.使用  */
	private int status;
	
	
	private List<TPollTemplate>  models;
	
	public TPollContent() {
	}

	public TPollContent(String content) {
		this.content = content;
	}

	
	
	public TPollContent(Integer id, String content, String type, int status) {
		super();
		this.id = id;
		this.content = content;
		this.type = type;
		this.status = status;
	}

	/**
	 * @return the content
	 */
	@Column
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the type
	 */
	@Column
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(mappedBy="contents")
	public List<TPollTemplate> getModels() {
		return models;
	}

	public void setModels(List<TPollTemplate> models) {
		this.models = models;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	 
	
}
 
