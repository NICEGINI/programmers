/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 땅따먹기 {
	static class Solution {
	    int solution(int[][] land) {
	    	int MAXLENGTH = 4;
	        int[] save_sums = new int[MAXLENGTH]; // 누적합 저장
	        int[] tmp = new int[MAXLENGTH]; // 누적 합 변경 하기 전 원본 저장
	        int max = land.length-1;
	        
	        for(int j = 0; j < 4; j++) {
	        	save_sums[j] = land[max][j]; // 가장 밑에서 부터 시작
        	}
	        
	        for(int i = max-1; i >= 0; i--) {
	        	for(int j = 0; j < MAXLENGTH; j++) {
	        		tmp[j] = save_sums[j]; // 원본 저장
	        	}
	        	
	        	for(int j = 0; j < MAXLENGTH; j++) {
	        		int resMax = 0;
	        		for(int k = 0; k < MAXLENGTH; k++) {
	        			if(j == k) continue;
	        			int sum = tmp[k] + land[i][j];
	        			// 골랐을 때 최대 값 저장
	        			resMax = sum > resMax ? sum : resMax;
	        		}
	        		// 최대 값만 가지고 올라간다
	        		save_sums[j] = resMax;
	        	}
	        }
	        
	        int answer = 0;
	        // 누적하며 저장 한 값 중 가장 큰 값이 최대값
	        for(int i = 0; i < MAXLENGTH; i++) {
	        	answer = Math.max(answer, save_sums[i]);
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] land = {
				{1,2,3,5},
				{5,6,7,8},
				{4,3,2,1}};
		System.out.println(new Solution().solution(land));
	}
}
