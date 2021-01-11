/**
 * 
 */
package level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class 네트워크 {
	static class Solution {
	    public int solution(int n, int[][] computers) {
	    	boolean[] visited = new boolean[n];
	    	int answer = 0;
	    	
	    	for(int i = 0; i < n; i++) {
	    		boolean noNet = true;
	    		if(visited[i]) continue;
	    		visited[i] = true;
	    		for(int j = 0; j < n; j++) {
	    	    	if(computers[i][j] == 0) continue;
	    	    	if(visited[j]) continue;
	    	    	// Vertex가 어딘가에 연결이 되어 있는 경우 BFS로 순회하며 Vertex 체크
	    	    	Queue<Integer> queue = new LinkedList<Integer>();
	    	    	queue.offer(j);
	    	    	visited[j] = true;
	    	    	
	    	    	while(!queue.isEmpty()) {
	    	    		int startVertex = queue.poll();
	    	    		
	    	    		for(int des = 0; des < n; des++) {
	    	    			if(visited[des]) continue;
	    	    			if(computers[startVertex][des] == 1) {
	    	    				queue.offer(des);
	    	    				visited[des] = true;
	    	    			}
	    	    		}
	    	    	}
	    	    	noNet = false;
	    	    	answer++;
	    		}
	    		// Vertex가 어디에도 연결이 안 된 경우. 독자적 네트워크
	    		if(noNet) answer++;
	    	}
	    	
	    	
	        return answer;
	    }

	}
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {
				{1,1,0},
				{1,1,0},
				{0,0,1},
		};
		System.out.println(new Solution().solution(n, computers));
	}
}
