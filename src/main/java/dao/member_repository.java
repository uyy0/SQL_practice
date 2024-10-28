package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;

public class member_repository {
	//1개만 존재해야 함. 싱글톤으로 작성
	
	private static member_repository mr = new member_repository();
	public static member_repository getInstance() {
		return mr;
	}
	//데이터베이스 연결 메서드
	private Connection DBconn() throws Exception{
		//Step 1 : JDBC 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		//Step 2 : Connection 객체 생성
		Connection conn = null;
		String database="jdbc:mysql://localhost:3306/login_crud";
		String id="root";
		String password="1234";
		conn = DriverManager.getConnection(database,id,password);
		System.out.println("데이터 베이스 연결 완료");
		
		return conn;
	}
	
	
	//Create
	public void member_create(member_dto dto) {
		try {
			//PrintWriter out = getWriter();
			Connection conn=DBconn();
			
			//Step 3 : SQL 전송 객체 생성 및 전송
			Statement stmt = conn.createStatement();
			String userid=dto.getId();
			String userpw=dto.getPw();
			int age=dto.getAge();
			
			// insert into member values("admin","1234",7); : 워크벤치에서 테스트 실행
			// "insert into member values('"+userid+"','"+userpw+"',"+age+")";
			// 변수를 사용해야 하기 때문에 문자열+변수 형태로 변환
			String sql="insert into member values('"+userid+"','"+userpw+"',"+age+")";
			stmt.executeUpdate(sql);
		} catch (Exception e) {System.out.println("데이터 베이스 연결 오류");}
		
		//Step 4 : return이 있다면 ResultSet 객체에 담기(CUD는 해당 없음)
		
	}
	
	//Read
	public ArrayList<member_dto> getAllmember() {
		ArrayList<member_dto> arr=new ArrayList<member_dto>();
		ResultSet rs=null;
		try {
			Connection  conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql="select * from member";
			rs = stmt.executeQuery(sql);
			//rs 길이 알 수 없음 -> while
			while(rs.next()) {
				                       // col
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				
				member_dto dto = new member_dto();
				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
				/*
					member_dto dto = new member_dto();
					dto.setId(rs.getString("id"));
					dto.setPw(rs.getString("pw"));
					dto.setAge(rs.getInt("age"));
				  */
				arr.add(dto);
			}
		} catch(Exception e) {}
		return arr;
	}
	public member_dto getOnemember(String userid) {
		member_dto dto = new member_dto();
		try {
			ResultSet rs=null;
			//Step 1 : DB연결
			Connection conn;
			conn = DBconn();
			//Step 2 : Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "select * from member where id='"+userid+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				
				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
			}
		} catch (Exception e) {e.printStackTrace();}
		return dto;
	}
	//Update
	public void update_member(member_dto dto) {
		try{
			//Step 1 : 
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "update member set pw='"+dto.getPw()+"',age="+dto.getAge()+" where id='"+dto.getId()+"'"; 
			stmt.executeUpdate(sql);
		} catch (Exception e) {e.printStackTrace();}
	}
	//Delete
	public void deleteuser(String id) {

		try {
			//Step 1 : DB 연결
			Connection conn=DBconn();
			
			//Step 2 : Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql="delete from member where id='"+id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {e.printStackTrace();}
	}
	//
	
}
