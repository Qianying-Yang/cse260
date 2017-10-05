
public class TimingExecution {
	private static int[] array = new int[100000];
	private static int key = (int) (Math.random()*100000 + 1);
	
	public static void main(String[] args) {
		initiallize();
		System.out.println(linearSearchTime());
		System.out.println(binarySearchTime());
	}
	
	public static void initiallize() {
		for(int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random()*100000 + 1);
		}
	}
	
	public static long linearSearchTime() {
		long startTime = System.currentTimeMillis();
		
		//time of execution
		for(int i = 0; i<array.length; i++) {
			if(array[i] == key) {	
				long endTime = System.currentTimeMillis();
				long executionTime = endTime - startTime;	
				return executionTime;
			}
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}

	public static long binarySearchTime() {
		long startTime = System.currentTimeMillis();
		sort();
		int low = 0;
		int high = array.length - 1;
		while (high >= low) {
			int mid = (low + high) / 2; 
			if (key < array[mid]) {
				high = mid - 1;
			}
		    else if (key == array[mid]) {
		    	long endTime = System.currentTimeMillis();
				long executionTime = endTime - startTime;
				return executionTime;
		    }   
		    else {
		    	low = mid + 1;
		    }
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;	
		return executionTime;
	}
	
	public static void sort() {
		for(int i=1; i<array.length; i++){
			int pos;
			for(pos=0; pos<i; pos++) {
				 if(array[pos]>array[i])
		              break;
			}      
			int temp = array[i];
			for(int j=i; j>pos; j--) {
				array[j] = array[j-1];
			}			       
			array[pos] = temp;
		}
	}	
}
