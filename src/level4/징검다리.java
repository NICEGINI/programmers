/**
 * 
 */
package level4;

import java.util.Arrays;

/**
 * @author YSM
 *
 */
public class 징검다리 {
	static class Solution {
	    public int solution(int distance, int[] rocks, int n) {
	    	Arrays.sort(rocks);
	    	
	    	int left = 1;
	    	int right = distance;
	    	int answer = 0;
	    	
	    	while(left <= right) {
	    		int removeCnt = 0;
	    		int prev = 0;
	    		int mid = (left+right)/2;
	    		
	    		for(int rock : rocks) {
	    			if((rock - prev) < mid) removeCnt++;
	    			else prev = rock;
	    		}
	    		
	    		if(distance - prev < mid) removeCnt++;
    			
    			if(removeCnt <= n) {
    				answer = Math.max(answer, mid);
    				left = mid + 1;
    			} else {
    				right = mid - 1;
    			}
	    	}
	    	
	    	return answer;
	    }
	}
	public static void main(String[] args) {
		int distance = 25;
		int rocks[] = {2, 14, 11, 21, 17};
		int n = 2;
		System.out.println(new Solution().solution(distance, rocks, n));
	}
}
