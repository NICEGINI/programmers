/**
 * 
 */
package level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class 다리를_지나는_트럭2 {
	static class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	    	Queue<Integer> passingQueue = new LinkedList<Integer>(); // 건너는 중인 트럭
	    	Queue<Integer> timeQueue = new LinkedList<Integer>(); // 건너는 중인 트럭
	    	
	    	int answer = 0; // 경과시간
	    	int curWeight = 0; // 다리 위 전체 무게
	    	int length = truck_weights.length;
	    	int nextIdx = 0;
	    	
	    	while(true) {
	    		answer++;
	    		
	    		if(!passingQueue.isEmpty()) {
		    		if(answer - timeQueue.peek() == bridge_length) {
		    			curWeight -= passingQueue.poll();
		    			timeQueue.poll();
		    		}
	    		}
	    		
	    		int nextTruck = truck_weights[nextIdx];
	    		
	    		if(curWeight + nextTruck <= weight) {
	    			passingQueue.offer(nextTruck);
	    			timeQueue.offer(answer);
	    			nextIdx++;
	    			curWeight += nextTruck; 
	    		}
	    		if(nextIdx >= length) break;
	    	}
	    	answer += bridge_length;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int truck_weights[] = {10};// 7,4,5,6
		
		System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
	}
}
