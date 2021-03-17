/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class 가장먼논드 {
	static class Solution {
	    public int solution(int n, int[][] edge) {
	    	boolean[] visited = new boolean[n+1];
	    	
	    	Arrays.sort(edge, (o1, o2) -> o1[0] - o2[0]);
	    	
	    	List<Integer>list[] = new ArrayList[n+1];
	    	
	    	for(int i = 1; i < list.length; i++) {
	    		list[i] = new ArrayList<Integer>();
	    	}
	    	
	    	for(int i = 0; i < edge.length; i++) {
    			list[edge[i][0]].add(edge[i][1]);
    			list[edge[i][1]].add(edge[i][0]);
	    	}
	    	
	    	Queue<int[]> queue = new LinkedList<>();
	    	
	    	queue.add(new int[] {1, 1});
	    	visited[1] = true;
	    	
	    	int max = Integer.MIN_VALUE;
	    	int cnt = 0;
	    	while(!queue.isEmpty()) {
	    		int[] vertex_info = queue.poll();
	    		int vertex = vertex_info[0];
	    		int vertex_cnt = vertex_info[1];
	    		
	    		if(max < vertex_cnt) {
	    			max = vertex_cnt;
	    			cnt = 1;
	    		} 
	    		else if(max == vertex_cnt) {
	    			cnt++;
	    		}
	    		
	    		for(int i = 0; i < list[vertex].size(); i++) {
	    			int next_vertex = list[vertex].get(i);
	    			if(visited[next_vertex]) continue;
	    			visited[next_vertex] = true;
	    			queue.offer(new int[] {next_vertex, vertex_cnt+1});
	    		}
	    	}
	    	
	        int answer = cnt;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {
				{4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		System.out.println(new Solution().solution(n, edge));
	}
}
