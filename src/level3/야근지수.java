/**
 * 
 */
package level3;

import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 야근지수 {
	static class Solution {
		public long solution(int n, int[] works) {
			// 내림차순 정렬
			PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
			int length = works.length;
			for (int i = 0; i < length; i++) {
				pQueue.offer(works[i]);
			}
			
			// 최대값을 점점 줄여나감
			for (int i = 0; i < n; i++) {
				int max = pQueue.poll();
				if (max == 0) // 야근 없음!
					return 0;
				pQueue.offer(--max);
			}

			long answer = 0;
			int size = pQueue.size();
			// PQ에 저장된 값의 제곱들의 합이 정답
			for (int i = 0; i < size; i++) {
				int num = pQueue.poll();
				answer += Math.pow(num, 2);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[] works = { 4, 3, 3 };
		System.out.println(new Solution().solution(n, works));
	}
}
