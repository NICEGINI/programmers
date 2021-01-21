/**
 * 
 */
package level2;

import java.util.Arrays;

/**
 * @author YSM
 *
 */
public class H_Index {
	static class Solution {
	    public int solution(int[] citations) {
	    	Arrays.sort(citations);
	    	
	    	int h_index = 0;
	    	int length = citations.length-1;
	    			
	    	for(int i = length; i >= 0; i--) {
	    		if(h_index < citations[i]) {
	    			h_index++;
	    		}
	    	}
	    	
	        int answer = h_index;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] citations = {0,1,1};
		System.out.println(new Solution().solution(citations));
	}
}
