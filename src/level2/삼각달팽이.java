/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 삼각달팽이 {
	static class Solution {
	    public int[] solution(int n) {
	    	int max = n*(n+1)/2;
	    	int map[][] = new int[n][n]; // 맵의 절반만 쓰자
	    	int top = 0; // 세로 인덱스
	    	int left = 0; // 가로 인덱스
	    	int tmp = 0;
	    	int idx = 1;
	    	
	    	/*
	    	 * 세로
	    	 * 가로
	    	 * 오른쪽 대각선
	    	 * 3부분으로 나누어 생각
	    	 * */
	    	while(idx != max+1) {
	    		// 세로
		    	for(; top < n - tmp; top++) {
		    		map[top][left] = idx++;
		    	}
		    	top--;
		    	left++;
		    	// 가로
		    	for(; left < n - tmp; left++) {
		    		if(map[top][left] != 0) break;
		    		map[top][left] = idx++;
		    	}
		    	top--;
		    	left -= 2;
		    	// 대각선
		    	for(; top > tmp && left > tmp; top--, left--) {
		    		map[top][left] = idx++;
		    	}
		    	top += 2;
		    	left++;
		    	tmp++;
	    	}
	    	
	        int[] answer = new int[max];
	        int index = 0;
	        for(int i = 0; i < n; i++) {
	        	for(int j = 0; j < n; j++) {
	        		if(map[i][j] == 0) continue;
	        		answer[index++] = map[i][j];
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 6;
		System.out.println(new Solution().solution(n));
	}
}
