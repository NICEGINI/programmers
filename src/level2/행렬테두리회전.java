package level2;

public class 행렬테두리회전 {
	static class Solution {
		public int[] solution(int rows, int columns, int[][] queries) {
			int[][] map = new int[rows+1][columns+1];
			
			int num = 1;
			for(int i = 1; i <= rows; i++) {
				for(int j = 1; j <= columns; j++) {
					map[i][j] = num++;
				}
			}
			
			int rotate_cnt = queries.length;
			int[] answer = new int[rotate_cnt];
			int idx = 0;
			for(int[] query : queries) {
				int y1 = query[0];
				int x1 = query[1];
				int y2 = query[2];
				int x2 = query[3];
				
				int pre = map[y1][x1];
				int min = pre;
				// 위쪽
				for(int i = x1+1; i <= x2; i++) {
					int cur = map[y1][i];
					min = min < cur ? min : cur;
					map[y1][i] = pre;
					pre = cur;
				}
				
				// 오른쪽 아래
				for(int i = y1+1; i <= y2; i++) {
					int cur = map[i][x2];
					min = min < cur ? min : cur;
					map[i][x2] = pre;
					pre = cur;
				}
				
				// 아래쪽
				for(int i = x2-1; i >= x1; i--) {
					int cur = map[y2][i];
					min = min < cur ? min : cur;
					map[y2][i] = pre;
					pre = cur;
				}
				
				// 왼쪽 위
				for(int i = y2-1; i >= y1; i--) {
					int cur = map[i][x1];
					min = min < cur ? min : cur;
					map[i][x1] = pre;
					pre = cur;
				}
				answer[idx++] = min;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int rows = 6, columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		System.out.println(new Solution().solution(rows, columns, queries));
	}
}
