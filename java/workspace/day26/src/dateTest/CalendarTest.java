package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
   public static void main(String[] args) {
      Calendar today = Calendar.getInstance();
      System.out.println(today);
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      //Calendar 타입의 객체를 Date타입으로 변환한 뒤
      //format()을 사용해야 한다. 이 때 getTime()을 사용한다.
      System.out.println(sdf.format(today.getTime()));
      
      today.set(1999, 11, 4); //Month는 0부터 시작한다.
      System.out.println(sdf.format(today.getTime()));
      
      System.out.println(today.get(Calendar.YEAR));
      System.out.println(today.get(Calendar.MONTH) + 1);
      
   }
}