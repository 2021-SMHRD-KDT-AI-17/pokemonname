package MP3Player프로그램;

public class Music {

	// 노래 한 개가 가질 수 있는 데이터(변수/속성/필드)
	// 1) 경로 + 확장자 path
	private String path;
	// 2) 노래 제목 title
	private String title;
	// 3) 가수 이름 singer
	private String singer;
	// 4) 플레이 타임 (초단위) - playTime
	private int playTime;
	// + 플레이 타임(초단위) --> 분,초 단위로 바꾼 결과값을 돌려주는 기능
	// ----> timeChange() ---> "3분 2초" : String
	
	// 필드 playTime : 182 매개변수 x 
	// 문자열 "3분 2초"로 반환
	public String timeChange() {
		int minute = playTime/60;
		int second = playTime%60;
		
		String result = minute+"분 "+second+"초";
		return result;
	}
	
	
	// + 4개의 필드를 초기화 할 수 있는 생성자
	public Music(String path, String title, String singer, int playTime) {
		this.path = path;
		this.title = title;
		this.singer = singer;
		this.playTime = playTime;
		
	}
	// + getter
	public String getPath() {
		return path;
	}
	public String getTitle() {
		return title;
	}
	public String getSinger() {
		return singer;
	}
	public int getPlayTime() {
		return playTime;
	}
			
	// Music이라는 Class를 하나 설계
	
}
