package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDAO {

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
	
	public int PlayScore(ScoreDTO dto) {

		int cnt = 0;

		try {
			getConn();

			String sql = "INSERT INTO score(ID,SCORE) VALUES(?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setInt(2, dto.getScore());

			cnt = psmt.executeUpdate(); // DML에서 사용함 INSERT, UPDATE, DELETE

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	

	}
	// =============================================기록 저장
	
	
	
	public ArrayList<ScoreDTO> rank() {

		// DB에서 조회된 정보를 저장할 임시 객체
		ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

		try {
			getConn();

			String sql = "select id, score from (select id, MAX(score) as score "
					+ "from play group by id order by score desc) where rownum <= 10";

//			String sql = "select id, max(score) as score\r\n" + "from score\r\n" + "group by id\r\n"
//					+ "order by score desc";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				ScoreDTO dto = new ScoreDTO();
				dto.setId(rs.getString(1));
				dto.setScore(rs.getInt(2));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	
	}
	// ======================================= 상위 10명 랭크보기
	
	
	public ArrayList<ScoreDTO> history(String id) {

		ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

		try {
			getConn();

			String sql = "select score from score where id = ? and rownum <= 5 order by indate desc";
				// 기록을 일단 최근 5개만 보게 설정할까요??
			
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {

				ScoreDTO dto = new ScoreDTO();
				dto.setId(rs.getString(1));
				dto.setScore(rs.getInt(2));
				dto.setIndate(rs.getString(3));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	// =========================== 플레이어의 최근 5개 기록 보기
	
	
}
