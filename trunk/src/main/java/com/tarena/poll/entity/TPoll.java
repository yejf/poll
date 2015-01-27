package com.tarena.poll.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/* 调查 */
@Entity
@Table(name="TBL_TPOLL")
public class TPoll implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 主键 */
	private Integer id;
	 
	/* 调查日期 */
	private Date created_date;
	
	/* 结束日期 add by yejf on 2009/01/02 */
	private Date over_date;
	 
	/* 审核日期 */
	private Date checked_date;
	 
	/* 状态  n刚创建  y结束调查  Y审核完成 */
	private char status;
	 
	/* 调查份数 */
	private int amount;
	 
	/* 所有调查项文字描述 */
	private String contents;
	
	/* 有效份数 */
	private int valid_amount;
	 
	/* 总分数 */
	private int total_score;
	 
	/* 平均分数 */
	private float avg_score;
	 
	/* 调查对应的班级 */
	private TClass clazz;
	 
	/* 调查内容 */
	private List<TPollLine> pollLines;
	 
	/* 调查对像[用户] */
	private TUser user;
	
	/* 调查模板 */
	private TPollTemplate template;
	

	/**
	 * @return the amount
	 */
	@Column
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the avg_score
	 */
	@Column
	public float getAvg_score() {
		return avg_score;
	}

	/**
	 * @param avg_score the avg_score to set
	 */
	public void setAvg_score(float avg_score) {
		this.avg_score = avg_score;
	}

	/**
	 * @return the checked_date
	 */
	@Temporal(TemporalType.DATE)
	public Date getChecked_date() {
		return checked_date;
	}

	/**
	 * @param checked_date the checked_date to set
	 */
	public void setChecked_date(Date checked_date) {
		this.checked_date = checked_date;
	}

	/**
	 * @return the clazz
	 */
	@ManyToOne
	@JoinColumn(name="clazz_id",nullable=false)
	public TClass getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(TClass clazz) {
		this.clazz = clazz;
	}

	/**
	 * @return the created_date
	 */
	@Temporal(TemporalType.DATE)
	public Date getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
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
	 * @return the pollLines
	 */
	@OneToMany(mappedBy="poll")
	public List<TPollLine> getPollLines() {
		return pollLines;
	}

	/**
	 * @param pollLines the pollLines to set
	 */
	public void setPollLines(List<TPollLine> pollLines) {
		this.pollLines = pollLines;
	}

	/**
	 * @return the status
	 */
	@Column
	public char getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * @return the total_score
	 */
	@Column
	public int getTotal_score() {
		return total_score;
	}

	/**
	 * @param total_score the total_score to set
	 */
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}

	/**
	 * @return the user
	 */
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	public TUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(TUser user) {
		this.user = user;
	}

	/**
	 * @return the valid_amount
	 */
	@Column
	public int getValid_amount() {
		return valid_amount;
	}

	/**
	 * @param valid_amount the valid_amount to set
	 */
	public void setValid_amount(int valid_amount) {
		this.valid_amount = valid_amount;
	}

	/**
	 * @return the over_date
	 */
	@Temporal(TemporalType.DATE)
	public Date getOver_date() {
		return over_date;
	}

	/**
	 * @param over_date the over_date to set
	 */
	public void setOver_date(Date over_date) {
		this.over_date = over_date;
	}

	@ManyToOne
	@JoinColumn(name="template_id",nullable=false)
	public TPollTemplate getTemplate() {
		return template;
	}

	public void setTemplate(TPollTemplate template) {
		this.template = template;
	}

	@Column(length=2000)
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	

	 
	
}
 
