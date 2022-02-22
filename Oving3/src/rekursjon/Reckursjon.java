package rekursjon;

public class Reckursjon {
	
	
	private static long[] fibonacciLagring;
	
	public static void main(String[] args) {
		
		
		
		System.out.println(iterativFib(7));
	
		
	}
	
	
	public static int sum(int n ) {
		
		if(n  > 1) {
			return n + sum(n-1);
		} else {
			return 1;
		}
	}
	
	public static int tallfølge(int n) {
		
		if(n == 0) {
			return 2;
		}
		else if(n == 1) {
			return 5;
		}
		else {
			return 5*tallfølge(n-1) - 6*tallfølge(n-2) +2;
		}

}
	public static int rekursiveFib(int n) {
		
		
		if(n == 1 || n == 0) {
			return n;
		}
		else {
			return rekursiveFib(n-1) + rekursiveFib(n-2);
		}
		
	}
	
	public static int iterativFib(int n) {
		
		
		if(n == 1) {
			return 1;
		}

		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		
		int fib = 0;
		
		for (int i = 2; i <= n; ++i) {
			
			fib = n1+n2;
			n1= n2;
			n2= fib;
		}
		
		return fib;
	}
	

	
	}
