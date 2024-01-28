package Model;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicCon {
	MP3Player bgm = new MP3Player();
	
	public void musicPlay(int index, ArrayList<PokemonMusic> musicList) {
		bgm.play(musicList.get(index).getPath());
	}
	public void musicStop() {
		if (bgm.isPlaying()) {
			bgm.stop();
		}
	}

}
