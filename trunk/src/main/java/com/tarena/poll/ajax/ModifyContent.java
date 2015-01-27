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
public class ModifyContent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content =req.getParameter("content");
		String id = req.getParameter("contentId");
		System.out.println(id+content);
		IPollContentDao dao = new PollContentImpl();
		dao.modifyContentByIdAndName(Integer.parseInt(id), content);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
