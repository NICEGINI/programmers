/**
 * 
 */
package level3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 섬연결하기 {
	static class Solution {
	    static class Island {
	    	int from, to, weight;

			public Island(int from, int to, int weight) {
				this.from = from; // 출발지
				this.to = to; // 목적지
				this.weight = weight; // 가중치
			}
	    }
		public int solution(int n, int[][] costs) {
			PriorityQueue<Island> pQueue = new PriorityQueue<Island>(new Comparator<Island>() {
				@Override
				public int compare(Island o1, Island o2) {
					return Integer.compare(o1.weight, o2.weight);
				}
			});
			
			for(int i = 0; i < costs.length; i++) {
				  pQueue.offer(new Island(costs[i][0],costs[i][1],costs[i][2]));
			}
			
			int parent[] = new int[n+1];
			make(parent, n); // 서로소 만들기
			
			int answer = 0;
			int cnt = 0;
			while(!pQueue.isEmpty()) {
				Island curIsland = pQueue.poll();
				if(union(parent, curIsland.from, curIsland.to)) {
					answer += curIsland.weight;
					if(++cnt == n+1) break;
				}
				
			}
	       
	        return answer;
	    }
		
		/** 합집합 만들기 */
		private boolean union(int[] parent, int first, int sec) {
			int aroot = find(parent, first);
			int broot = find(parent, sec);
			
			if(aroot == broot) return false;
			parent[broot] = aroot;
			return true;
		}

		/** 자신이 속한 집합 찾기 */
		private int find(int[] parent, int num) {
			if(parent[num] == num) return num;
			return parent[num] = find(parent, parent[num]);
		}

		/** 서로소 만들기 */
		private void make(int[] parent, int n) {
			for(int i = 1; i < n; i++) {
				parent[i] = i;
			}
		}
	}
	public static void main(String[] args) {
		int n = 5;  
		int costs[][] = {
				{0,1,1},
				{0,2,2},
				{1,2,5},
				{1,3,3},
				{2,3,8},
				{3,4,1},
		};
		System.out.println(new Solution().solution(n, costs));
	}
}
