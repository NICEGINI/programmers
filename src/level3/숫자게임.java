/**
 * 
 */
package level3;

import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 숫자게임 {
	static class Solution {
		public int solution(int[] A, int[] B) {
			PriorityQueue<Integer> A_pQueue = new PriorityQueue<Integer>();
			PriorityQueue<Integer> B_pQueue = new PriorityQueue<Integer>();

			int length = A.length;
			for (int i = 0; i < length; i++) {
				// 전체 오름차순 Heap 정렬
				A_pQueue.offer(A[i]);
				B_pQueue.offer(B[i]);
			}

			int answer = 0;
			// A 혹은 B의 큐가 다 빌 때까지
			while (!A_pQueue.isEmpty() && !B_pQueue.isEmpty()) {
				// A와 B의 숫자 판단
				int a = A_pQueue.peek();
				int b = B_pQueue.peek();

				if (b > a) { // B가 A보다 큰 경우만 둘 다 뺀다
					A_pQueue.poll();
					B_pQueue.poll();
					answer++;
				} else if (b <= a) {
					// B가 같거나 작은경우 승점을 얻지못함. B만 뺀다
					// B만 빼야 A보다 큰 수가 있는지 판단 가능
					B_pQueue.poll();
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		int[] A = { 5, 1, 3, 7 };
		int[] B = { 2, 2, 6, 8 };
		System.out.println(new Solution().solution(A, B));
	}
}
