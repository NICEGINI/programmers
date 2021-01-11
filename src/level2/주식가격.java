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
public class 주식가격 {
	static class Solution {
	    public int[] solution(int[] prices) {
	    	Queue<Integer> queue = new LinkedList<Integer>();
	    	int length = prices.length;
	    	
	    	for(int i = 0; i < length - 1; i++) {
	    		int curPrice = prices[i];
	    		int time = 0;

	    		for(int j = i + 1; j < length; j++) {
	    			int nextPrice = prices[j];
	    			time++;
	    			if(curPrice > nextPrice) {
	    				break;
	    			}
	    		}
				queue.offer(time);
	    	}
	    	queue.offer(0);
	    	
	        int[] answer = new int[length];
	        
	        int idx = 0;
	        while(!queue.isEmpty()) {
	        	answer[idx++] = queue.poll();
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int prices[] = {1, 2, 3, 2, 3};
		System.out.println(new Solution().solution(prices));
	}
}
