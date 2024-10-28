package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class member_controller2 extends HttpServlet{
// 목표 : 여러 개의 dto를 읽어 와서 view에 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리 : 파라미터가 존재하지 않아 생략
		//모델 이동(데이터 삽입 or 불러오기)
		member_repository mr=member_repository.getInstance();
		ArrayList<member_dto> arr=mr.getAllmember();
		//뷰 이동
		req.setAttribute("list", arr);
		RequestDispatcher rd=req.getRequestDispatcher("all.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
