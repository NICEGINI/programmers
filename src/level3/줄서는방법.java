/**
 * 
 */
package level3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 줄서는방법 {
	static class Solution {
	    public int[] solution(int n, long k) {
	    	long[] facto = new long[n+1];
	    	facto[0] = 1;
	    	for(int i = 1; i <= n; i++) {
    			facto[i] = i*facto[i-1];
	    	}
	    	
	    	int[] answer = new int[n];
	    	
	    	process(0, n, answer, facto, k-1);
	    	
	    	
	        return answer;
	    }

		private void process(int idx, int n, int[] answer, long[] facto, long k) {
			List<Integer>list = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++) {
				list.add(i);
			}
	    	while(n > 0) {
	    		long value = k/facto[n-1];
	    		answer[idx++] = list.get((int)value);
	    		list.remove((int)value);
	    		k = k % facto[n-1];
	    		n--;
	    	}
		}
	}
	public static void main(String[] args) {
		int n = 3, k = 5;
		System.out.println(new Solution().solution(n, k));
	}
}
