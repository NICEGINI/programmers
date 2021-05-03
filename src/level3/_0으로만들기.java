/**
 * 
 */
package level3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class _0으로만들기 {
	static class Solution {
		static long ANSWER, ln_a[];
		static boolean[] visited;
		static List<Integer>[] edge_list;
	    public long solution(int[] a, int[][] edges) {
	    	int length = a.length;
	    	ln_a = new long[length];
	    	edge_list = new ArrayList[length];
	    	long sum = 0;
	    	
	    	for(int i = 0; i < length; i++) {
	    		edge_list[i] = new ArrayList<Integer>();
	    		sum += ln_a[i] = a[i];
	    	}
	    	
	    	if(sum != 0) return -1;
	    	
	    	for(int i = 0; i < edges.length; i++) {
	    		edge_list[edges[i][0]].add(edges[i][1]);
	    		edge_list[edges[i][1]].add(edges[i][0]);
	    	}
	    	
	    	visited = new boolean[length];
	    	visited[0] = true;
	    	dfs(0);
	    	
	        return ANSWER;
	    }
		
	    
		private long dfs(int vertex) {
			for(int i = 0; i < edge_list[vertex].size(); i++) {
				int next_vertex = edge_list[vertex].get(i);
				if(visited[next_vertex]) continue;
				visited[next_vertex] = true;
				ln_a[vertex] += dfs(next_vertex);
			}
			ANSWER += Math.abs(ln_a[vertex]);
			return ln_a[vertex];
		}
	}
	public static void main(String[] args) {
		int[] a = {-5, 0, 2, 1, 2};
		int[][] edges = {
				{0,1},{3,4},{2,3},{0,3}
		};
		System.out.println(new Solution().solution(a, edges));
	}
}
