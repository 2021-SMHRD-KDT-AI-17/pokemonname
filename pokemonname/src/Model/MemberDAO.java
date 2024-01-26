package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private Connection conn = null;
	
	private PreparedStatement psmt = null;
	
	private ResultSet rs = null;


	public void getConn() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23k_AI17_p1_5"; // DB연결 계정
			String password = "smhrd5";// DB연결 비밀 번호


			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("DB연결 성공!");
			} else {
				System.out.println("DB연결 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// =======================DB 연결까지

	public void close() {


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
		System.out.println("DB연결 종료");

	}
	// ===================DB 연결 종료

	// -----------------------------------------------------


	public MemberDTO login(MemberDTO dto) {


		MemberDTO result = null;


		try {
			getConn();


			String sql = "SELECT ID, PW FROM pokemonmember WHERE ID = ? AND PW =?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			rs = psmt.executeQuery();


			if (rs.next()) {
				result = new MemberDTO();
				String getId = rs.getString(1); 
				String getPw = rs.getString(2);

				result.setId(getId);
				result.setPw(getPw);


				System.out.println(getId + "/" + getPw);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;

	}
	// =====================================================로그인
	
	
	public int join(MemberDTO dto) {
		int cnt = 0;
		try {
			getConn();

			String sql = "INSERT INTO pokeMEMBER VALUES(?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			cnt = psmt.executeUpdate(); 

			if (cnt > 0) {
				System.out.println("회원가입 성공");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	// ===========================================회원가입
	
	public int idCheck(String id) {
		
		try {
			getConn();
			
			String sql = "select * from pokemember where id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return 1; // 중복된 id가 있다는 의미
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;// 중복되지 않은 id
	}
	// ========================== 회원 중복id 확인
	
	
	
	
	
	
	
	
	
}
