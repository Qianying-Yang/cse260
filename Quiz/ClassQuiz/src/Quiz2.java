
public class Quiz2 {
	
	public static void main(String[] args) {
		String hex1 = "8";
		System.out.println(hexamal2decimal(hex1));
		int deci1 = 32;
		System.out.println(decimal2binary(deci1));
	}

	/**
	 * 
	 * @param hex
	 * @return
	 */
	public static int hexamal2decimal(String hex) {
		int result = 0;
		int exp = hex.length()-1;
		for(int i = 0; i<hex.length(); i++) {
			
		}
		return result;
	}
	
	
	public static String decimal2binary(int n) {
		if(n/2 == 0) {
			return n%2 + "";
		}
		else {
			return decimal2binary(n/2) + n%2;
		}
	}
	
	public static String decimal2hex(int n) {
		return null;
	}
	
	public static int binary2decimal(String b) {
		int result = 0;
		int decimal = Integer.parseInt(b);
		for(int i = 0; i<b.length()-1; i++) {
						
		}
		return result;
	}
}
