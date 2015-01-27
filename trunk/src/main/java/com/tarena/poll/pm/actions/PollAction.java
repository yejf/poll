package com.tarena.poll.pm.actions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.hibernate.internal.util.compare.ComparableComparator;

import com.tarena.poll.biz.IClazzBiz;
import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.biz.IUserBiz;
import com.tarena.poll.biz.impl.ClazzBizImpl;
import com.tarena.poll.biz.impl.PollBizImpl;
import com.tarena.poll.biz.impl.UserBizImpl;
import com.tarena.poll.commons.db.DBConfig;
import com.tarena.poll.commons.format.DateFormat;
import com.tarena.poll.commons.format.PollNumberFormat;
import com.tarena.poll.commons.mail.SendMailInfo;
import com.tarena.poll.commons.mail.SendMailThread;
import com.tarena.poll.commons.statics.ForwardPath;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollContent;
import com.tarena.poll.entity.TPollLine;
import com.tarena.poll.entity.TPollTemplate;
import com.tarena.poll.entity.TUser;
import com.tarena.poll.pm.forms.ActivationForm;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.xml.I18NManager;
import com.tarena.poll.dao.IPollContentDao;
import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.dao.impl.PollContentImpl;
import com.tarena.poll.dao.impl.PollTemplateDaoImpl;
/**
 * 学员填写调查问卷相关的类和方法
 * @author liuxiaofei & zhengxh
 * 
 */
public class PollAction extends MappingDispatchAction {
	private IClazzBiz clazzbiz=new ClazzBizImpl();
	private IUserBiz userbiz=new UserBizImpl();
	private IPollBiz pollbiz=new PollBizImpl();
	private Lock lock=new ReentrantLock();
	/**
	 * 方法名：prePollContent
	 * 功能：预加载
	 * 详细描述： 
	 * 
	 * 学员填写调查之前，需要做的一些操作:
	 * 查找到学员所在班级网段对应的班级，将此班级放入学生的session中，
	 * 从class_poll_map中找到该班级的poll，进而找到该班级的pm，放入会话中
	 * 
	 * 
	 */
	public ActionForward prePollContent(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		String studentIp=request.getRemoteAddr();	
		
		String currentIp=studentIp.substring(0, studentIp.lastIndexOf("."));
		TClass currentClazz=null;

		Map<TClass,TPoll>class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);

		Set<TClass> keys=class_poll_map.keySet();
		for(Object obj:keys){
			TClass clazz=(TClass)obj;
			if(clazz!=null&&clazz.getClassIP()!=null&&(clazz.getClassIP()).equals(currentIp)){//这里试用了短路与，防止页面上没有给班级分ip
				currentClazz=clazz;
				break;
			}
		}

		TPoll currentPoll=class_poll_map.get(currentClazz);
		TUser currentPm=currentPoll.getUser();
		/*
		 * 更新上下文中map中的poll的amount属性
		 * 要判断一下学生刷新页面时，增加了参加考评人数的情况，即一个ip只能算做一个参加考评的人。

		 */
		Map<String,Integer> record_ip_map=(Map<String,Integer>)request.getSession().getServletContext().getAttribute(ContextKey.RECORD_IP_MAP);
		boolean flag=false;
		if(record_ip_map!=null){
			for(Object obj:record_ip_map.keySet()){
				String ip=(String)obj;
				if(ip.equals(studentIp)&&record_ip_map.get(ip)==1){
					flag=true;
					break;
				}
				if(ip.equals(studentIp+"yes")){
					I18NManager m =I18NManager.getInstance().configure("config/xml/message.xml");
					String message=m.getText("message", "warn_resubmit");
					request.setAttribute("message", message);
					return mapping.findForward(ForwardPath.WARNING);
				}
			}			
		}
		/*
		 * 判断通过后，更新poll对象的一项属性 amount.
		 * 然后在更新class_poll_map。
		 */
		if(flag){
			int InNum=currentPoll.getAmount()+1;
			currentPoll.setAmount(InNum);		
			class_poll_map.remove(currentClazz);
			lock.lock();
			class_poll_map.put(currentClazz,currentPoll );
			lock.unlock();
		}
	/*	IPollBiz biz = new PollBizImpl();
		TPoll poll=biz.getLastPoll();
		TPollTemplate tpt=poll.getTemplate();
		List<TPollContent>  cs=tpt.getContents();
		List<TPollContent>  cs1=new ArrayList<TPollContent>();
		List<TPollContent>  cs2=new ArrayList<TPollContent>();
		for(TPollContent tpc:cs){
			if(tpc.getType().equals("授课实施")){
				cs1.add(tpc);
			}else{
				cs2.add(tpc);
			}
		}
		request.setAttribute("cs1", cs1);
		request.setAttribute("cs2", cs2);*/
		IPollBiz biz = new PollBizImpl();
		TPoll poll=biz.getLastPoll();
		TPollTemplate template=poll.getTemplate(); 
		
		IpollTemplateDao templateDao = new PollTemplateDaoImpl();
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
		
		request.getSession().setAttribute("maps", maps);
		request.getSession().setAttribute("questions", questions);
		
		request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP,class_poll_map);

		request.getSession().setAttribute(ContextKey.CURRENT_PM, currentPm);
		request.getSession().setAttribute(ContextKey.CURRENT_CLAZZ, currentClazz);
		return mapping.findForward(ForwardPath.PRE_POLL_CONTENT);
	}
	
	/**
	 * 方法名：activePoll
	 * 功能：基地管理员激活考试
	 * 详细描述：
	 * 基地管理员进入系统后可以选择班级和对应的项目经理，开启评审
	 * 可以同时开启多个评审
	 */
	public ActionForward activatePoll(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		ActivationForm activationForm=(ActivationForm)form;
		int clazzid=activationForm.getClassName();  //班级ID
		int userid=activationForm.getRealName();  // 教员ID
		String modelid=request.getParameter("templateName");
		
		TPoll poll=new TPoll();
		TUser user=userbiz.getById(userid);
		TClass clazz=clazzbiz.getClassById(clazzid);
		
		poll.setClazz(clazz);
		Date createDate=DateFormat.getPollDate(DateFormat.getPollFormatDate(new Date()));
		poll.setCreated_date(createDate);
		poll.setStatus('n');
		poll.setUser(user);
		
		IpollTemplateDao templatedao = new PollTemplateDaoImpl();
		TPollTemplate template = templatedao.selectById(Integer.parseInt(modelid));
		poll.setTemplate(template);
		//
		
		//
		//1
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
		String cs1="";
		Set<String> keyset=maps.keySet();
		Iterator iter = keyset.iterator();
		while(iter.hasNext()){
			String key=(String) iter.next();
			List<TPollContent> cs2=maps.get(key);
			for(TPollContent t1:cs2){
				cs1+=t1.getContent();
				cs1+=":";
			}
		}
		if(questions.size()!=0){
			for(String s1:questions){
				cs1+=s1;
				cs1+=":";
			}
		}
		System.out.println(cs1);
		poll.setContents(cs1);
		//2
		
		/*
		 * 从上下文中取出class_poll_map,判断其中是否有该班级对象。
		 * 判断上下文中是否有这个<TClass,TPoll>键值对，解决重复提交，多次对同一班级开启考评的业务问题
		 */
		Map<TClass,TPoll>class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		if(class_poll_map==null){
			class_poll_map=new HashMap<TClass,TPoll>();
		}

		boolean flag=false;
		for(Object obj:class_poll_map.keySet()){
			TClass tclass=(TClass)obj;
			if(tclass.getClassName().equals(clazz.getClassName())){
				flag=true;
			}
		}
		
		List<TUser>  pmList=userbiz.findAllPM();
		List<TClass> classList=clazzbiz.getByStatus(0);

		/*
		 * 
		 *将刚才被激活和已被激活的班级从列表中去掉
		 *
		 */
		
		for(Iterator it=classList.iterator();it.hasNext();){
			TClass c=(TClass)it.next();
			for(Iterator it2=class_poll_map.keySet().iterator();it2.hasNext();){
				TClass c2=(TClass)it2.next();
				if(c.getId().equals(c2.getId())){
					it.remove();
					break;
				}
			}
		}
		if(flag==true){
			request.setAttribute(ContextKey.CLASS_LIST, classList);
			request.setAttribute(ContextKey.PM_LIST, pmList);
			//return mapping.findForward(ForwardPath.JDT_POLL_ADD );
		}else{
			for(Iterator it=classList.iterator();it.hasNext();){
				TClass c=(TClass)it.next();
				if(c.getClassName().equals(clazz.getClassName())){
					it.remove();
					break;
				}					
			}			
		}
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		
		pollbiz.savePoll(poll);
		lock.lock();
		class_poll_map.put(clazz, poll);
		lock.unlock();
		request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP, class_poll_map);
		return mapping.findForward(ForwardPath.JDT_POLL_ADD );
	}
	
	
	/**
	 * 方法名：pollSubmit
	 * 功能：学生提交评审调查
	 * 详细描述：
	 */
	public ActionForward pollSubmit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Enumeration<String> names=request.getParameterNames();
		List<String> ns=new ArrayList<String>();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			ns.add(name);
		}
		List<String> rNames = new ArrayList<String>();
		List<String> qNames = new ArrayList<String>();
		for(String s:ns){
			if(s.startsWith("c")){
				rNames.add(s);
			}else if(s.startsWith("a")){
				qNames.add(s);
			}
			
		}
	
		Collections.sort(rNames,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int b1=o1.toCharArray()[1]-'0';
				int b2=o2.toCharArray()[1]-'0';
				if(b1>b2){
					return 1;
				}else if(b1<b2){
					return -1;
				}else{
					int i1=Integer.parseInt(o1.substring(2));
					int i2=Integer.parseInt(o2.substring(2));
					return i1-i2;
				}
				
			}
		});
		
		String scores="";
		for(String s:rNames){
			scores+=request.getParameter(s);
		}
		String answers="";
		if(qNames.size()!=0){
			for(String s:qNames){
				answers+=request.getParameter(s);
				answers+=":";
			}
		}
		
		//		PollContentForm pollcontentform=(PollContentForm)form;
		TPollLine pollLine = new TPollLine();
		/*Set<Method> getMethods = new HashSet<Method>();  //用来存放满足条件的 get属性方法
		
		Class pollLineClass = pollLine.getClass();
		//获取所有属性
		Field[] fields = pollLineClass.getDeclaredFields();
		//把属性名及它的类型加入到一个MAP中
		Map<String, Class> fieldMap = new HashMap<String, Class>();
		for(int i=0;i<fields.length;i++) {
			String fieldName = fields[i].getName();
			Class fieldClass = fields[i].getType();
			fieldMap.put(fieldName, fieldClass);
		}*/
		
		//int lineNum = 0;
		/*Enumeration<String> pnames = request.getParameterNames();
		*//** use a variable 'lineNum' to record poll line number *//*
		while(pnames.hasMoreElements()) {
			//参数名 [与属性名同名]
			String pName = pnames.nextElement();
			if(fieldMap.containsKey(pName)) {
				//则获取对应属性的 set方法
				String methodName = "set"+(pName.substring(0,1).toUpperCase())+pName.substring(1);
				//同时，也获取对应属性的 get 方法, 便 于后面求取平均值
				String getMethodName = "get"+(pName.substring(0,1).toUpperCase())+pName.substring(1);
				
				Class t = fieldMap.get(pName);
				Method m = pollLineClass.getMethod(methodName,t);
				//再拿到 get属性方法, 由于 get系统方法是空参，所以，后一个参数为 null
				Method getM = pollLineClass.getMethod(getMethodName, null);
				
				Object param = null;
				if(t == Integer.TYPE) {
					lineNum ++ ;
					param = new Integer(request.getParameter(pName));
					//同时，把此类 getMethod 方法放入 一个集合中
					getMethods.add(getM);
					
				} else if(t == String.class) {
					param = request.getParameter(pName);
				} else {
					// . . .
					System.out.println("Not Supported...");
				}
				m.invoke(pollLine, new Object[]{param});
			}
		}*/
		
		/*double ln = lineNum;
		 // ? 应该是有 设置过值的Integer选项都要参与请 平均值
//		double avgScore = pollLine.calcAvgScore(ln);  
		double totalScore = 0.0d;
		//求平均值
		Iterator<Method> iter =  getMethods.iterator();
		while(iter.hasNext()) {
			Method method = iter.next();
			Integer data = (Integer)method.invoke(pollLine, null);
			totalScore += data;
		}*/
		char[] arr =scores.toCharArray();
		double totalScore=0.0;
		for(char c:arr){
			totalScore+=Double.parseDouble(c+"");
		}
		double avgScore = totalScore /scores.length();
		
		double cpAvgScore=0.0;
		cpAvgScore =PollNumberFormat.formatDouble(avgScore);	//得到平均值
		char isValid='y';		//都设为有效

		TClass currentClazz=(TClass)request.getSession().getAttribute(ContextKey.CURRENT_CLAZZ);
		Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		/*
		 * 
		 * 或者基地管理员已关闭、删除考评，这时通过国际化读取提示信息放入请求中
		 * 然后转发提示页面。
		 * 
		 */
		I18NManager m =I18NManager.getInstance().configure("config/xml/message.xml");
		String message=m.getText("message", "info_over");

		if(class_poll_map==null){
			request.getSession().setAttribute("message", message);

			return mapping.findForward(ForwardPath.SUBMIT_POLL_FAIL);
		}
		/*
		 * 取出当前班级对应的poll对象。如果poll对象不在了，告诉学员评审已结束
		 */
		TPoll current_poll=class_poll_map.get(currentClazz);
		if(current_poll==null){
			request.getSession().setAttribute("message", message);
			return mapping.findForward(ForwardPath.SUBMIT_POLL_FAIL);
		}
		int submintNum;
		

		if(avgScore <= 1||avgScore > 5){			
			isValid='n';
		}else{
			isValid='y';
		}
		submintNum=current_poll.getValid_amount()+1;
		current_poll.setValid_amount(submintNum);

		/*pollLine.setIsValid(isValid);
		pollLine.setAvgScore(cpAvgScore);
		pollLine.setPoll(current_poll);

		List<TPollLine> pollLines=current_poll.getPollLines();
		if(pollLines==null){
			pollLines=new ArrayList<TPollLine>();
		}				
		pollLines.add(pollLine);
		current_poll.setPollLines(pollLines);	*/
		pollLine.setScores(scores);
		pollLine.setQ1(answers);
		pollLine.setAvgScore((float)cpAvgScore);
		pollLine.setIsValid(isValid);
		
		TPoll poll=pollbiz.getLastPoll();
		pollLine.setPoll(poll);
		
		pollbiz.savePollLine(pollLine);
		lock.lock();
		class_poll_map.put(currentClazz, current_poll);
		lock.unlock();

		String message2=m.getText("message", "info_thanks");		
		request.getSession().setAttribute("message",message2);
		request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP, class_poll_map);

		/*
		 * 这里更新record_ip_map中的信息，防止学生再次提交
		 */
		Map<String,Integer> record_ip_map=(Map<String,Integer>)request.getSession().getServletContext().getAttribute(ContextKey.RECORD_IP_MAP);
		if(record_ip_map!=null){
			String studentIp=request.getRemoteAddr();
			for(Object obj:record_ip_map.keySet()){
				String s=(String)obj;
				if(s.equals(studentIp)){
					/*
					 * 如果学生提交，更新record_ip_map，这里已经进行了加锁处理。
					 */
					lock.lock();
					record_ip_map.put(studentIp+"yes", 1);
					lock.unlock();
					request.getSession().getServletContext().setAttribute(ContextKey.RECORD_IP_MAP, record_ip_map);
					break;
				}
			}
		}
		
		return mapping.findForward(ForwardPath.POLL_SUBMIT);
	}
	
public ActionForward toClosePoll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int clazzId=Integer.parseInt(request.getParameter("clazzId"));
		Map<TClass,TPoll>class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		
		List<TUser> pmList=userbiz.findAllPM();
		List<TClass> classList=clazzbiz.getByStatus(0);

		if(class_poll_map==null){
			return mapping.findForward(ForwardPath.JDT_POLL_MODIFY);
		}
		

		for(Iterator it=class_poll_map.keySet().iterator();it.hasNext();){
			TClass c=(TClass)it.next();
			for(Iterator it2 = classList.iterator();it2.hasNext();){
				TClass cla = (TClass)it2.next();
				if(c.getId().equals(cla.getId())){
					it2.remove();
				}
			}
		}
			
		TClass clazz = clazzbiz.getClassById(clazzId);
		classList.add(clazz);
		String id = String.valueOf(clazzId);
		request.setAttribute(ContextKey.CLAZZID, id);
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		return mapping.findForward(ForwardPath.JDT_TO_CLOSE_POLL);
	}
	
	/**
	 * 方法名：closePoll
	 * 功能：基地管理员关闭评审，这时候会将评审对象入库。
	 * 详细描述：
	 *   将该poll对象入库，级联将poll对象中的set集合中的poll_line入库，
	 *   然后将上下文中的class_poll_map中该班级的键值对清除，
	 *   将上下文中record_ip_map中的该班级的所有学生的ip记录清除
	 */
	public ActionForward closePoll(
			ActionMapping mapping, 
			ActionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		request.setAttribute(ContextKey.CLASS_LIST, request.getAttribute(ContextKey.CLASS_LIST));
		request.setAttribute(ContextKey.PM_LIST, request.getAttribute(ContextKey.PM_LIST));

		int clazzid=Integer.parseInt(request.getParameter(ContextKey.CLAZZID));
		Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		// ?
		if(class_poll_map==null){
			return mapping.findForward(ForwardPath.JDT_POLL_MODIFY);
		}
		IPollBiz pollbiz = new PollBizImpl();
		/* 通过班级获取此班级的调查结果 **/
		TPoll poll=pollbiz.getLastPoll();		
		TClass clazz=poll.getClazz();
		Character status=poll.getStatus();
		if(!status.equals('n')){
			return mapping.findForward(ForwardPath.JDT_POLL_MODIFY);
		}
		/* 获取所有参与的 调查结果 **/
		List<TPollLine> pollLines=pollbiz.selectPollLineByPoll(poll);
		
		
		int amount=pollLines.size();	//总份数
		int valid_amount=0;  //有效调查份数
		float total_score = 0.0f;
		float cpAvgScore = 0.0f;	//最终入库平均分数
		for(TPollLine line:pollLines){
			Character c = line.getIsValid();
			if(c.equals('y')){
				valid_amount++;
				total_score+=line.getAvgScore();
			}
		}
		
		/* 迭代所有调查项，并获取之前所算出的平均分 **/
	/*	for(Object obj:pollLines ){
			amount++;  //其实总份数就是参与调查的数量, 相当于 amount = pollLines.size();
			TPollLine pollLine=(TPollLine)obj;
			int i=pollLine.getC1()+pollLine.getC2()+pollLine.getC3()+pollLine.getC4()+pollLine.getC5();
			i=i+pollLine.getC6()+pollLine.getC7()+pollLine.getS1()+pollLine.getS2()+pollLine.getS3();
			i=i+pollLine.getS4()+pollLine.getS5();			
			score=score+i;
		
			Character c=pollLine.getIsValid();
			if(c.equals('y')){
				valid_amount++;  //有效份数 ++
				total_score += pollLine.getAvgScore();  //把只有是有效的调查的分数合全部加起来
			}
		}*/

		if(valid_amount != 0) {
			cpAvgScore = PollNumberFormat.formatFloat(total_score / valid_amount);
		}
		poll.setAvg_score(cpAvgScore);	//设置平均分数
		poll.setTotal_score((int)total_score); //这只是一个经过四舍五入而得到的结果
		poll.setStatus('y');  //未评审
		poll.setValid_amount(valid_amount);  //设置有效份数
		poll.setAmount(amount);
		Date overDate=DateFormat.getPollDate(DateFormat.getPollFormatDate(new Date()));
		poll.setOver_date(overDate);
		
		TPollTemplate tpt =poll.getTemplate();
		List<TPollContent> list =tpt.getContents();
		
		StringBuilder builder=new StringBuilder();
		
		for(TPollContent tpc:list){
			builder.append(tpc.getContent());
			builder.append(":");
		}
		poll.setContents(builder.toString());
		pollbiz.updatePoll(poll);

		lock.lock();
		class_poll_map.remove(clazz);
		lock.unlock();
		
		
		Set<TClass> keyset=class_poll_map.keySet();
		Iterator<TClass> itern=keyset.iterator();
		while(itern.hasNext()){
			TClass c=itern.next();
			class_poll_map.get(c).setStatus('y');
		}
		class_poll_map=null;
		request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP, class_poll_map);
		
		Map<String,Integer> record_ip_map=(Map<String,Integer>)request.getSession().getServletContext().getAttribute(ContextKey.RECORD_IP_MAP);
		if(record_ip_map==null){
			return mapping.findForward(ForwardPath.JDT_POLL_MODIFY);
		}else{
			Set<String>delete_ip_set=new HashSet<String>();
			for(Iterator it=record_ip_map.keySet().iterator();it.hasNext();){			 
				String ip =(String)it.next();
				String stu_ip=ip.substring(0, ip.lastIndexOf("."));
				if(stu_ip.equals(clazz.getClassIP())){
					delete_ip_set.add(ip);
				}
			}

			for(Iterator it=delete_ip_set.iterator();it.hasNext();){
				String key=(String)it.next();
				lock.lock();
				record_ip_map.remove(key);
				lock.unlock();
			}

			request.getSession().getServletContext().setAttribute(ContextKey.RECORD_IP_MAP, record_ip_map);
			}
	
		//启动一个线程，在发送邮件
		//构造一个SendMailInfo对象
		if(poll.getValid_amount() >= 1) {
			SendMailInfo smi = new SendMailInfo();
			//获取发送目的地：
			String tqmo = DBConfig.getInstance().getValue("tqmo");
			String host = DBConfig.getInstance().getValue("mail.smtp.host");
			String port = DBConfig.getInstance().getValue("mail.smtp.port");
			String auth = DBConfig.getInstance().getValue("mail.auth");
			String from = DBConfig.getInstance().getValue("mail.from");
			String name = DBConfig.getInstance().getValue("mail.user");
			String pwd = DBConfig.getInstance().getValue("mail.pwd");
			String server_url = DBConfig.getInstance().getValue("server_url");
			
			if(tqmo.indexOf(',') != -1) {
				//说明配了多个
				String[] to = tqmo.split(",");
				smi.setTo(to);
			} else {
				smi.setTo(new String[] {tqmo});
			}
			//添加属性值
			smi.setFrom(from);
			smi.setValidate(Boolean.parseBoolean(auth));
			smi.setSmtp_host(host);
			smi.setSmtp_port(port);
			smi.setUsername(name);
			smi.setPassword(pwd);
			
			smi.setSubject("("+poll.getClazz().getClassName()+")调查已结束，请审核!");
			StringBuffer text = new StringBuffer("<b>TQMO,您好！<b/><br/>");
			text.append("<p>&nbsp;&nbsp;调查已结束,请及时审核</p>");
			text.append("<p>&nbsp;&nbsp;相关信息如下：<p>");
			text.append("<table border='1' width='300' cellpadding='5'>");
			text.append("<tr align='left'><th>评价讲师</th><td>"+poll.getUser().getRealName()+"</td></tr>");
			text.append("<tr  align='left'><th>调查时间</th><td>"+DateFormat.getPollFormatDate(poll.getCreated_date())+"</td></tr>");
			text.append("<tr  align='left'><th>调查班级</th><td>"+poll.getClazz().getClassName()+"</td></tr>");
			text.append("<tr  align='left'><th>目前分数</th><td>"+poll.getAvg_score()+"</td></tr>");
			text.append("<tr  align='center'><td colspan='2'><a href='"+server_url+"'>点击进入</a></td></tr>");
			text.append("</table>");
			
			smi.setContent(text.toString());
			
			Thread t = new SendMailThread(smi);
			t.start();
		}
		
		return mapping.findForward(ForwardPath.JDT_POLL_MODIFY);
	}
	
public ActionForward toDeletePoll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int clazzId=Integer.parseInt(request.getParameter("clazzId"));
		Map<TClass,TPoll>class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		
		List<TUser> pmList=userbiz.findAllPM();
		List<TClass> classList=clazzbiz.getByStatus(0);

		if(class_poll_map==null){
			return mapping.findForward(ForwardPath.JDT_POLL_DELETE);
		}

		for(Iterator it=class_poll_map.keySet().iterator();it.hasNext();){
			TClass c=(TClass)it.next();
			for(Iterator it2 = classList.iterator();it2.hasNext();){
				TClass cla = (TClass)it2.next();
				if(c.getId().equals(cla.getId())){
					it2.remove();
				}
			}
		}
			
		TClass clazz = clazzbiz.getClassById(clazzId);
		classList.add(clazz);
		String id = String.valueOf(clazzId);
		request.setAttribute(ContextKey.CLAZZID, id);
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		IPollBiz biz = new PollBizImpl();
		List<TPoll> polls=biz.selectPollsByStatus('n');
		for(TPoll p:polls){
			biz.delectLineByPoll(p);
		}
		biz.deleteLastPoll();
		
		return mapping.findForward(ForwardPath.JDT_TO_DELETE_POLL);
	}

	/*
	 * @methodName:deletePoll
	 * 该方法用于删除内存中的考评对象
	 *
	 */
public ActionForward deletePoll(
		ActionMapping mapping, 
		ActionForm form, 
		HttpServletRequest request, 
		HttpServletResponse response) throws Exception {
	request.setAttribute(ContextKey.CLASS_LIST, request.getAttribute(ContextKey.CLASS_LIST));
	request.setAttribute(ContextKey.PM_LIST, request.getAttribute(ContextKey.PM_LIST));
	int clazzId=Integer.parseInt(request.getParameter(ContextKey.CLAZZID));
	Map<TClass,TPoll>class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
	/*
	 * 如果所有poll均以提交入库，或者删除，那么当用户刷新页面时，
	 * 防止出现空指针异常，故让页面跳转回来。
	 */
	if(class_poll_map==null){
		return mapping.findForward(ForwardPath.JDT_POLL_DELETE);
	}
	boolean flag=true;
	for(Iterator it=class_poll_map.keySet().iterator();it.hasNext();){
		TClass clz =(TClass)it.next();
		if(clz.getId().equals(clazzId)){
			it.remove();
			flag=false;
			break;
		}
	}

	if(flag){
		return mapping.findForward(ForwardPath.JDT_POLL_DELETE);
	}
	Set<TClass> keyset=class_poll_map.keySet();
	Iterator<TClass> it=keyset.iterator();
	while(it.hasNext()){
		TClass c=it.next();
		class_poll_map.get(c).setStatus('y');
	}
	
	request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP, class_poll_map);
	

	TClass clazz=clazzbiz.getClassById(clazzId);
	Map<String,Integer>record_ip_map=(Map<String,Integer>)request.getSession().getServletContext().getAttribute(ContextKey.RECORD_IP_MAP);

	if(record_ip_map==null){
		return mapping.findForward(ForwardPath.JDT_POLL_DELETE);
	}else{
		Set<String>delete_ip_set=new HashSet<String>();
		for(Iterator iter=record_ip_map.keySet().iterator();it.hasNext();){			 
			String ip =(String)iter.next();
			String stu_ip=ip.substring(0,ip.lastIndexOf("."));
			if(clazz!=null&&stu_ip.equals(clazz.getClassIP())){
				delete_ip_set.add(ip);
			}
		}
		for(Iterator iter=delete_ip_set.iterator();it.hasNext();){
			String key=(String
					)iter.next();
			record_ip_map.remove(key);
		}
		request.getSession().getServletContext().setAttribute(ContextKey.RECORD_IP_MAP, record_ip_map);

		
	}

	return mapping.findForward(ForwardPath.JDT_POLL_DELETE);
}
	/*
	 * 
	 */
	public ActionForward showPolls(
			ActionMapping mapping, 
			ActionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception { 
		request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		
		return mapping.findForward(ForwardPath.JDT_POLL_SHOW);
	}
	
	public ActionForward pollList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = ((TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER)).getName();
		IPollBiz ipb = new PollBizImpl();
		List pollList = ipb.selectStatisticsByUserName(name);
		request.setAttribute("pmPollList", pollList);
		return mapping.findForward("pm_poll_list");
	}

}


	

