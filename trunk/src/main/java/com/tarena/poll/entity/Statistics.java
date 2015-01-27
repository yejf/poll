package com.tarena.poll.entity;

import java.util.Date;

/***************************
 * 统计 类
 * @author yejf
 *
 */
public class Statistics {
	
	/* 调查 ID */
	private int pollId;

	/* 用户名 */
	private String realName;
	
	/* 用户邮箱 add by yejf on 2009/11/03 11:32 */
	private String email;
	
	/* 班级名 */
	private String className;
	/* 班级类型 */
	private String classType;
	
	/* 总份数 */
	private int amount;
	/* 有效份数 */
	private int validAmount;
	/* 平均分数 */
	private float avgScore;
	/* 创建时间 */
	private Date createdDate;
	
	/* 结束时间*/
	private Date overDate;
	
	/* 审核时间 */
	private Date checkedDate;
	
	/* 用户类型 */
	private int userType;
	
	public Statistics() {
	}
	
	public Statistics(String realName, String className, String classType,int amount, int validAmount, float avgScore, Date createdDate) {
		this.realName = realName;
		this.className = className;
		this.classType = classType;
		this.amount = amount;
		this.validAmount = validAmount;
		this.avgScore = avgScore;
		this.createdDate = createdDate;
	}
	
	public Statistics(String realName, String className, String classType, int amount, int validAmount, float avgScore, Date createdDate, Date overDate, Date checkedDate, int userType) {
		this.realName = realName;
		this.className = className;
		this.classType = classType;
		this.amount = amount;
		this.validAmount = validAmount;
		this.avgScore = avgScore;
		this.createdDate = createdDate;
		this.overDate = overDate;
		this.checkedDate = checkedDate;
		this.userType = userType;
	}

	public Statistics(int pollId, String realName, String className, String classType, int amount, int validAmount, float avgScore, Date createdDate, Date overDate, Date checkedDate, int userType) {
		this.pollId = pollId;
		this.realName = realName;
		this.className = className;
		this.classType = classType;
		this.amount = amount;
		this.validAmount = validAmount;
		this.avgScore = avgScore;
		this.createdDate = createdDate;
		this.overDate = overDate;
		this.checkedDate = checkedDate;
		this.userType = userType;
	}

	/**
	 * @return the amount
	 */
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
	 * @return the avgScore
	 */
	public float getAvgScore() {
		return avgScore;
	}
	/**
	 * @param avgScore the avgScore to set
	 */
	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the validAmount
	 */
	public int getValidAmount() {
		return validAmount;
	}
	/**
	 * @param validAmount the validAmount to set
	 */
	public void setValidAmount(int validAmount) {
		this.validAmount = validAmount;
	}

	/**
	 * @return the pollId
	 */
	public int getPollId() {
		return pollId;
	}

	/**
	 * @param pollId the pollId to set
	 */
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}

	public Statistics(int pollId, String realName, String className, String classType, int amount, int validAmount, float avgScore, Date createdDate) {
		this.pollId = pollId;
		this.realName = realName;
		this.className = className;
		this.classType = classType;
		this.amount = amount;
		this.validAmount = validAmount;
		this.avgScore = avgScore;
		this.createdDate = createdDate;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer("[");
		str.append(pollId).append(',')
			.append(realName).append(',')
			.append(className).append(',')
			.append(classType).append(',')
			.append(amount).append(',')
			.append(validAmount).append(',')
			.append(avgScore).append(',')
			.append(createdDate).append("]");
		return str.toString();
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Date getOverDate() {
		return overDate;
	}

	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}

	/**
	 * @return the checkedDate
	 */
	public Date getCheckedDate() {
		return checkedDate;
	}

	/**
	 * @param checkedDate the checkedDate to set
	 */
	public void setCheckedDate(Date checkedDate) {
		this.checkedDate = checkedDate;
	}

	/**
	 * @return the userType
	 */
	public int getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}






