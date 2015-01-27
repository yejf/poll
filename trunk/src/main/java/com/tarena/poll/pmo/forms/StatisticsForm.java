package com.tarena.poll.pmo.forms;

import org.apache.struts.action.ActionForm;
/**
 * 封装报表查询时，所需要的参数
 * @author liuxiaofei
 *
 */
public class StatisticsForm extends ActionForm {

	private static final long serialVersionUID = 4888236778696374217L;
	private int classId;
	private int userId;
	private String year;
	private String month;
	private String quarter;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
}
