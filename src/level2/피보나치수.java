/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 피보나치수 {
	static class Solution {
	    public int solution(int n) {
	    	int mod = 1234567;
	    	int[] fibo = new int[n+1];
	    	
	    	fibo[0] = 0;
	    	fibo[1] = 1;
	    	
	    	for(int i = 2; i <= n; i++) {
	    		fibo[i] = fibo[i-2]%mod + fibo[i-1]%mod;
	    	}
	    	
	        int answer = fibo[n]%mod;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(new Solution().solution(n));
	}
}
