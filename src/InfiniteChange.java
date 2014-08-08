//given an infinite change, we have to figure out how much ways we can pay the bill
public class InfiniteChange {

	public static int numWays(int n, int denom){
			int next_denom = 0;
			switch (denom) {
			case 25:
			next_denom = 10;
			break;
			case 10:
			next_denom = 5;
			break;
			case 5:
			next_denom = 1;
			break;
			case 1:
			return 1;
			}
			int ways = 0;
			for (int i = 0; i * denom <= n; i++) {
			ways += numWays(n - i * denom, next_denom);
			}
			return ways;
	}
	public static int numWays(int n){
		if(n < 0)
			return 0;
		if(n == 1)
			return 1;
//		if(n == 5)
//			return 2;
//		if(n == 10)
//			return 4;
//		if(n == 25)
//			return (1 + numWays(24));
		return numWays(n-1) + numWays(n-5) + numWays(n-10) + numWays(n-25);
	}
	
	public static void main(String[] args) {
		System.out.println("the number of ways is " + numWays(5));
	}
	
}
