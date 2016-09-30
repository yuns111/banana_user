package banana_user.domain;

public class Music {
	
	private int musicNumber;
	private String title;
	private String singer;
	private String lyrics;
	private int emotionNumber;
	private int playingCount;
		
	public Music() {
		
	}

	public Music(int musicNumber, String title, String singer) {
		this.musicNumber = musicNumber;
		this.title = title;
		this.singer = singer;		
	}
	
	public int getMusicNumber() {
		return musicNumber;
	}
	
	public void setMusicNumber(int musicNumber) {
		this.musicNumber = musicNumber;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSinger() {
		return singer;
	}
	
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getLyrics() {
		return lyrics;
	}
	
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	
	public int getEmotionNumber() {
		return emotionNumber;
	}
	
	public void setEmotionNumber(int emotionNumber) {
		this.emotionNumber = emotionNumber;
	}
	
	public int getPlayingCount() {
		return playingCount;
	}
	
	public void setPlayingCount(int playingCount) {
		this.playingCount = playingCount;
	}
	
}