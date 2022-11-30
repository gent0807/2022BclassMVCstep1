package com.dm.view.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.common.ResisterDAO;
import com.dm.common.ResisterDTO;


@WebServlet("/Insert.do") //jvm에 코멘트
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter("memberid");
		String p=request.getParameter("password");
		ResisterDTO rt=new ResisterDTO();
		rt.setMemberid(i);
		rt.setPassword(p);
		
		ResisterDAO rd=new ResisterDAO();
		try {
			rd.insertMember(rt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(("insertError.jsp"));
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("insertSucess.jsp");
		dispatcher.forward(request, response);
	}

}
