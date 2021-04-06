/**
 * 
 */
package KaKao_comerce;

/**
 * @author YSM
 *
 */
public class test2 {
	static class Solution {
		private static int resMax;
	    public int solution(int[][] needs, int r) {
	    	int answer = 0;
	    	
    		resMax = Integer.MIN_VALUE;
    		// 바뀐 비트와 최대 r개의 비트를 선택해서 최대한 많이 만들 수 있는 로봇 계산
    		int[] bit = new int[needs.length];
    		dfs(0, 0, bit, needs, needs[0].length, r);
    		answer = resMax;
	    	
	        return answer;
	    }
	    
		private void dfs(int idx, int cnt, int[] bit, int[][] needs, int size, int r) {
			if(cnt == r) {
				int[][] tmp = new int[needs.length][needs[0].length];
				for(int i = 0; i < needs.length; i++) {
					for(int j = 0; j < needs[0].length; j++) {
						tmp[i][j] = needs[i][j];
					}
				}
				int res = calc(bit, tmp);
				resMax = res > resMax ? res : resMax;
				return;
			}
			
			// 비트를 어떻게 넘기지..
			for(int i = idx; i < size; i++) {
				bit[i] = 1;
				dfs(i+1, cnt+1, bit, needs, size, r);
				bit[i] = 0;
			}
		}

		private int calc(int[] bit, int[][] needs) {
			int cnt = 0;
			for(int i = 0; i < bit.length; i++) {
				if(bit[i] == 1) {
					for(int j = 0; j < needs.length; j++) {
						needs[j][i] = 0;
					}
				}
			}
			for(int i = 0; i < needs.length; i++) {
				boolean flag = true;
				for(int j = 0; j < needs[i].length; j++) {
					if(needs[i][j] != 0) flag = false;
				}
				if(flag) cnt++;
			}
			return cnt;
		}
	}
	public static void main(String[] args) {
		int[][] needs = {
			{1, 0, 0}, 
			{1, 1, 0}, 
			{1, 1, 0}, 
			{1, 0, 1}, 
			{1, 1, 0}, 
			{0, 1, 1}
		};
		int r = 2;
		System.out.println(new Solution().solution(needs, r));
	}
}
