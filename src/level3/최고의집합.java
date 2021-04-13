/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 최고의집합 {
	static class Solution {
	    public int[] solution(int n, int s) {
	    	if(n > s) {
	    		int[] ans = {-1};
	    		return ans;
	    	}
	    	
	    	if(s%n == 0) {
	    		int divide = (int) Math.ceil(s/n);
	    		int[] answer = new int[n];
	    		for(int i = 0; i < n; i++) {
	    			answer[i] = divide;
	    		}
	    		return answer;
	    	}
	    	
	    	int divide = (int) Math.ceil(s/n);
	    	int diff = s - divide*n;
    		int[] answer = new int[n];
	    	for(int i = n-1; i >= 0; i--) {
	    		if(diff-- > 0)
	    			answer[i] = divide+1;
	    		else
	    			answer[i] = divide;
	    	}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 4;
		int s = 11;
		System.out.println(new Solution().solution(n, s));
	}
}
