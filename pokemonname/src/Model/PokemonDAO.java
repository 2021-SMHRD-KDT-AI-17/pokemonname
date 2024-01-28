package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class PokemonDAO {

	PokemonBook pokemon = new PokemonBook();
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	// 공통적으로 작성하고 있는 코드를 메서드로 분리
	public void getConn() {
		try {
			// [Java프로그램과 데이터베이스를 연결하는 과정]
			// 1.JDBC 드라이버 동적 로딩
			// - Java프로그램이 실행될 때 JDBC드라이버를 불러오는 과정

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23K_AI17_p1_5"; // DB연결 계정
			String password = "smhrd5";// DB연결 비밀번호

			// 2.데이터베이스연결
			// - url, user, password정보를 전달
			// - 성공적으로 연결 된 경우 Connection객체를 반환
			// - Connection객체: DB연결, 종료, SQL실행 등의 기능을 제공하는 객체
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("DB연결성공!");
			} else {
				System.out.println("DB연결실패..");
			}

		} catch (Exception e) {
			e.printStackTrace(); // 오류 출력용 코드
		}

	}
	// ============ DB 연결까지

		public void close() {

			// 4. 데이터베이서 연결종료(연결된 객체의 역순으로 정리)***********
			// - 데이터베이스 관련 작업이 끝난 경우 연결되어 있는
			// 모든 객체는 반드시 종료해줘야 한다!
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("DB연결종료!");

		}
		// =========== DB 연결 종료

		// --------------------------------------------------------------------------------------------------------------
		
		
		
		
		// 포켓몬 그림 출력
		public void ENprint(int num) {
			
			pokemon.book();
			// book에 있는 배열을 랜덤하게 꺼내와
			// 
			
			
			
			
			
			
		}
		
		// Easy/Normal 힌트 시 초성 출력
		public void ENHint() {
			//pokemon.book();의 배열 값
			
			
		}
		
		
		// Hard 그림 절반만 출력
		public void Hprint() {
			
			
			
		}
		
		// Hard 힌트 시 그림 전체 출력
		public void HHint() {
			
			
			
		}
		
		// 정답이 db 번호 와 똑같은지
		
		
	
}
