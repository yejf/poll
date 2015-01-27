package com.tarena.poll.pmo.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.biz.IStatisticsBiz;
import com.tarena.poll.biz.impl.PollBizImpl;
import com.tarena.poll.entity.Statistics;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.pmo.forms.StatisticsForm;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.statics.ForwardPath;
/**
 * 报表相关类及方法
 * @author liuxiaofei
 *
 */
public class StatisticsAction extends MappingDispatchAction {
	/**
	 * 去到月报表查询页面
	 */
	public ActionForward toQueryByYM(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH)+1;
		String year = String.valueOf(y);
		String month = String.valueOf(m);
		
		Map<String, List> groupByPM = new HashMap<String, List>();
		IPollBiz biz = new PollBizImpl();
		List<TPoll> queryByM = biz.selectPollsByYearAndMonth(y, m);
		for(int i = 0;i<queryByM.size();i++){
			int index =i;
			List<TPoll> PMStatic = new ArrayList<TPoll>();
			String realName = queryByM.get(i).getUser().getRealName();
			for(int j = i+1; j<queryByM.size(); j++){
				String userName = queryByM.get(j).getUser().getRealName();
				if(realName.equals(userName)){
					TPoll stas = queryByM.get(j);
					PMStatic.add(stas);
					//queryByM.remove(j);
					i=j;
				}
			}
			PMStatic.add(queryByM.get(index));
			groupByPM.put(realName, PMStatic);
		}
		request.setAttribute(ContextKey.YEAR, year);
		request.setAttribute(ContextKey.MONTH, month);
		request.setAttribute(ContextKey.GROUP_BY_PM, groupByPM);
		return mapping.findForward(ForwardPath.PMO_POLL_TO_QUERY_M);
	}
	/**
	 * 按月查询报表
	 */
	public ActionForward queryResultByYM(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		StatisticsForm statistics_form = (StatisticsForm)form;
		String year = statistics_form.getYear();
		String month = statistics_form.getMonth();
		
		Map<String, List> groupByPM = new HashMap<String, List>();
		IPollBiz biz = new PollBizImpl();
		List<TPoll> queryByM = biz.selectPollsByYearAndMonth(Integer.parseInt(year),Integer.parseInt(month));
		for(int i = 0;i<queryByM.size();i++){
			int index =i;
			List<TPoll> PMStatic = new ArrayList<TPoll>();
			String realName = queryByM.get(i).getUser().getRealName();
			for(int j = i+1; j<queryByM.size(); j++){
				String userName = queryByM.get(j).getUser().getRealName();
				if(realName.equals(userName)){
					TPoll stas = queryByM.get(j);
					PMStatic.add(stas);
					//queryByM.remove(j);
					i=j;
				}
			}
			PMStatic.add(queryByM.get(index));
			groupByPM.put(realName, PMStatic);
		}
		request.setAttribute(ContextKey.YEAR, year);
		request.setAttribute(ContextKey.MONTH, month);
		request.setAttribute(ContextKey.GROUP_BY_PM, groupByPM);
		return mapping.findForward(ForwardPath.PMO_POLL_QUERY_M);
	}
	
	/**
	 * 去到季度报表页面
	 */
	public ActionForward toQueryByQ(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH)+1;
		int quarter=0;
		String year = String.valueOf(y);
		if(m>=1&&m<=3){
			quarter = 1;
		} else if(m>=4&&m<=6){
			quarter = 2;
		} else if(m>=7&&m<=9){
			quarter = 3;
		} else if(m>=10&&m<=12){
			quarter = 4;
		}
		
		Map<String, List> groupByPM = new HashMap<String, List>();
		IPollBiz biz = new PollBizImpl();
		List<TPoll> queryByQ = biz.selectPollsByYearAndQuarter(y, quarter);
		for(int i = 0;i<queryByQ.size();i++){
			int index = i;
			List<TPoll> PMStatic = new ArrayList<TPoll>();
			String realName = queryByQ.get(i).getUser().getRealName();
			for(int j = i+1; j<queryByQ.size(); j++){
				String userName = queryByQ.get(j).getUser().getRealName();
				if(realName.equals(userName)){
					TPoll stas = queryByQ.get(j);
					PMStatic.add(stas);
					//queryByQ.remove(j);
					i=j;
				}
			}
			PMStatic.add(queryByQ.get(index));
			groupByPM.put(realName, PMStatic);
		}
		request.setAttribute(ContextKey.YEAR, year);
		request.setAttribute(ContextKey.QUARTER, quarter);
		request.setAttribute(ContextKey.GROUP_BY_PM, groupByPM);
		return mapping.findForward(ForwardPath.PMO_POLL_TO_QUERY_Q);
	}
	/**
	 * 按季度查询报表
	 */
	public ActionForward queryResultByQuarter(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		StatisticsForm statistics_form = (StatisticsForm)form;
		String year = statistics_form.getYear();
		int quarter = Integer.parseInt(statistics_form.getQuarter());
		
		Map<String, List> groupByPM = new HashMap<String, List>();
		IPollBiz biz = new PollBizImpl();
		List<TPoll> queryByQ = biz.selectPollsByYearAndQuarter(Integer.parseInt(year), quarter);
		for(int i = 0;i<queryByQ.size();i++){
			int index = i;
			List<TPoll> PMStatic = new ArrayList<TPoll>();
			String realName = queryByQ.get(i).getUser().getRealName();
			for(int j = i+1; j<queryByQ.size(); j++){
				String userName = queryByQ.get(j).getUser().getRealName();
				if(realName.equals(userName)){
					TPoll stas = queryByQ.get(j);
					PMStatic.add(stas);
					//queryByQ.remove(j);
					i=j;
				}
			}
			PMStatic.add(queryByQ.get(index));
			groupByPM.put(realName, PMStatic);
		}
		request.setAttribute(ContextKey.YEAR, year);
		request.setAttribute(ContextKey.QUARTER, quarter);
		request.setAttribute(ContextKey.GROUP_BY_PM, groupByPM);
		return mapping.findForward(ForwardPath.PMO_POLL_QUERY_Q);
	}
	/**
	 * 去年报表页面
	 */
	public ActionForward toQueryByY(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//IStatisticsBiz isb = new StatisticsBizImpl();
		IPollBiz ipb=new PollBizImpl();
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		String year = String.valueOf(y);
		
		Map<String, List> groupByPM = new HashMap<String, List>();
		
		List<TPoll> queryByY = ipb.selectPollsByYear(y);
		for(int i = 0;i<queryByY.size();i++){
			int index = i;
			List<TPoll> PMStatic = new ArrayList<TPoll>();
			String realName = queryByY.get(i).getUser().getRealName();
			for(int j = i+1; j<queryByY.size(); j++){
				String userName = queryByY.get(j).getUser().getRealName();
				if(realName.equals(userName)){
					TPoll stas = queryByY.get(j);
					PMStatic.add(stas);
					//queryByY.remove(j);
					i=j;
				}
			}
			PMStatic.add(queryByY.get(index));
			groupByPM.put(realName, PMStatic);
		}
		request.setAttribute(ContextKey.YEAR, year);
		request.setAttribute(ContextKey.GROUP_BY_PM, groupByPM);
		return mapping.findForward(ForwardPath.PMO_POLL_TO_QUERY_Y);	
	}
	/**
	 * 按年查询报表
	 */
	public ActionForward queryResultByYear(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		StatisticsForm statistics_form = (StatisticsForm)form;
		String year = statistics_form.getYear();
		
		Map<String, List> groupByPM = new HashMap<String, List>();
		IPollBiz ipb=new PollBizImpl();
		List<TPoll> queryByY = ipb.selectPollsByYear(Integer.parseInt(year));
		for(int i = 0;i<queryByY.size();i++){
			int index = i;
			List<TPoll> PMStatic = new ArrayList<TPoll>();
			String realName = queryByY.get(i).getUser().getRealName();
			for(int j = i+1; j<queryByY.size(); j++){
				String userName = queryByY.get(j).getUser().getRealName();
				if(realName.equals(userName)){
					TPoll stas = queryByY.get(j);
					PMStatic.add(stas);
					//queryByY.remove(j);
					i=j;
				}
			}
			PMStatic.add(queryByY.get(index));
			groupByPM.put(realName, PMStatic);
		}
		request.setAttribute(ContextKey.YEAR, year);
		request.setAttribute(ContextKey.GROUP_BY_PM, groupByPM);
		return mapping.findForward(ForwardPath.PMO_POLL_QUERY_Y);
	}
}
