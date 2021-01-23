/**
 * 
 */
package level2;

import java.util.HashSet;

/**
 * @author YSM
 *
 */
public class 폰켓몬 {
	static class Solution {
		int maxCnt;
	    public int solution(int[] nums) {
	    	int size = nums.length/2;
	    	HashSet<Integer> set = new HashSet<Integer>();
	    	
	    	combination(0, size, nums, set);
	        int answer = maxCnt;
	        return answer;
	    }

		private void combination(int idx, int size, int[] nums, HashSet<Integer> set) {
			if(idx == size) {
				maxCnt = maxCnt > set.size() ? maxCnt : set.size(); 
				return ;
			}
			for(int i = idx; i < nums.length; i++) {
				HashSet<Integer> newset = new HashSet<Integer>(set);
				newset.add(nums[i]);
				combination(idx+1, size, nums, newset);
			}
		}
	}
	public static void main(String[] args) {
		int[] nums= {3,3,3,2,2,2};
		System.out.println(new Solution().solution(nums));
	}
	
}
