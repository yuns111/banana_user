package banana_user.view;

import java.util.StringTokenizer;

import banana_user.domain.Music;

public class MusicPlayingView {

	public void unLoginPlaying(Music selectedMusic){

		System.out.println("[알림] 로그인 해주세요! 일부듣기만 가능합니다.");
		StringBuilder sb = new StringBuilder(selectedMusic.getLyrics());
		sb.delete(50, 1000);

		System.out.println(sb.toString());

	}

	public void noTicketPlaying(Music selectedMusic){

		System.out.println("[알림] 이용권을 구매 해주세요! 일부듣기만 가능합니다.");
		StringBuilder sb = new StringBuilder(selectedMusic.getLyrics());
		sb.delete(50, 1000);

		System.out.println(sb.toString());

	}

	public void musicPlaying(Music selectedMusic){

		System.out.println("노래가 재생됩니다.");

		StringTokenizer st = new StringTokenizer(selectedMusic.getLyrics()," ");

		int tokenCount = st.countTokens();

		for(int i=0; i<tokenCount; i++){

			String token = st.nextToken();
			System.out.print(token);
			System.out.print(" ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("[알림] 노래재생에 오류가 있습니다.");
			}
			if(i%10 == 0){
				System.out.println();
			}
		}

	}
}
