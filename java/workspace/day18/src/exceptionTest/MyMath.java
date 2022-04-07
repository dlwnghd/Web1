package exceptionTest;

/**
 * 
 * @author alion
 *<br>
 *Calculator
 *<br>
 *@since JDK11
 *
 */
public class MyMath {
	
	/**
	 * The div method is that num1 divide by num2
	 * 
	 * @param num1 : First Number to divide.
	 * @param num2 : Last Number to divide.
	 * <br>
	 * example)
	 * <br>
	 * div(10,3)
	 * <br>
	 * it is returning 3
	 * @throws ArithmeticException
	 * @see {@link Math}
	 */
	
	public void div(int num1, int num2) {
		System.out.println(num1 / num2);
	}
}
