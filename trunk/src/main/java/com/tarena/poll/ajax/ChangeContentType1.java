package com.tarena.poll.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.poll.dao.IPollContentDao;
import com.tarena.poll.dao.impl.PollContentImpl;

/**
 *本来用来演示
 *author datong
 */
public class ChangeContentType1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		IPollContentDao dao = new PollContentImpl();
		dao.modifyContentByIdAndStatus(Integer.parseInt(id), 2);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
