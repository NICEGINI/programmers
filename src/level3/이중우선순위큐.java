/**
 * 
 */
package level3;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최대 - 최소 큐
 * 최소 - 최대 큐
 * 4개의 큐를 써야할까??
 * 생각해보자
 * */
public class 이중우선순위큐 {
	static class Solution {
	    public int[] solution(String[] operations) {
	    	PriorityQueue<Integer> minPqueue = new PriorityQueue<Integer>();
	    	PriorityQueue<Integer> maxPqueue = new PriorityQueue<Integer>(((o1,o2) -> Integer.compare(o2, o1)));
	    	
	    	
	    	for(int i = 0; i < operations.length; i++) {
	    		StringTokenizer stt = new StringTokenizer(operations[i]);
	    		String command = stt.nextToken();
	    		int num = Integer.parseInt(stt.nextToken());
	    		
	    		switch(command) {
	    		case "I":
	    			input(minPqueue, maxPqueue, num);
	    			break;
	    		case "D":
	    			delete(minPqueue, maxPqueue, num);
	    			break;
	    		}
	    	}
	    	
	        int[] answer = new int[2];
	        
	        if(minPqueue.isEmpty()) answer[0] = 0;
	        else answer[0] = minPqueue.poll();
	        if(maxPqueue.isEmpty()) answer[1] = 0;
	        else answer[1] = maxPqueue.poll();
	        
	        return answer;
	    }

		private void delete(PriorityQueue<Integer> minPqueue, PriorityQueue<Integer> maxPqueue, int num) {
			if(num == -1) { // 최소 삭제
				if(!minPqueue.isEmpty()) {
					int min = minPqueue.poll();
					maxPqueue.remove(min);
				}
			} else {
				if(!maxPqueue.isEmpty()) {
					int max = maxPqueue.poll();
					minPqueue.remove(max);
				}
			}
		}

		private void input(PriorityQueue<Integer> minPqueue, PriorityQueue<Integer> maxPqueue, int num) {
			maxPqueue.offer(num);
			minPqueue.offer(num);
			
		}
	}
	public static void main(String[] args) {
		String[] operations = {"I 16","D -1"};
		
		System.out.println(new Solution().solution(operations));
	}
}
