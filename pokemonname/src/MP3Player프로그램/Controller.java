package MP3Player프로그램;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class Controller {

	// MP3Player 기능
	
	
	
	// 1) 전체 노래 목록
	public void listPrint(ArrayList<Music> musicList) {
		for (int i = 0; i < musicList.size(); i++) {
			System.out.println(i + 1 + ". " + musicList.get(i).getSinger() + " - " + musicList.get(i).getTitle()
					+ ", " + musicList.get(i).timeChange());
		}System.out.println();
	}
	
	// musicList가 필요 --> musicList는 Main에 있음
	// musicList(노래 10곡이 저장된 가변배열)를 받아와야함!
	
	// 2) 현재 재상중인 노래에 대한 정보를 출력해주는 기능
	public void printOne(int index, ArrayList<Music> musicList) {
		System.out.println(index + 1 + ". " + musicList.get(index).getSinger() + " - "
				+ musicList.get(index).getTitle() + ", " + musicList.get(index).timeChange());
	}
	
	// 3) 노래를 재생하는 기능
	// MusicList에 저장된 경로가 필요
	// musicList는 Main에 있음
	// 노래의 현재 위치...도 필요...
	public void musicPlay(ArrayList<Music> musicList, int index) {
		MP3Player mp3 = new MP3Player();
		mp3.play(musicList.get(index).getPath());
	}
	
	
	// 4) 노래를 멈추는 기능
	public void musicStop() {
		MP3Player mp3 = new MP3Player();
		if (mp3.isPlaying())
			mp3.stop();
	}
	
	
	// + 노래를 재생하고 멈추는 메서드는 MP3Player.class에 만들어져있음.
	
	
	
	
	
}
