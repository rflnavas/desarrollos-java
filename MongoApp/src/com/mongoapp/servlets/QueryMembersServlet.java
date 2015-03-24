package com.mongoapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongoapp.beans.Member;
import com.mongoapp.dao.MemberDAO;
import com.mongoapp.dao.criteria.Criteria;
import com.mongodb.MongoClient;

@WebServlet(name = "QueryMemberServlet", urlPatterns = { "/queryMembers",
		"/queryMembers" }, description = "Servlet to query members")
public class QueryMembersServlet extends HttpServlet {

	private static final long serialVersionUID = 4865764572978824127L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Member> members = readMembers(req);
		req.setAttribute("members", members);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
	
	private List<Member> readMembers(HttpServletRequest req){
		MongoClient mClient = (MongoClient) req.getServletContext()
				.getAttribute("MongoClient");
		MemberDAO mbDAO = new MemberDAO(mClient);
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String score =req.getParameter("score");
		String [] scoreComparison = req.getParameter("scoreComparison").split(",");
		
		Criteria criteria = new Criteria();
		criteria.add(Member.NAME, name);
		criteria.add(Member.CATEGORY, category);
		for(int i = 0; i < scoreComparison.length ; i++){
			criteria.add(Member.SCORE, String.valueOf(score), scoreComparison[i]);
		}
		List<Member> members = mbDAO.read(criteria);
		
		return members;
	}
}
