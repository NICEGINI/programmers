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
	    	
	    	for(int i = size-1; i >= 0; i--) { // 전체 배열의 높이
	    		for(int j = 0; j < triangle[i].length-1;j++) { // 현재 층의 배열의 개수만큼
	    			// 크기 비교
	    			int max = triangle[i][j] > triangle[i][j+1] ? triangle[i][j] : triangle[i][j+1];
	    			if(i-1 < 0) break; // 꼭대기 넘어가면 멈춰!!
	    			triangle[i-1][j] += max; // 값 갱신
	    		}
	    	}
	    	int answer = triangle[0][0]; // 꼭대기가 정답
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(new Solution().solution(triangle));
	}
}
