/**
 * 
 */
package KAKAO_INTERN;

/**
 * @author YSM
 *
 */
public class test4 {
	static class Solution {
		static int MIN;

		public int solution(int n, int start, int end, int[][] roads, int[] traps) {
			if (start == end)
				return 0;
			int[][] weight_roads = new int[n + 1][n + 1];
			for (int i = 0; i < roads.length; i++) {
				int v1 = roads[i][0];
				int v2 = roads[i][1];
				int weight = roads[i][2];
				weight_roads[v1][v2] = weight;
			}

			MIN = Integer.MAX_VALUE;
			boolean[] visited = new boolean[n+1];
			dfs(0, start, n, end, weight_roads, traps, visited, 0);

			int answer = MIN;
			return answer;
		}

		private void dfs(int weight, int start, int n, int end, int[][] roads, int[] traps, boolean[] visited, int pre) {
			if (weight > MIN)
				return;
			if (start == end) { // 도착함!
				MIN = MIN < weight ? MIN : weight;
				return;
			}
			for (int j = 1; j <= n; j++) { // 전체 정점 모두 확인
				if (start == j || j == pre)
					continue;
				if (roads[start][j] != 0) { // 연결 되어 있는 정점만
					int[][] tmp_roads = new int[n + 1][n + 1];
					copy_roads(tmp_roads, roads, n); // 맵 복사
					for (int t = 0; t < traps.length; t++) {
						if (j == traps[t]) { // 함정 정점
							for (int i = 1; i <= n; i++) { // 함정 정점과 연결된 모든 정점 방향 전환
								if (i == j)
									continue;
								if (tmp_roads[i][j] != 0) { // 도착지가 함정인 모든 정점
									int tmp_weight = tmp_roads[i][j];
									tmp_roads[i][j] = 0;
									tmp_roads[j][i] = tmp_weight;
								} else if (tmp_roads[j][i] != 0) { // 출발지가 함정인 모든 정점
									int tmp_weight = tmp_roads[j][i];
									tmp_roads[j][i] = 0;
									tmp_roads[i][j] = tmp_weight;
								}
							}
						}
					} // 함정 정점 가리기 end
					dfs(weight + roads[start][j], j, n, end, tmp_roads, traps, visited, start);
				} // 연결 확인 end
			} // 전체 순회 end
		} // dfs end

		// 맵 복사
		private void copy_roads(int[][] tmp_roads, int[][] roads, int n) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					tmp_roads[i][j] = roads[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int start = 1;
		int end = 4;
		int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } };
		int[] traps = { 2, 3 };
		System.out.println(new Solution().solution(n, start, end, roads, traps));
	}
}
