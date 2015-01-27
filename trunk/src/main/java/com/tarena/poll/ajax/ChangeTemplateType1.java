package com.tarena.poll.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.dao.impl.PollTemplateDaoImpl;


/**
 *本来用来演示
 *author datong
 */
public class ChangeTemplateType1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		IpollTemplateDao dao = new PollTemplateDaoImpl();
		dao.modifyByIdAndType(Integer.parseInt(id), 1);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
