/**
 * 
 * @author Qianying Yang
 *
 */
public class MyInteger {
	private static int value;
	private static MyInteger myInt;
	
	/**
	 * Default constructor.
	 */
	public MyInteger() {
		value = 0;
	}
	
	/**
	 * Parameterized constructor.
	 * @param n
	 */
	public MyInteger(int n) {
		value = n;
	}
	
	/**
	 * Accessory method.
	 * @return the value.
	 */
	public int getValue() {
		return value;
	}
	
	public static boolean isEven(int n) {
		if(n%2 == 0) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean isOdd(int n) {
		if(isEven(n)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean isPrime(int n) {
		if(isEven(n)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean isEven() {
		if(isEven(value)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isOdd() {
		if(isEven(value)) {
			return false;
		}
		else {
			return true;
		}
		
	}
}
