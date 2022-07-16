package challenges;

public class Challenge1 {
	public static void main(String[] args) {
		
		int n=9;
	    System.out.println("The nth number in the fibonacci sequence given that n is " + n + " is " + fib(n));
	    int f=2;
	    System.out.println(isFibonacci(f)?f + " is a fibonacci number":f + " is a not fibonacci number");
	    nearestFibonacci(f);
	}
	    
	public static int fib(int n) {
		if(n<=1) {
			return n;
		}
		return fib(n-1)+fib(n-2);
	}
		
	public static boolean isPerfectSquare(int x) {
		int s=(int)Math.sqrt(x);
		return (s*s==x);
	}
		
	public static boolean isFibonacci(int n) {
		return isPerfectSquare(5*n*n+4) || isPerfectSquare(5*n*n-4);
	}
		
	public static void nearestFibonacci(int n) {
		if(n==0) {
			return;
		}
		int first=0;
		int second=1;
		int third=first+second;
		while(third<=n) {
			first=second;
			second=third;
			third=first+second;
		}
			
		int nearestFib=(Math.abs(third-n)>=Math.abs(second-n))?second:third;
		System.out.println("The nearest fibonacci number to f is " + nearestFib);
	}
}
