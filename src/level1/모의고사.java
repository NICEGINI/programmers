/**
 * 
 */
package level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 모의고사 {
	static class Solution {
		int resMax;
	    public int[] solution(int[] answers) {
	    	int[] first = {1, 2, 3, 4, 5};
	    	int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
	    	int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	    	
	    	List<Integer> list = new ArrayList<Integer>();
	    	
	    	resMax = Integer.MIN_VALUE;
	    	process(1, first, answers, list);
	    	process(2, second, answers, list);
	    	process(3, third, answers, list);
	    	
	        int[] answer = new int[list.size()];
	        
	        for(int i = 0; i < list.size(); i++) {
	        	answer[i] = list.get(i);
	        }
	        System.out.println(answer);
	        return answer;
	    }
	    
		private void process(int order, int[] numbers, int[] answers, List<Integer> list) {
			int idx = 0;
			int answer = 0;
			for(int i = 0; i < answers.length; i++) {
				if(numbers[idx++] == answers[i]) {
					answer++;
				}
				if(idx == numbers.length) idx = 0;
			}
			
			if(answer > resMax) {
				list.clear();
				list.add(order);
				resMax = answer;
				return ;
			}
			
			if(answer == resMax) {
				list.add(order);
				return ;
			}
		}
	}
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		
		System.out.println(new Solution().solution(answers));
	}
}
