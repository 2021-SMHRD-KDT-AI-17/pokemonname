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
	// pokemon.book();의 배열 값
	public PokemonDTO hint(PokemonDTO dto) {

		// 결과를 담을 DTO 생성
		PokemonDTO result = null;

		// try~catch문(예외처리구문)
		// - 실행할 로직에 오류가 있는지 없는지 체크한 후
		// 오류에 대한 대체를 할 수 있도록 제공하는 구만
		// try구문: 실행할 로직
		// catch문: 오류가 발생했을 때 실행할 로직
		// finally: try~catch와 무관하게 무저건 실행해야 하는 로직을 구현
		try {
			getConn();
			// 3. SQL관련처리(SQL작성, 실행)
			// PrepareStatement
			// - 데이터베이스에 SQL문장을 보내는 통로 역할
			String sql = "SELECT hint FROM MEMBER WHERE num=?";

			psmt = conn.prepareStatement(sql);
			// - SQL문장에 동적인 값을 넣어야 하는 컬럼은 물음표로 표기(?)
			// - 물음표에 값을 넣을 수 있는 setter()메소드를 활용
			psmt.setInt(1, dto.getNum());

			// SQL실행 및 결과처리
			// - SELECT문 : executeQuery() (DB변화 X)
			// - INSERT, UPDATE,DELETE문 : executeUpdate() (DB변화 O)
			// - 데이터베이스에 변화를 주는지에 따라 위 메소드를 호출

			// ResultSet
			// - DB에서 조회된 정보를 저장하는 객체
			// - 데이터를 가리키는 cursor가 있는데 next() 호출을 통해서
			// 다음 행으로 넘겨줘야 데이터 접근이 가능하다!
			rs = psmt.executeQuery();

			// - next()를 통해서 행을 내려갔을 때 데이터가 있으면 true
			// 없으면 false를 반환
			// - 데이터가 있는 경우 타입에 맞는 getter()메소드를 호출
			// - 인자값으로는 컬럼의 인덱스 또는 컬럼명으로 전달
			if (rs.next()) {
				result = new PokemonDTO();

				int getnum = rs.getInt(1);

				// 조회 결과를 DTO에 옮겨 담기 필요
				result.setNum(getnum);

			} else {

			}

			// DAO의 리턴: SQL문을 실행(execute)한 결과
			// 단 Select문을 실행시! 조회결과로부터 빼낸 데이터를 리턴해야 함.
			// --> JAVA는 하나만 리턴 가능?? --> DTO(Model)

		} catch (SQLException e) { // Exception 모든 예외 상항 / SQLException SQL 예외사항
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// Hard 그림 절반만 출력
	public void Hprint() {

	}

	// Hard 힌트 시 그림 전체 출력
	public void HHint() {

	}

	// 정답이 db 번호 와 똑같은지
	
	

}
