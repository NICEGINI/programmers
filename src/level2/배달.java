/**
 * 
 */
package level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {
	static class Solution {
		static class Vertex implements Comparable<Vertex> {
			int no, totalDistance; // 출발지에서 오는 최단거리.

			public Vertex(int no, int totalDistance) {
				this.no = no;
				this.totalDistance = totalDistance;
			}

			@Override
			public int compareTo(Vertex o) {
				return this.totalDistance - o.totalDistance; // 최단거리가 작은 거 부터 정렬
			}

		}

		public int solution(int N, int[][] road, int K) {
			int answer = dijkstra(road, N, K);
			return answer;
		}

		/** */
		private int dijkstra(int[][] road, int N, int K) {
			int[][] matrix = new int[N + 1][N + 1];
			for (int i = 0; i < road.length; i++) { // 정점에 연결된 가중치의 최소를 저장
				if (matrix[road[i][0]][road[i][1]] == 0) {
					matrix[road[i][0]][road[i][1]] = road[i][2];
					matrix[road[i][1]][road[i][0]] = road[i][2];
				} else {
					if (matrix[road[i][0]][road[i][1]] > road[i][2]) {
						matrix[road[i][0]][road[i][1]] = road[i][2];
						matrix[road[i][1]][road[i][0]] = road[i][2];
					}
				}
			}

			int start = 1;
			int end = N;
			final int INFINITY = Integer.MAX_VALUE;

			int[] distance = new int[N + 1];
			boolean[] visited = new boolean[N + 1];

			PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

			Arrays.fill(distance, INFINITY);
			distance[start] = 0;
			pQueue.offer(new Vertex(start, distance[start]));

			Vertex current = null;

			while (!pQueue.isEmpty()) {
				// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 가장 짧은 정점을 고려할 경우지 선택.
				current = pQueue.poll();

				visited[current.no] = true;
				// if(current.no == end) break;

				// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용을 계산.
				// 유리하면 update
				for (int j = 1; j <= N; j++) {
					if (!visited[j] && matrix[current.no][j] != 0
							&& distance[j] > current.totalDistance + matrix[current.no][j]) {
						distance[j] = current.totalDistance + matrix[current.no][j];
						pQueue.offer(new Vertex(j, distance[j]));
					}
				}
			} // 다익스트라 end

			int res = 0;

			// K이하의 거리 갯수
			for (int i = 1; i <= N; i++) {
				if (distance[i] <= K)
					res++;
			}
			return res;
		}
	}

	public static void main(String[] args) {
		int N = 6;
		int[][] road = {
//				{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
				{ 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
		int K = 4;
		System.out.println(new Solution().solution(N, road, K));
	}
}
