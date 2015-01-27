package com.tarena.poll.pmo.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.tarena.poll.biz.IClazzBiz;
import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.biz.IUserBiz;
import com.tarena.poll.biz.impl.ClazzBizImpl;
import com.tarena.poll.biz.impl.PollBizImpl;
import com.tarena.poll.biz.impl.UserBizImpl;
import com.tarena.poll.pmo.forms.QueryForm;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.statics.ForwardPath;
import com.tarena.poll.commons.format.DateFormat;;
/**
 * 查询对应的action
 * @author liuxiaofei
 *
 */
public class QueryAction extends MappingDispatchAction {
	/*
	 * 预加载搜索时所需要的信息
	 */
	public ActionForward toPollQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollBiz ipb = new PollBizImpl();
		IClazzBiz icb = new ClazzBizImpl();
		IUserBiz iub = new UserBizImpl();
		List classList = icb.getByStatus(0);
		List pmList = iub.findAllPM();
		List list = ipb.selectPollsByStatus('o');
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		request.setAttribute(ContextKey.POLL_LIST, list);
		return mapping.findForward(ForwardPath.PMO_POLL_TO_QUERY);
	}
	/*
	 * 搜索
	 */
	public ActionForward pollQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollBiz ipb = new PollBizImpl();
		IUserBiz iub = new UserBizImpl();
		IClazzBiz icb = new ClazzBizImpl();
		QueryForm queryForm = (QueryForm)form;
		int classId = queryForm.getClassName();
		int userId = queryForm.getPm();
		String start = queryForm.getStartdate();
		String end = queryForm.getEnddate();
		Date startDate = DateFormat.getDate(start);
		Date endDate = DateFormat.getDate(end);
		List list = ipb.selectPollsByInfo(classId, userId, startDate, endDate);
		List classList = icb.getByStatus(0);
		List pmList = iub.findAllPM();
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		request.setAttribute(ContextKey.POLL_LIST, list);
		return mapping.findForward(ForwardPath.PMO_POLL_QUERY);
	}
}
