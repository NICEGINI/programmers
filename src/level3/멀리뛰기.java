/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 멀리뛰기 {
	static class Solution {
	    public long solution(int n) {
	    	if(n==1) return 1;
            long[] jump = new long[n];
	    	jump[0] = 1;
	    	jump[1] = 2;
	    	
	    	for(int i = 2; i < n; i++) {
	    		jump[i] = jump[i-1]%1234567 + jump[i-2]%1234567;
	    	}
	        long answer = jump[n-1]%1234567;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 4;
		System.out.println(new Solution().solution(n));
	}
}
