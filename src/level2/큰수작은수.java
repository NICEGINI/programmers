/**
 * 
 */
package level2;

import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 큰수작은수 {
	static class Solution {
	    public String solution(String s) {
	    	String[] nums = s.split(" ");
	    	PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((s1,s2) -> {
	    		return Integer.compare(s1, s2);
	    	});
	    	
	    	PriorityQueue<Integer> pQueueMax = new PriorityQueue<Integer>((s1,s2) -> {
	    		return Integer.compare(s2, s1);
	    	});
	    	
	    	for(int i = 0; i < nums.length; i++) {
	    		pQueue.offer(Integer.parseInt(nums[i]));
	    		pQueueMax.offer(Integer.parseInt(nums[i]));
	    	}
	    	String answer = pQueue.poll()  + " " + pQueueMax.poll();
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4 1 2 3 4";
		System.out.println(new Solution().solution(s));
	}
}
