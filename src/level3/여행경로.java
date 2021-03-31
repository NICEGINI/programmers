/**
 * 
 */
package level3;

import java.util.Arrays;

/**
 * @author YSM
 *
 */
public class 여행경로 {
	static class Solution {
		private static StringBuilder resMin;
	    public String[] solution(String[][] tickets) {
	    	int size = tickets.length;
	    	
	    	// 도착지 기준으로 정렬.
	    	Arrays.sort(tickets, (o1, o2)-> o1[1].compareTo(o2[1]));
	    	resMin = new StringBuilder("ZZZ");
	    	
	    	for(int i = 0; i < size; i++) {
	    		boolean[] selected = new boolean[size]; // 방문체크
	    		
	    		if(tickets[i][0].equals("ICN")) {
	    			// 모든 ICN 출발지 검사
	    			StringBuilder sb = new StringBuilder("ICN,");
	    			selected[i] = true;
	    			dfs(sb, tickets, tickets[i][1], 1, size, selected, i);
	    			selected[i] = false;
	    		}
	    	}
	    	
	        String[] answer = resMin.toString().split(",");
	        return answer;
	    }
	    
	    /*
	     * DFS - 깊이 우선 탐색
	     * 정렬을 한 채로 탐색을 하기 때문에 가장 먼저 만들어진 문자열이 최소.
	     * StringBuilder를 이용해서 문자열을 만들면서 진행
	     * selected를 이용해서 방문 체크
	     * */
		private boolean dfs(StringBuilder sb, String[][] tickets, String to, int idx, int size, boolean[] selected, int lock) {
			// 가지치기. 현재 사전순으로 가장 작은 문자열과 비교. 크면 진행 X
			if(sb.toString().compareTo(resMin.toString()) > 0) {
				return false;
			} 
			if(idx == size) { // 기저 조건
				for(int i = 0; i < size; i++) {
					if(!selected[i]) {
						return false;
					}
				}
				sb.append(to);
				resMin = new StringBuilder(sb);
				return true;
			}
			for(int i = 0; i < size; i++) { // 탐색 조건
				if(tickets[i][0].equals(to)) {
					StringBuilder next_sb = new StringBuilder(sb);
					next_sb.append(tickets[i][0]+",");
					boolean flag = false;
					if(selected[i]) flag = true; // 방문하기 전에 이미 방문 한 적이 있는 경우
					selected[i] = true;
					if(dfs(next_sb, tickets, tickets[i][1], idx+1, size, selected, lock)) {
						return true;
					}
					if(!flag) selected[i] = false; // 방문 해제 하면 안된다.
					selected[lock] = true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		String[][] tickets = {
//				{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//				{"ICN", "SFO"}, 
//				{"ICN", "ATL"},
//				{"SFO", "ATL"}, 
//				{"ATL", "ICN"}, 
//				{"ATL", "SFO"}
//				{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}
				{"ICN","BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"}
				};
		
		System.out.println(new Solution().solution(tickets));
	}
}
