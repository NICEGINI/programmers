/**
 * 
 */
package line_coding_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class test3 {
	static class Solution {
	    public int[] solution(int[] enter, int[] leave) {
	    	// 퇴실 하는 자신이 나올 때 까지 입실 시켜주자
	    	int[] answer = new int[enter.length];
	    	List<Integer> enter_list = new ArrayList<Integer>();
	    	
	    	int enter_cnt = 0;
	    	for(int i = 0; i < leave.length; i++) {
	    		int entry = leave[i];
	    		int meet_cnt = 0;
	    		for(int j = enter_cnt; j < enter.length; j++) {
	    			boolean flag = false;
		    		if(entry == enter[j]) {
		    			for(int k = 0; k < enter_list.size(); k++) {
		    				if(enter_list.get(k) == entry) {
		    					enter_list.remove(k);
		    					flag = true;
		    					break;
		    				}
		    			}
		    			if(!flag) {
		    				answer[entry-1] = meet_cnt;
		    			}
		    			break;
		    		}
		    		meet_cnt++;
		    		enter_cnt++;
		    		enter_list.add(enter[j]);
	    		}
	    		for(int entered: enter_list) {
	    			answer[entered-1] += meet_cnt;
	    		}
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] enter = {1, 4, 2, 3};
		int[] leave = {2, 1, 3, 4};
		System.out.println(new Solution().solution(enter, leave));
	}
}
