package com.tarena.poll.pmo.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.biz.IUserBiz;
import com.tarena.poll.biz.impl.PollBizImpl;
import com.tarena.poll.biz.impl.UserBizImpl;
import com.tarena.poll.commons.db.DBConfig;
import com.tarena.poll.commons.mail.SendMailInfo;
import com.tarena.poll.commons.mail.SendMailThread;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.statics.ForwardPath;
import com.tarena.poll.dao.IClassTypeDao;
import com.tarena.poll.dao.IPollContentDao;
import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.dao.impl.ClassTypeDaoImpl;
import com.tarena.poll.dao.impl.PollContentImpl;
import com.tarena.poll.dao.impl.PollTemplateDaoImpl;
import com.tarena.poll.entity.Statistics;
import com.tarena.poll.entity.TClassType;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollContent;
import com.tarena.poll.entity.TPollLine;
import com.tarena.poll.entity.TPollTemplate;
import com.tarena.poll.entity.TUser;
/**
 * 审核调查相关的类和方法
 * @author liuxiaofei
 *
 */
public class AuditAction extends MappingDispatchAction {
	/*
	 * 查询所有未审核的列表
	 */
	public ActionForward unauditPollList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollBiz ipb = new PollBizImpl();
		List list = ipb.selectPollsByStatus('y');
		request.setAttribute(ContextKey.UNAUDIT_POLL_LIST, list);//需要修改
		return mapping.findForward(ForwardPath.PMO_POLL_UNAUDIT);
	}
	/*
	 * 审核调查
	 */
	public ActionForward auditPoll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollBiz ipb = new PollBizImpl();
		
		if(isTokenValid(request, true)){
			int id = Integer.parseInt(request.getParameter("pollId"));
			String pollUserName = request.getParameter("pollUserName");
			String className = request.getParameter("className");
			String to_email = request.getParameter("email");
			
			TPoll poll = ipb.selectPollById(id);
			List pollLines = ipb.selectPollLineByPoll(poll);
			float avg_score = Float.parseFloat(request.getParameter("t_avg"));
			
			String[] ids = request.getParameterValues("isValid");
			if(ids!=null){
				Integer[] idNum = new Integer[ids.length];
				for(int i=0;i<ids.length;i++){
					idNum[i] = Integer.parseInt(ids[i]);
				}
				for(Object obj:pollLines){
					TPollLine tPollLine = (TPollLine)obj;
					for(int i = 0; i<idNum.length;i++){	
						if(tPollLine.getId().equals(idNum[i])){
							tPollLine.setIsValid('n');
						}
					}
				}
				poll.setValid_amount(poll.getValid_amount()-ids.length);
			}
			
			poll.setAvg_score(avg_score);
			poll.setPollLines(pollLines);
			poll.setStatus('o');
			poll.setChecked_date(new Date());
			//poll.setUser((TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER));
			ipb.updatePoll(poll);
			
			List unauditPollList = ipb.selectPollsByStatus('y');
			request.setAttribute(ContextKey.UNAUDIT_POLL_LIST, unauditPollList);
			
			//启动一个线程，在发送邮件
			//构造一个SendMailInfo对象
			if(poll.getValid_amount() >= 1) {
				SendMailInfo smi = new SendMailInfo();
				
				String host = DBConfig.getInstance().getValue("mail.smtp.host");
				String port = DBConfig.getInstance().getValue("mail.smtp.port");
				String auth = DBConfig.getInstance().getValue("mail.auth");
				String from = DBConfig.getInstance().getValue("mail.from");
				String name = DBConfig.getInstance().getValue("mail.user");
				String pwd = DBConfig.getInstance().getValue("mail.pwd");
				String cc = DBConfig.getInstance().getValue("mail.cc");
				String server_url = DBConfig.getInstance().getValue("server_url");
				
				//添加属性值
				smi.setTo(new String[] {to_email});
				smi.setFrom(from);
				if(cc.indexOf(",") != -1) {
					String[] cces = cc.split(",");
					smi.setCc(cces);
				} else {
					smi.setCc(new String[] {cc});
				}
				smi.setValidate(Boolean.parseBoolean(auth));
				smi.setUsername(name);
				smi.setPassword(pwd);
				smi.setSmtp_host(host);
				smi.setSmtp_port(port);
				
				smi.setSubject("你的调查已审核，请登录系统查看结果!");
				
				StringBuffer text = new StringBuffer("<b>"+pollUserName+",你好!</b><br/>");
				text.append("&nbsp;&nbsp;");
				text.append("<p>你所上课的班级 【");
				text.append(className);
				text.append("】的调查已经审核，请及时查看结果.</p>");
				text.append("<p>详情请点击登录：<a href='"+server_url+"'>点这里</a></P>");
				if(poll.getAvg_score() < 4.0f) {
					text.append("<div style='width: 200px;background-color: gray;font-size: 9pt;color: #0099cc;border: 1px solid green;'>")
						.append("分次反馈分值为:<font color='red'>3.7</font> <br/>")
						.append("Warning:<br/>")
						.append("<div style='text-indent: 2em;'>")
						.append("你的考评分处于4.0以下，请仔细查看学员的反馈信息，它可能帮助你发现隐藏的问题</div>")
						.append("</div>");
				}
				text.append("<b>谢谢！</b>");
				
				smi.setContent(text.toString());
				
				Thread t = new SendMailThread(smi);
				t.start();
			}
			
			return mapping.findForward(ForwardPath.PMO_POLL_AUDIT);
			
		} else{
			request.setAttribute("message", "对不起，您不能重复审核！");
			saveToken(request);
			return mapping.findForward("pmo_poll_audit_fail");
		}
	}
	/*
	 * 查看某个学生的调查详细信息
	 */
	public ActionForward pollLineDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int type = ((TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER)).getType();
		IPollBiz ipb = new PollBizImpl();
		int pollLineId = Integer.parseInt(request.getParameter("pollLineId"));
		int pollId=Integer.parseInt(request.getParameter("pollId"));
		TPollLine pollLine = ipb.selectPollLineById(pollLineId);
		TPoll poll=ipb.selectPollById(pollId);
		//考评项
		String[] arr1=poll.getContents().split(":");
		//分数
		char[] arr2=pollLine.getScores().toCharArray();
		//问题
		String[] arr3=pollLine.getQ1().split(":");
		Map<String, Integer> items=new HashMap<String, Integer>();
		Map<String, String> questions=new HashMap<String, String>();
		for(int i=0;i<arr1.length;i++){
			if(i<arr2.length){
				items.put(arr1[i], arr2[i]-'0');
				System.out.println(arr1[i]+"------->"+(arr2[i]-'0'));
			}else{
				questions.put(arr1[i], arr3[i-arr2.length]);
				System.out.println(arr1[i]+"------->"+(arr3[i-arr2.length]));
			}
			
		}
		request.setAttribute("items", items);
		request.setAttribute("questions", questions);
		request.setAttribute(ContextKey.POLL_LINE, pollLine);  //需要修改
		if(type == 1){
			return mapping.findForward(ForwardPath.PMO_POLL_LINE_DETAIL);
		}
		return mapping.findForward("pm_poll_line_detail");
	}
	/*
	 * 未审核的调查对应的明细，去明细页面审核
	 */
	public ActionForward unauditDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollBiz ipb = new PollBizImpl();
		int pollId = Integer.parseInt(request.getParameter("pollId"));
		TPoll poll = ipb.selectPollById(pollId);
		if(poll.getStatus()=='Y'){
			request.setAttribute("message", "对不起，该调查已经被审核，您不能查看明细，请去已审列表查看！去");
			return mapping.findForward("pmo_poll_unaudit_fail");
		}
		List<TPollLine> lines=ipb.selectPollLineByPoll(poll);
		Statistics stas=new Statistics();
		stas.setAmount(poll.getAmount());
		stas.setAvgScore(poll.getAvg_score());
		stas.setCheckedDate(poll.getChecked_date());
		stas.setClassName(poll.getClazz().getClassName());
		stas.setClassType(poll.getClazz().getClassType().getTypeName());
		stas.setCreatedDate(poll.getCreated_date());
		stas.setEmail(poll.getUser().getEmail());
		stas.setOverDate(poll.getOver_date());
		stas.setPollId(poll.getId());
		stas.setRealName(poll.getUser().getRealName());
		stas.setUserType(poll.getUser().getType());
		stas.setValidAmount(poll.getValid_amount());
		saveToken(request);
		request.setAttribute(ContextKey.UNAUDIT, stas);
		request.setAttribute(ContextKey.POLL_LINES, lines);  //需要修改
		int count=lines.get(0).getQ1().split(":").length;
		if(count!=0){
			int index=1;
			Map<Integer, List<String>> maps= new HashMap<Integer, List<String>>();
			List<String> answers=new ArrayList<String>();
			for(TPollLine tl:lines){
				String[] arr=tl.getQ1().split(":");
				for(String s:arr){
					answers.add(s);
				}
				maps.put(index++, answers);
				answers=new ArrayList<String>();
 			}
			request.setAttribute("maps", maps);
		}
		return mapping.findForward(ForwardPath.PMO_POLL_DETAIL);
	}
	
	public ActionForward auditedPoll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int type = ((TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER)).getType();
		IPollBiz ipb = new PollBizImpl();
		int id = Integer.parseInt(request.getParameter("pollId"));
		TPoll poll=ipb.selectPollById(id);
		List<TPollLine> lines=ipb.selectPollLineByPoll(poll);
		//List audited = ipb.selectPollLineByPollId(id);
		Statistics stas = new Statistics();
		stas.setAmount(poll.getAmount());
		stas.setAvgScore(poll.getAvg_score());
		stas.setCheckedDate(poll.getChecked_date());
		stas.setClassName(poll.getClazz().getClassName());
		stas.setClassType(poll.getClazz().getClassType().getTypeName());
		stas.setCreatedDate(poll.getCreated_date());
		stas.setEmail(poll.getUser().getEmail());
		stas.setOverDate(poll.getOver_date());
		stas.setPollId(poll.getId());
		stas.setValidAmount(poll.getValid_amount());
		stas.setRealName(poll.getUser().getRealName());
		stas.setUserType(poll.getUser().getType());
		saveToken(request);
		request.setAttribute(ContextKey.UNAUDIT, stas);
		request.setAttribute(ContextKey.POLL_LINES, lines);  //需要修改
		int count=lines.get(0).getQ1().split(":").length;
		if(count!=0){
			int index=1;
			Map<Integer, List<String>> maps= new HashMap<Integer, List<String>>();
			List<String> answers=new ArrayList<String>();
			for(TPollLine tl:lines){
				String[] arr=tl.getQ1().split(":");
				for(String s:arr){
					answers.add(s);
				}
				maps.put(index++, answers);
				answers=new ArrayList<String>();
 			}
			request.setAttribute("maps", maps);
		}
		request.setAttribute(ContextKey.AUDITED, stas);
		//request.setAttribute(ContextKey.POLL_LINES, audited);  //需要修改
		if(type==1){
			return mapping.findForward(ForwardPath.PMO_POLL_AUDITED);
		}
		return mapping.findForward("pm_poll_audited");
	}
	/**
	 *PMO 至班级类型新增
	 */
	public ActionForward toAddClassType(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("to_add_classtype");
	}
	/**
	 *PMO 班级类型新增
	 */
	public ActionForward addClassType(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IClassTypeDao dao = new ClassTypeDaoImpl();
		List<TClassType> types=dao.getTypes();
		String typeName=request.getParameter("addtype");
		for(TClassType t:types){
			if(t.getTypeName().equals(typeName)){
				request.setAttribute("error", "该班级已存在");
				return mapping.findForward("add_fail");
			}
		}
		TClassType type=new TClassType();
		type.setTypeName(typeName);
		dao.SaveType(type);
		return mapping.findForward("add_success");
	}
	/**
	 *PMO 教师管理
	 */
	public ActionForward toTeacherManege(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IUserBiz biz = new UserBizImpl();
		List<TUser> users=biz.findAllPMAndBzr();
		request.setAttribute("users", users);
		return mapping.findForward("to_teacher_manage");
	}
	/**
	 *PMO 新增教师
	 */
	public ActionForward addTeacher(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IUserBiz biz = new UserBizImpl();
		String userName = request.getParameter("userName");
		String realName = request.getParameter("realName");
		String description = request.getParameter("description");
		String email = request.getParameter("email");
		String type=request.getParameter("radiotype");
		System.out.println(type);
		TUser user= new TUser();
		user.setName(userName);
		user.setDescription(description);
		user.setEmail(email);
		user.setPasswd("888888");
		user.setRealName(realName);
		if(type.equals("3")){
			user.setType(3);
		}else if(type.equals("2")){
			user.setType(2);
		}
		user.setStatus(0);
		biz.register(user);
		List<TUser> users = biz.findAllPMAndBzr();
		request.setAttribute("users", users);
		return mapping.findForward("add_success");
	}
	/**
	 *PMO 教师管理
	 */
	public ActionForward deleteTeacher(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		IUserBiz userbiz=new UserBizImpl();
		
		TUser user =userbiz.getById(Integer.parseInt(id));
		IPollBiz pollbiz = new PollBizImpl();
		List<TPoll> polls = pollbiz.selectPollsByUser(user);
		for(TPoll p:polls){
			pollbiz.delectLineByPoll(p);
		}
		pollbiz.delectPollByUser(user);
		userbiz.deleteTeacher(Integer.parseInt(id));
		request.setAttribute("users", userbiz.findAllPM());
		return mapping.findForward("delete_teacher");
	}
	/**
	 *PMO 考评项管理
	 */
	public ActionForward toContentManage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollContentDao contentDao = new PollContentImpl();
		List<String> types=contentDao.selectTypes();
		List<TPollContent> contents=new ArrayList<TPollContent>();
		Map<String, List<TPollContent>> maps=new HashMap<String, List<TPollContent>>();
		for(String s:types){
			contents=contentDao.getByTypeAndStatus(s, 1);
			maps.put(s, contents);
		}
		request.setAttribute("maps", maps);
		return mapping.findForward("to_content_manage");
	}
	/**
	 *PMO 新增考评项
	 */
	public ActionForward addContent(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content=request.getParameter("content");
		String type=request.getParameter("type");
		String newType=request.getParameter("newType");
		TPollContent c = new TPollContent();
		c.setContent(content);
		c.setStatus(1);
		if(type.equals("1")){
			c.setType(newType);
		}else{
			c.setType(type);
		}
		IPollContentDao dao = new PollContentImpl();
		dao.savePollContent(c);
		return mapping.findForward("add_content");
	}
	/**
	 *PMO 模板管理
	 */
	public ActionForward toTemplateManage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IPollContentDao contentDao = new PollContentImpl();
		List<String> types=contentDao.selectTypes();
		List<TPollContent> contents=new ArrayList<TPollContent>();
		Map<String, List<TPollContent>> maps=new HashMap<String, List<TPollContent>>();
		for(String s:types){
			contents=contentDao.getByTypeAndStatus(s, 1);
			maps.put(s, contents);
		}
		request.setAttribute("maps", maps);
		IpollTemplateDao templateDao = new PollTemplateDaoImpl();
		List<TPollTemplate> templates= templateDao.selectAll();
		request.setAttribute("templates", templates);
		return mapping.findForward("to_template_manage");
	}
	/**
	 *PMO 新增模板
	 */
	public ActionForward addTemplate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		System.out.println(name+description);
		IpollTemplateDao dao = new PollTemplateDaoImpl();
		List<TPollTemplate> templates=dao.selectAll();
		for(TPollTemplate t:templates){
			if(t.getName().equals(name)){
				request.setAttribute("error", "模板名称已存在");
				return mapping.findForward("add_fail");
			}
		}
		TPollTemplate tpt = new TPollTemplate();
		tpt.setName(name);
		tpt.setDescription(description);
		tpt.setCreate_date(new Date());
		tpt.setType(1);
		IPollContentDao contentDao = new PollContentImpl();
		tpt.setContents(contentDao.getByStatus(2));
		contentDao.modifyContentAllClose();
		dao.saveTemplate(tpt);
		
		return mapping.findForward("add_success");
	}
	/**
	 *PMO 预览模板
	 */
	public ActionForward viewTemplate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id =request.getParameter("id");
		IpollTemplateDao templateDao = new PollTemplateDaoImpl();
		TPollTemplate template= templateDao.selectById(Integer.parseInt(id));
		List<TPollContent> contents=template.getContents();
		Set<String> ts=new HashSet<String>();
		String s="";
		for(TPollContent t:contents){
			s=t.getType();
			ts.add(s);
		}
		List<String> types=new ArrayList<String>(ts);
		Map<String, List<TPollContent>> maps=new HashMap<String, List<TPollContent>>();
		List<TPollContent> cs=new ArrayList<TPollContent>();
		for(String type:types){
			if(type.equals("问题")){
				continue;
			}
			for(TPollContent t:contents){
				if(t.getType().equals(type)){
					cs.add(t);
				}
			}
			maps.put(type, cs);
			cs=new ArrayList<TPollContent>();
		}
		List<String> questions=new ArrayList<String>();
		for(TPollContent t:contents){
			if(t.getType().equals("问题")){
				questions.add(t.getContent());
			}
		}
		
		request.setAttribute("maps", maps);
		request.setAttribute("questions", questions);
		return mapping.findForward("view_template");
	}
}