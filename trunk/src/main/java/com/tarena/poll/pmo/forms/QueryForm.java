package com.tarena.poll.pmo.forms;

import java.util.Date;

import com.tarena.poll.commons.format.DateFormat;
import com.tarena.poll.commons.log.LogOutPut;

import org.apache.struts.action.ActionForm;

/*************
 * 用来封装已审调查页面当中要封装的搜索条件
 * @author liuxiaofei
 *
 */
public class QueryForm extends ActionForm {
	private static final long serialVersionUID = -3993225754445291856L;
	private int className;
	private int pm;
	private String startdate;
	private String enddate;
	
	public int getClassName() {
		LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>getClassName()");
		return className;
	}
	public void setClassName(int className) {
		LogOutPut.getInstance().debug("**********************className"+className);
		this.className = className;
	}
	public int getPm() {
		LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>getPm()");
		return pm;
	}
	public void setPm(int pm) {
		LogOutPut.getInstance().debug("**********************pm"+pm);
		this.pm = pm;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	
}
