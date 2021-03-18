/**
 * 
 */
package level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class 개임맵최단거리 {
	static class Solution {
		class Player{
			int y, x, cnt;

			public Player(int y, int x, int cnt) {
				this.y = y;
				this.x = x;
				this.cnt = cnt;
			}
		}
	    public int solution(int[][] maps) {
	    	int n = maps.length;
	    	int m = maps[0].length;
	    	boolean[][] visited = new boolean[n][m];
	    	int[] dy = {-1, 1, 0, 0};
			int[] dx = {0, 0, -1, 1};
			
	    	Queue<Player> queue = new LinkedList<Player>();
	    	queue.offer(new Player(0,0,1));
	    	visited[0][0] = true;
	    	
	    	int answer = 0;
	    	
	    	while(!queue.isEmpty()) {
	    		Player player = queue.poll();
	    		
	    		int cur_x = player.x;
	    		int cur_y = player.y;
	    		
	    		if(cur_x == m-1 && cur_y == n-1) answer = player.cnt;
	    		
	    		for(int d = 0; d < 4; d++) {
	    			int next_x = cur_x + dx[d];
	    			int next_y = cur_y + dy[d];
	    			
	    			if(rangeCheck(next_x, next_y, n, m)) continue;
	    			if(maps[next_y][next_x] == 0) continue;
	    			if(visited[next_y][next_x]) continue;
	    			
	    			visited[next_y][next_x] = true;
	    			queue.offer(new Player(next_y, next_x, player.cnt+1));
	    		}
	    	}
	    	
	    	if(answer == 0) return -1;
	        return answer;
	    }
	    
	    // 범위 체크
		private boolean rangeCheck(int next_x, int next_y, int n, int m) {
			return next_x >= m || next_x < 0 || next_y >= n || next_y < 0;
		}
	}
	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		
		System.out.println(new Solution().solution(maps));
	}
}
