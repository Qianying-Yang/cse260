
public class CollatzConjecture {
	
	public static void main(String[] args) {
		System.out.println(howManyCollatzIterations(53));
	}

	public static int howManyCollatzIterations(int n) {
		if(n == 1) {
			return 0;
		}
		else {
			if(n%2 == 0) {
				return 1 + howManyCollatzIterations(n/2);
			}
			else {
				return 1 + howManyCollatzIterations(3*n+1);
			}
		}
	}
}
