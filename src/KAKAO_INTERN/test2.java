/**
 * 
 */
package KAKAO_INTERN;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class test2 {
	static class Solution {
		public int[] solution(String[][] places) {
			int[] answer = new int[5]; // 총 5개의 대기실

			for (int i = 0; i < 5; i++) { // 전체 모든 대기실 체크
				int idx = 0;
				char[][] map = new char[5][5]; // 5x5의 대기실
				for (int j = 0; j < 5; j++) { // 맵 복사
					String line = places[i][j];
					map[idx++] = line.toCharArray();
				}
				boolean flag = true; // 거리두기 성공 여부 판단
				for (int j = 0; j < 5; j++) {
					if(!flag) break;
					for (int k = 0; k < 5; k++) {
						if (map[j][k] == 'P') { // 사람이 있는 경우
							if(bfs(map, j, k)) { // 해당 위치에서 맨해튼 거리만큼 BFS
								flag = true;
							} else {
								flag = false;
								break;
							}
						}
					} // map k
				} // map j
				if(flag) answer[i] = 1;
				else answer[i] = 0;
			} // 전체 대기실 체크 end
			return answer;
		}

		private boolean bfs(char[][] map, int j, int k) {
			// 상 하 좌 우
			int[] dy = { -1, 1, 0, 0 };
			int[] dx = { 0, 0, -1, 1 };
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] { j, k, 0 }); // 현재 위치 저장
			boolean[][] visited = new boolean[5][5];
			visited[j][k] = true;
			
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				int y = cur[0];
				int x = cur[1];
				int dist = cur[2];

				if ( dist != 0 && dist <= 2) { // 거리가 2보다 작은데
					if (map[y][x] == 'P') { // 사람이 있어
						return false;
					}
				}
				
				// 거리 2이면 다음 위치 체크
				if(dist == 2) continue;

				for (int d = 0; d < 4; d++) {
					int next_y = y + dy[d];
					int next_x = x + dx[d];

					// 범위 체크, 방문 체크, 파티션체크
					if (isOutRange(next_y, next_x) || visited[next_y][next_x] || map[next_y][next_x] == 'X')
						continue;
					queue.offer(new int[] { next_y, next_x, dist + 1 });
					visited[next_y][next_x] = true;
				}
			}
			return true;
		}

		/** 범위 체크 */
		private boolean isOutRange(int next_y, int next_x) {
			return next_y < 0 || next_y >= 5 || next_x < 0 || next_x >= 5;
		}
	}

	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(new Solution().solution(places));
	}
}
