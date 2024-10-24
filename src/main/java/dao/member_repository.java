package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import dto.member_dto;

public class member_repository {
	//1개만 존재해야 함. 싱글톤으로 작성
	
	private static member_repository mr = new member_repository();
	public static member_repository getInstance() {
		return mr;
	}
	
	//Create
	public void member_create(member_dto dto) {
		//Step 1 : JDBC 드라이버 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Step 2 : Connection 객체 생성
			Connection conn = null;
			String database="jdbc:mysql://localhost:3306/login_crud";
			String id="root";
			String password="1234";
			conn = DriverManager.getConnection(database,id,password);
			//PrintWriter out = getWriter();
			System.out.println("데이터 베이스 연결 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 베이스 연결 오류");}
		
		
		//Step 3 : SQL 전송 객체 생성 및 전송
		
		//Step 4 : return이 있다면 ResultSet 객체에 담기(CUD는 해당 없음)
		
	}
	
	//Read
	
	//Update
	
	//Delete
}
