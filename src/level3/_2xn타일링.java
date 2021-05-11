/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class _2xn타일링 {
	static class Solution {
	    public int solution(int n) {
	    	int mod = 1000000007;
	    	int[] fibo = new int[n+1];
	    	fibo[1] = 1;
	    	fibo[2] = 2;
	    	for(int i = 3; i <= n; i++) {
	    		fibo[i] = fibo[i-1]%mod + fibo[i-2]%mod;
	    	}
	    	
	        int answer = fibo[n]%mod;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 4;
		System.out.println(new Solution().solution(n));
	}
}
