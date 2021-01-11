/**
 * 
 */
package level3;

import java.util.Arrays;

public class 입국심사 {
	static class Solution {
	    public long solution(int n, int[] times) {
	    	Arrays.sort(times);
	        long answer = Long.MAX_VALUE;
	        long ln = n;
	        long left = 0;
	        long right = times[times.length-1] * ln;
	        long cnt = 0;
	        long mid = 0;
	        
	        while(left <= right) {
	        	cnt = 0;
	        	mid = (left + right) / 2;
	        	
	        	for(int i = 0; i < times.length; i++) {
	        		cnt += mid / times[i];
	        	}
	        	
	        	if(cnt >= ln) {
	        		right = mid - 1;
	        		answer = Math.min(answer, mid);
	        	}
	        	else {
	        		left = mid + 1;
	        	}
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 6;
		int times[] = {7, 10};
		System.out.println(new Solution().solution(n, times));
	}
}
