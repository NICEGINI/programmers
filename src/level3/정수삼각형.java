/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 정수삼각형 {
	static class Solution {
	    public int solution(int[][] triangle) {
	    	int size = triangle.length;
	    	
	    	for(int i = size-1; i >= 0; i--) {
	    		for(int j = 0; j < triangle[i].length-1;j++) {
	    			int max = triangle[i][j] > triangle[i][j+1] ? triangle[i][j] : triangle[i][j+1];
	    			if(i-1 < 0) break;
	    			triangle[i-1][j] += max;
	    		}
	    	}
	    	int answer = triangle[0][0];
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(new Solution().solution(triangle));
	}
}
