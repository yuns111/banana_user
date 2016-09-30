package banana_user.controller;

import java.util.ArrayList;

import banana_user.dao.EmotionDao;
import banana_user.domain.Emotion;
import banana_user.view.EmotionSelectOneView;

public class EmotionController {
	
	private EmotionDao emotionDao;
	
	public EmotionController() {
		
		emotionDao = new EmotionDao();

	}
	
	public void requestCallSelectOneEmotionView() {
		
		//감정목록 가져오기(dao)
		ArrayList<Emotion> emotionList = emotionDao.selectAllEmotion();
		
		//회원의 감정 선택(view)
		EmotionSelectOneView emotionSelectView = new EmotionSelectOneView();
		emotionSelectView.emotionSelectOne(emotionList);
		
	}

}