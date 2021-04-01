/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 등굣길 {
	static class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	    	int[][] map = new int[n+1][m+1];
	    	map[0][1] = 1;
	    	
	    	int mod = 1000000007;
	    	
	    	for(int i = 0; i < puddles.length; i++) {
	    		int y = puddles[i][1];
	    		int x = puddles[i][0];
	    		map[y][x] = -1;
	    	}
	    	
	    	for(int i = 1; i <= n; i++) {
	    		for(int j = 1; j <= m; j++) {
	    			if(map[i][j] == -1) continue; // 현재 위치 웅덩이
	    			if(map[i-1][j] == -1) { // 위쪽이 물웅덩이
	    				if(map[i][j-1] != -1) { // 왼쪽 웅덩이 아닌 경우, 왼쪽 값만 더해줌
	    					map[i][j] = map[i][j-1]%mod;
	    				} // else는 둘 다 웅덩이 이므로 넘어감
	    			} else { // 위쪽이 웅덩이가 아님
	    				if(map[i][j-1] != -1) { // 왼쪽 웅덩이 아닌 경우, 둘 다 웅덩이가 아니므로 더해줌
	    					map[i][j] = map[i-1][j]%mod + map[i][j-1]%mod;
	    				} else { // 왼쪽이 웅덩이. 위쪽 값만 내림
	    					map[i][j] = map[i-1][j]%mod;
	    				}
	    			}
	    		}
	    	}
	    	
	        int answer = map[n][m]%mod;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int m = 4, n = 3;
		int[][] puddles = {{2,2}};
		System.out.println(new Solution().solution(m, n, puddles));
	}
}
