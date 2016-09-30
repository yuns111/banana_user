package banana_user.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProgramController {

	private Connection connection;

	public ProgramController() {

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.100:1521:xe", "system", "1234");
			System.out.println("데이터베이스가 연결되었습니다.");
			
		} catch(ClassNotFoundException e) {

			System.out.println("클래스 파일 없음");
			
		} catch(SQLException e) {

			System.out.println("커넥션 에러");
			
		}
		
	}

	public Connection getConnection() {

		return connection;

	}

	public void requestExitProgram() {

		if(connection != null) {
			
			try {connection.close();} catch(SQLException e) {e.printStackTrace();} 
			
		}

		System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);

	}

}