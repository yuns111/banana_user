package banana_user.domain;

public class Emotion {
	
	private int emotionNumber;
	private String emotionName;
	
	
	//생성자
	public Emotion() {
		
	}
	public Emotion(int emotionNumber, String emotionName) {
		
		this.emotionNumber = emotionNumber;
		this.emotionName = emotionName;
	}
	
	
	//getter setter
	public int getEmotionNumber() {
		return emotionNumber;
	}
	public void setEmotionNumber(int emotionNumber) {
		this.emotionNumber = emotionNumber;
	}
	public String getEmotionName() {
		return emotionName;
	}
	public void setEmotionName(String emotionName) {
		this.emotionName = emotionName;
	}

}
