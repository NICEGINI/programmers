/**
 * 
 */
package KaKao_comerce;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author YSM
 *
 */
public class test3 {
	static class Solution {
		static class Vertex implements Comparable<Vertex>{
			int no, totalDistance; // 출발지에서 오는 최단거리.
			public Vertex(int no, int totalDistance) {
				this.no = no;
				this.totalDistance = totalDistance;
			}

			@Override
			public int compareTo(Vertex o) {
				return  o.totalDistance - this.totalDistance; // 최단거리가 작은 거 부터 정렬
			}
			
		}
	    public int[] solution(int n, int[] passenger, int[][] train) {
	    	final int INFINITY = Integer.MIN_VALUE;
	    	int V = passenger.length+1;
	    	int[] distance = new int[V];
	    	int[][] matrix = new int[V][V];
	    	boolean[] visited = new boolean[V];
	    	
	    	for(int i = 0; i < train.length; i++) {
    			matrix[train[i][1]][train[i][0]] = passenger[train[i][0]-1];
    			matrix[train[i][0]][train[i][1]] = passenger[train[i][1]-1];
	    	}
	    	
	    	PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
	    	
	    	int start = 1;
			int end = V-1;
	    	
	    	Arrays.fill(distance, INFINITY);
			distance[start] = passenger[0];
			pQueue.offer(new Vertex(start, distance[start]));
			
			Vertex current = null;
			int[] answer = new int[2];
			
			while(!pQueue.isEmpty()) {
				// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 가장 짧은 정점을 고려할 경유지 선택.
				current = pQueue.poll();
				
				visited[current.no] = true;
				if(current.no == end) break;
				
				// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용을 계산.
				// 유리하면 update
				for( int j = 1; j < V; j++) {
					if(!visited[j] && matrix[current.no][j] != 0 &&
							distance[j] < current.totalDistance + matrix[current.no][j]) {
						distance[j] = current.totalDistance + matrix[current.no][j];
						pQueue.offer(new Vertex(j, distance[j]));
						answer[0] = j;
						answer[1] = distance[j];
					}
				}
			}
			
			
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int n = 6;
		int[] passenger = {1, 1, 2, 3, 4};
		int[][] train = {{1,2},{1,3},{1,4},{1,5}};
		System.out.println(new Solution().solution(n, passenger, train));
	}
}
