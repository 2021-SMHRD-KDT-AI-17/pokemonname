package MP3Player;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class Main {

	public static void main(String[] args) {

		MP3Player mp3 = new MP3Player();
		// 1) 재생하기 : 전달인자로 노래파일의 경로가 필요하다!
//		mp3.play("C:\\Users\\SMHRD\\Desktop\\교육자료\\자바\\music\\Anne Marie - 2002.mp3");
		// 원화 \\

		// 2) 멈추기
//		mp3.stop();
		// 3) 노래가 재생중인지 아닌지 판단(t/f)
//		mp3.isPlaying();

//		System.out.println(mp3.isPlaying());
		
		// 1) 노래 10곡에 대해 Music 설계도를 사용해서 객체 생성 및 필드 초기화 코드
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\교육자료\\자바\\music\\";
		Music m1 = new Music(defaultPath + "Anne Marie - 2002.mp3", "2002", "Anne Marie", 257);
		Music m2 = new Music(defaultPath + "Billie Eilish - bad guy.mp3", "bad guy", "Billie Eilish", 187);
		Music m3 = new Music(defaultPath + "Carmen Twillie, Lebo M. - Circle of Life.mp3", "Circle of Life",
				"Carmen Twillie, Lebo M.", 154);
		Music m4 = new Music(defaultPath + "CHUNG HA - 벌써 12시.mp3", "벌써 12시", "CHUNG HA", 143);
		Music m5 = new Music(defaultPath + "Idina Menzel - Let It Go.mp3", "Let It Go", "Idina Menzel", 200);
		Music m6 = new Music(defaultPath + "Itzy - Dalla Dalla.mp3", "Dalla Dalla", "Itzy", 216);
		Music m7 = new Music(defaultPath + "JENNIE - SOLO.mp3", "SOLO", "JENNIE", 227);
		Music m8 = new Music(defaultPath + "Mena Massoud, Naomi Scott - A Whole New World.mp3", "A Whole New World",
				"Mena Massoud, Naomi Scott", 121);
		Music m9 = new Music(defaultPath + "Rain - 깡.mp3", "깡", "Rain", 149);
		Music m10 = new Music(defaultPath + "SHINee - Ring Ding Dong.mp3", "Ring Ding Dong", "SHINee", 237);
		
		ArrayList<Music> musicList = new ArrayList<>();
		
		musicList.add(m1);
		musicList.add(m2);
		musicList.add(m3);
		musicList.add(m4);
		musicList.add(m5);
		musicList.add(m6);
		musicList.add(m7);
		musicList.add(m8);
		musicList.add(m9);
		musicList.add(m10);
		
		

		// m1 ~ m10 까지 만들기 !
		// 2) Music 자료형을 관리하는 ArrayList를 만들어보자! - musicList
		// 3) musicList에 m1 ~ m10을 추가하자

		Scanner sc = new Scanner(System.in);
		int index = 0;

		while (true) {
			System.out.print("[1]노래목록보기 [2]재생 [3]이전곡 [4]다음곡 [5]정지 [6]종료 >> ");
			int select = sc.nextInt();

			if (select == 1) {
				// console
				// 1. Anne Marie - 2002, 4분 17초 ... 10개
				// Controller에 있는 기능 listPrint를 사용하려면
				// 1) Controller 객체 생성이 되어야 한다.
				Controller con = new Controller();
				
				// ArrayList<Music> musicList = 생성
				
				con.listPrint(musicList);
				
			} else if (select == 2) {
				mp3.play(musicList.get(index).getPath());
				// 현재 재생중인 노래에 대한 정보도 같이 보여주세요
				// 1. Anne Marie - 2002, 4분 17초 노래가 재생중입니다.
				// 1번 노래가 재생되어야함!
				
				Controller con = new Controller();
				con.printOne(index, musicList);
				
			} else if (select == 3) {
				index--;
				if (index < 0)
					index = musicList.size() - 1;

				System.out.println((index + 1) + ". " + musicList.get(index).getSinger() + " - "
						+ musicList.get(index).getTitle() + ", " + musicList.get(index).timeChange());

//				if (mp3.isPlaying())
//					mp3.stop();
				
//				mp3.play(musicList.get(index).getPath());
				Controller con = new Controller();
				con.musicStop();
				con.musicPlay(musicList, index);

			} else if (select == 4) {

				index++;
				if (index >= musicList.size())
					index = 0;

				System.out.println((index + 1) + ". " + musicList.get(index).getSinger() + " - "
						+ musicList.get(index).getTitle() + ", " + musicList.get(index).timeChange());

				if (mp3.isPlaying())
					mp3.stop();
				mp3.play(musicList.get(index).getPath());

			} else if (select == 5) {
				mp3.stop();
				System.out.println("노래 재생이 정지되었습니다.");

			} else {
				System.out.println("노래가 종료되었습니다.");
				break;
			}

		}

	}

}
