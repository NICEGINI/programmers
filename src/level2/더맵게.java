package level2;

import java.util.PriorityQueue;

public class 더맵게 {
	static class Solution {
	    public int solution(int[] scoville, int K) {
	    	PriorityQueue<Integer> pQueue = new PriorityQueue<>();
	    	
	    	for(int i = 0; i < scoville.length; i++) {
	    		pQueue.offer(scoville[i]);
	    	}

	    	int answer = 0;
	    	
	    	while(!pQueue.isEmpty()) {
	    		int minFirst = pQueue.poll();
	    		if(minFirst < K) {
		    		if(!pQueue.isEmpty()) {
		    			int minSec = pQueue.poll();
		    			minFirst = minFirst + (minSec * 2);
		    			answer++;
			    		pQueue.offer(minFirst);
		    		} else answer = -1;
	    		} else break;
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int scoville[] = {0,0,0,0,3};
		int K = 4;
		System.out.println(new Solution().solution(scoville, K));
	}
}
