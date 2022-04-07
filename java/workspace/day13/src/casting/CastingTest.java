package casting;

class Car{
   public void engineStart() {
      System.out.println("열쇠로 시동 킴");
   }
}

class SuperCar extends Car{
   
   @Override
   public void engineStart() {
      System.out.println("음성으로 시동 킴");
   }
   
   public void openRoof() {
      System.out.println("지붕 열림");
   }
}

public class CastingTest {
   public static void main(String[] args) {
      Car matiz = new Car();
      SuperCar ferrari = new SuperCar();
      //up casting
      Car noOptionFerrari = new SuperCar();

      //자식에서 재정의된 값은 들어가지만
//      noOptionFerrari.engineStart();
      
      //자식에서 추가로 만든 필드는 사용할 수 없다.
//      noOptionFerrari.openRoof();
      
      //자식에 부모 값을 담을 수 없다.
//      SuperCar brokenFerrari = (SuperCar)new Car();
      
      //down casting
      SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
//      fullOptionFerrari.openRoof();
      
//      matiz instanceof Car                     : true
      System.out.println(matiz instanceof Car);
//      matiz instanceof SuperCar               : false
      System.out.println(matiz instanceof SuperCar);
//      ferrari instanceof Car                  : true
      System.out.println(ferrari instanceof Car);
//      ferrari instanceof SuperCar            : true
      System.out.println(ferrari instanceof SuperCar);
//      noOptionFerrari instanceof Car         : true
      System.out.println(noOptionFerrari instanceof Car);
//      noOptionFerrari instanceof SuperCar   : true
      System.out.println(noOptionFerrari instanceof SuperCar);
//      fullOptionFerrari instanceof Car         : true
      System.out.println(fullOptionFerrari instanceof Car);
//      fullOptionFerrari instanceof SuperCar   : true
      System.out.println(fullOptionFerrari instanceof SuperCar);
   }
}






















