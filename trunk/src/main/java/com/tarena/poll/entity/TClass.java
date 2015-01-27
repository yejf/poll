package com.tarena.poll.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*********************
 * 班级实体
 * @author yejf
 *
 */
@Entity
@Table(name="TBL_CLASS")
public class TClass implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8216059835405688135L;

	/* 主键 */
	private Integer id;
	 
	/* 班级名 */
	private String className;
	 
	/* 班级类型 */
	private TClassType classType;
	
	/* IP */
	private String classIP;
	
	/* status  1已毕业  0未毕业*/
	private int status;
	 
	/* 备注 */
	private String remark;
	 
	private List<TPoll> poll;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	@Column
	public String getClassIP() {
		return classIP;
	}

	public void setClassIP(String classIP) {
		this.classIP = classIP;
	}
	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Column
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@OneToMany(mappedBy="clazz")
	public List<TPoll> getPoll() {
		return poll;
	}

	public void setPoll(List<TPoll> poll) {
		this.poll = poll;
	}

	@ManyToOne
	@JoinColumn(name="classType_id",nullable=false)
	public TClassType getClassType() {
		return classType;
	}

	public void setClassType(TClassType classType) {
		this.classType = classType;
	}

	public TClass() {
	}

	public TClass(Integer id, String className, TClassType classType,
			String classIP, int status, String remark, List<TPoll> poll) {
		super();
		this.id = id;
		this.className = className;
		this.classType = classType;
		this.classIP = classIP;
		this.status = status;
		this.remark = remark;
		this.poll = poll;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TClass [id=");
		builder.append(id);
		builder.append(", className=");
		builder.append(className);
		builder.append(", classType=");
		builder.append(classType);
		builder.append(", classIP=");
		builder.append(classIP);
		builder.append(", status=");
		builder.append(status);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", poll=");
		builder.append(poll);
		builder.append("]");
		return builder.toString();
	}
	 
}
 
