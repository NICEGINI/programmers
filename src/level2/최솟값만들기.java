/**
 * 
 */
package level2;

import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 최솟값만들기 {
	static class Solution {
		public int solution(int[] A, int[] B) {
			PriorityQueue<Integer> a_pQueue = new PriorityQueue<Integer>();
			PriorityQueue<Integer> b_pQueue = new PriorityQueue<Integer>((o1, o2) -> -o1.compareTo(o2));
			
			for(int i = 0; i < A.length; i++) {
				a_pQueue.offer(A[i]);
				b_pQueue.offer(B[i]);
			}
			
			int answer = 0;
			
			while(!a_pQueue.isEmpty()) {
				int a = a_pQueue.poll();
				int b = b_pQueue.poll();
				answer += a*b;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };
		System.out.println(new Solution().solution(A, B));
	}
}
