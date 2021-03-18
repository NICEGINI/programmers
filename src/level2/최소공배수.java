/**
 * 
 */
package level2;

import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 최소공배수 {
	static class Solution {
	    public int solution(int[] arr) {
	    	PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((o1, o2) -> -o1.compareTo(o2));
	    	for(int i = 0; i < arr.length; i++) {
	    		pQueue.add(arr[i]);
	    	}
	    	
	    	while(pQueue.size() != 1) {
	    		int first = pQueue.poll();
	    		int second = pQueue.poll();
	    		pQueue.add(lcm(first, second));
	    	}
	    	
	    	int answer = pQueue.poll();
	        return answer;
	    }

		/** 최소 공배수 
		 * first가 큰 값, second가 작은 값 */
		private Integer lcm(int first, int second) {
			int gcd = gcd(first, second);
			return first * second / gcd;
		}

		/** 최대 공약수 */
		private int gcd(int first, int second) {
			if(first%second == 0)
				return second;
			return gcd(second, first % second);
		}
	}
	public static void main(String[] args) {
		int[] arr = {2, 6, 8, 14};
		System.out.println(new Solution().solution(arr));
	}
}
