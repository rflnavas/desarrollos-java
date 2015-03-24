package com.mongoapp.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongoapp.beans.Member;
import com.mongoapp.dao.MemberDAO;
import com.mongodb.MongoClient;

@WebServlet(name = "NewMemberServlet", urlPatterns = { "/newMember",
		"/createMember" }, description = "Servlet to create members")
public class NewMemberServlet extends HttpServlet {

	private static final long serialVersionUID = 4865764572978824127L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MongoClient mClient = (MongoClient) req.getServletContext()
				.getAttribute("MongoClient");
		MemberDAO mbDAO = new MemberDAO(mClient);
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		Date joinDate = null;
	    joinDate = new Date();
		
		Member member = new Member();
		member.setName(name);
		member.setCategory(category);
		member.setJoinDate(joinDate);
		mbDAO.create(member);
		req.setAttribute("added", "Member " + name + " was successfully added!");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}
