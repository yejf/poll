package com.tarena.poll.web.filters;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.poll.commons.xml.I18NManager;
import com.tarena.poll.web.filter.HttpFilter;

public class CheckReSubmitFilter extends HttpFilter{
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Map<String,Integer>record_ip_map=(Map<String,Integer>)((HttpServletRequest)request).getSession().getServletContext().getAttribute("record_ip_map");
		if(record_ip_map==null){
			record_ip_map=new HashMap<String,Integer>();
		}
		
		/*
		 * 获取学生访问时的ip地址，这里分两种情况1.单机测试；2.联网测试
		 */
		 String studentIp=request.getRemoteAddr(); 
		 boolean flag=false;
		 for(Object obj:record_ip_map.keySet()){
			 String key=(String)obj;	

			 if(key.equals(studentIp+"yes")){				 
				 flag=true;
				 break;
			 }		 
		 }	 
	
		 if(!flag){
			 chain.doFilter(request, response);		 
		 }else{
			I18NManager m =I18NManager.getInstance().configure("config/xml/message.xml");
			String message=m.getText("message", "warn_resubmit");
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/global/warr.jsp");
			dispatcher.forward(request, response);		 }
		
	}

}
