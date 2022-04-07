package casting;

import java.util.Iterator;
import java.util.Scanner;

//넷플릭스
//애니메이션, 영화, 드라마 클래스를 선언한다.

public class CastingTask extends Video{
	// 사용자가 선택한 영상을 전달받은 뒤
	// 각 카테고리 별 구현된 기능을 사용하는 메소드 선언
	public static void check(Video video) {
		// 외부에서 들어온 자식 타입이 Animation이라면
		if(video instanceof Animation) {
			// Animation타입으로 down casting 해준다.
			Animation ani = (Animation)video;
			// down casting된 객체로 새롭게 추가된 필드를 사용할 수 있다.
			ani.animate();
		}else if(video instanceof Film) {
			Film f = (Film)video;
			f.playFilm();
		}else if(video instanceof Drama) {
			Drama d = (Drama)video;
			d.sellGoods();
		}else {
			System.out.println("없는 영화입니다.");
		}
	}

	public static void main(String[] args) {
		Video[] arVideo = {
				new Animation(),
				new Film(),
				new Drama()
		};
		
		for (int i = 0; i < arVideo.length; i++) {
			CastingTask.check(arVideo[i]);			
		}

		
		
	}
}