/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 순위 {
	static class Solution {
	    public int solution(int n, int[][] results) {
	    	int[][] map = new int[n+1][n+1];
	    	int INF = 10000;
	    	for(int i = 1; i <= n; i++) {
	    		for(int j = 1; j <= n; j++) {
	    			map[i][j] = INF; // 큰 값으로 초기화
	    		}
	    	}
	    	for(int i = 0; i < results.length; i++) {
	    		for(int j = 0; j < results[i].length-1; j++) {
	    			map[results[i][j]][results[i][j+1]] = 1; // 승, 연결
	    		}
	    	}
	    	for(int k = 1; k <= n; k++) {
	    		for(int i = 1; i <= n; i++) {
	    			for(int j = 1; j <= n; j++) {
	    				// 플로이드 워셜 알고리즘.
	    				// 자기 자신과, 경유지를 거쳐서 가는 것 중 더 작은 경우로 갱신
	    				map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
	    			}
	    		}
	    	}
	        int answer = 0;
	        for(int i = 1; i <= n; i++) {
	        	boolean unknown = false;
	        	for(int j = 1; j <= n; j++) {
	        		if(i == j) continue;
	        		// 내가 이겼는지 졌는지 확실히 알 수 있는 경우만 체크
	        		if(map[i][j] == INF && map[j][i] == INF) {
	        			unknown = true;
	        			break;
	        		}
	        	}
	        	if(!unknown) answer++;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(new Solution().solution(n, results));
	}
}
