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
public class 다리를_지나는_트럭 {
	static class Solution {
		static class Truck{
			int weight, time;

			public Truck(int weight, int time) {
				this.weight = weight;
				this.time = time;
			}
		}
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	    	Queue<Truck> passingQueue = new LinkedList<Truck>(); // 건너는 중인 트럭
	    	
	    	int answer = 0; // 경과시간
	    	int curWeight = 0; // 다리 위 전체 무게
	    	int length = truck_weights.length;
	    	int nextIdx = 0;
	    	
	    	while(true) {
	    		answer++;
	    		
	    		if(!passingQueue.isEmpty()) {
	    			Truck firstTruck = passingQueue.peek();
	    			
		    		if(answer - firstTruck.time == bridge_length) {
		    			curWeight -= passingQueue.poll().weight;
		    		}
	    		}
	    		
	    		int nextTruck = truck_weights[nextIdx];
	    		
	    		if(curWeight + nextTruck <= weight) {
	    			passingQueue.offer(new Truck(nextTruck, answer));
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
