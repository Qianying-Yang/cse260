import java.util.Scanner;
public class PrintNumbers {
	
	public static void main(String[] args) {
		printNumbers();
	}
	
	public static int[] printNumbers() {
		int[] result = new int[10];
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		for(int i = 0; i< 10; i++) {
			boolean isSame = false;
			System.out.print("Please enter a number: ");
			int num = sc.nextInt(); 
			
			for(int j = 0; j<i; j++) {
				if(num == result[j]) {
					isSame = true;
					j = i;
				}
			}
			if(isSame == false) {
				result[count] = num;
				count++;
			}
		}
		for(int i = 0; i<result.length; i++) {
			if(result[i] == 0) {
				i++;
			}
			else{
				System.out.print(result[i] + " ");
			}	
		}
		return result;
	
	}

}
