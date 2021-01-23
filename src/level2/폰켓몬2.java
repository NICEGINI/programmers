/**
 * 
 */
package level2;

import java.util.HashSet;

/**
 * @author YSM
 *
 */
public class 폰켓몬2 {
	static class Solution {
	    public int solution(int[] nums) {
	    	int size = nums.length/2;
	    	HashSet<Integer> set = new HashSet<Integer>();
	    	
	    	for(int i = 0; i < nums.length; i++) {
	    		set.add(nums[i]);
	    	}
	    	int answer = 0;
	    	
	    	if(set.size() < size) answer = set.size();
	    	else answer = size;
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] nums= {3,3,3,2,2,2};
		System.out.println(new Solution().solution(nums));
	}
	
}
