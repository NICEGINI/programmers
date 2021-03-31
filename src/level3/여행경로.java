/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 여행경로 {
	static class Solution {
	    public String[] solution(String[][] tickets) {
	    	StringBuilder sb = new StringBuilder();
	    	int size = tickets.length;
	    	boolean selected[] = new boolean[size];
	    	
	    	dfs(sb, tickets, tickets[0][0], tickets[0][1], 0, size, selected);
	    	
	        String[] answer = {};
	        return answer;
	    }

		private void dfs(StringBuilder sb, String[][] tickets, String from, String to, int idx, int size, boolean[] selected) {
			for(int i = 0; i < size; i++) {
				if(selected[i]) continue;
				
			}
		}
	}
	public static void main(String[] args) {
		String[][] tickets = {
				{"ICN", "SFO"}, 
				{"ICN", "ATL"},
				{"SFO", "ATL"}, 
				{"ATL", "ICN"}, 
				{"ATL","SFO"}
				};
		
		System.out.println(new Solution().solution(tickets));
	}
}
