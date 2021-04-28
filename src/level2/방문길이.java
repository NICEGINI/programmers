/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 방문길이 {
	static class Solution {
	    public int solution(String dirs) {
	    	boolean[][][][] visited = new boolean[11][11][11][11];
	    	int[] dy = {-1, 1, 0, 0};
	    	int[] dx = {0, 0, -1, 1};
	    	
	    	int y = 5; // 현재위치
	    	int x = 5;
	    	int next_y = y; // 다음 위치
	    	int next_x = x;
	    	int answer = 0;
	    	
	    	for(int i = 0; i < dirs.length(); i++) {
	    		char dir = dirs.charAt(i);
	    		y = next_y;
	    		x = next_x;
	    		
	    		int direction = 0;
	    		
	    		switch(dir) {
	    		case 'U':
	    			direction = 0;
	    			break;
	    		case 'D':
	    			direction = 1;
	    			break;
	    		case 'L':
	    			direction = 2;
	    			break;
	    		case 'R':
	    			direction = 3;
	    			break;
	    		}
	    		
	    		next_y += dy[direction];
	    		next_x += dx[direction];
	    		
	    		if(next_y < 0 || next_y >= 11 ||
	    		   next_x < 0 || next_x >= 11) {
	    			next_y -= dy[direction];
	    			next_x -= dx[direction];
	    			continue;
	    		}
	    		
	    		if(!visited[y][x][next_y][next_x] && 
	    		   !visited[next_y][next_x][y][x]) {
	    			visited[next_y][next_x][y][x] = true;
		    		visited[y][x][next_y][next_x] = true;
	    			answer++;
	    		}
	    	}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		System.out.println(new Solution().solution(dirs));
	}
}
