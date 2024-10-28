package controller;

import java.io.IOException;

import dao.member_repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class member_controller3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리 
		String id=req.getParameter("id");
		
		//모델 이동
		member_repository mr = member_repository.getInstance();
		mr.deleteuser(id);
		
		//뷰 이동
		req.setAttribute("delete", id);
		RequestDispatcher rd=req.getRequestDispatcher("/readall");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
