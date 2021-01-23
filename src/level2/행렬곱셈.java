/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 행렬곱셈 {
	static class Solution {
	    public int[][] solution(int[][] arr1, int[][] arr2) {
	    	/*
	    	 * 2x3 * 3x2 일 때 2x2가 된다.
	    	 * 즉, arr1의 길이가 열길이
	    	 * arr2[0]의 길이가 행의 길이가 된다
	    	 * */
	        int[][] answer = new int[arr1.length][arr2[0].length];
	        
	        // arr1의 열 인덱스
	        for(int i = 0; i < arr1.length; i++) {
	        	// arr2의 열인덱스
	        	for(int idx = 0; idx < arr2[0].length; idx++) {
	        		int calc = 0;
	        		// arr1과 arr2 곱셈
		        	for(int j = 0; j < arr1[i].length; j++) {
		        		calc += arr1[i][j] * arr2[j][idx];
		        	}
		        	answer[i][idx] = calc;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] arr1 = {
				{1,4},
				{3,2},
				{4,1},
				};
		int[][] arr2 = {
				{3,3},
				{3,3}
		};
		System.out.println(new Solution().solution(arr1, arr2));
	}
}
