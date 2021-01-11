/**
 * 
 */
package level3;

import java.util.HashSet;

/**
 * @author YSM
 *
 */
public class 불량사용자 {
	static class Solution {
		private static HashSet<String> ban_user_idx;
	    public int solution(String[] user_id, String[] banned_id) {
	    	boolean visited[] = new boolean[user_id.length];
	    	ban_user_idx = new HashSet<String>();
	    	dfs(user_id, banned_id, 0, visited);
	        int answer = ban_user_idx.size();
	        return answer;
	    }

		private void dfs(String[] user_id, String[] banned_id, int ban_idx, boolean[] visited) {
			if(ban_idx == banned_id.length) {
				StringBuilder user_idxs = new StringBuilder();
				for(int i = 0; i < user_id.length; i++) {
					if(visited[i]) {
						user_idxs.append(i);
					}
				}
				ban_user_idx.add(user_idxs.toString());
				return ;
			}
			for(int i = 0; i < user_id.length; i++) {
				if(visited[i]) continue;
				boolean flag = false;
				if(user_id[i].length() == banned_id[ban_idx].length()) {
					for(int s = 0; s < user_id[i].length(); s++) {
						if(banned_id[ban_idx].charAt(s) == '*') continue;
						if(user_id[i].charAt(s) != banned_id[ban_idx].charAt(s)) {
							flag = true;
							break;
						}
					}
					if(!flag) {
						visited[i] = true;
						dfs(user_id, banned_id, ban_idx+1, visited);
						visited[i] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(new Solution().solution(user_id, banned_id));
	}
}
