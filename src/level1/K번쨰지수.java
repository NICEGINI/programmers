/**
 * 
 */
package level1;

import java.util.Arrays;

/**
 * @author YSM
 *
 */
public class K번쨰지수 {
	static class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	    	int command_idx = 0;
	    	int command_length = commands.length;
	    	int[] answer = new int[command_length];
	    	 
	    	for(int i = 0; i < commands.length; i++) {
	    		int start = commands[i][0];
	    		int end = commands[i][1];
	    		int find = commands[i][2]-1;
	    		int new_length = end - start + 1;
	    		int[] new_arr = new int[new_length];
	    		
	    		int idx = 0;
	    		for(int j = start-1; j < end; j++) {
	    			new_arr[idx++] = array[j]; 
	    		}
	    		Arrays.sort(new_arr);
	    		answer[command_idx++] = new_arr[find];
	    	}
	       
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3}, {4, 4, 1}, {1, 7, 3}
		};
		System.out.println(new Solution().solution(array, commands));
	}
}
