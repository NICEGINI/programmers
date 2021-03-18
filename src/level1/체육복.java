/**
 * 
 */
package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 체육복 {
	static class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	    	int prepared = n - lost.length;
	    	
	    	Arrays.sort(lost);
	    	Arrays.sort(reserve);
	    	
	    	List<Integer> lost_list = new ArrayList<Integer>();
	    	List<Integer> reserve_list = new ArrayList<Integer>();
	    	
	    	for(int i = 0; i < reserve.length; i++) {
	    		reserve_list.add(reserve[i]);
	    	}
	    	
	    	List<Integer> remove_list = new ArrayList<Integer>();
	    	
	    	for(int i = 0; i < lost.length; i++) {
	    		boolean flag = false;
	    		for(int j = 0; j < reserve_list.size(); j++) {
	    			if(lost[i] == reserve_list.get(j)) {
	    				flag = true;
	    				reserve_list.remove(j);
	    				prepared++;
	    				break;
	    			}
	    		}
	    		if(!flag)
	    			lost_list.add(lost[i]);
	    	}
	    	
	    	
	    	if(reserve_list.size() == 0 ||
	    	   lost_list.size() == 0) return prepared;
	    	
	    	int lost_idx = 0;
	    	for(int i = 0; i < reserve_list.size(); i++) {
	    		int reserve_num = reserve_list.get(i);
	    		for(int j = lost_idx; j < lost_list.size(); j++) {
	    			int lost_num = lost_list.get(j);
	    			int diff = Math.abs(lost_num - reserve_num);
	    			
	    			if(diff == 1) {
	    				prepared++;
	    				lost_idx = j+1;
	    				break;
	    			}
	    		}
	    		if(prepared == n) break;
	    		if(lost_list.size() == 0) break;
	    	}
	        int answer = prepared;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {3};
		
		System.out.println(new Solution().solution(n, lost, reserve));
	}
}
