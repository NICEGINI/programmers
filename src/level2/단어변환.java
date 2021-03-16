/**
 * 
 */
package level2;

public class 단어변환 {
	static class Solution {
		String[] alpha = {
    			"a", "b", "c", "d", "e", "f", "g",
    			"h", "i", "j", "k", "l", "m", "n",
    			"o", "p", "q", "r", "s" ,"t", "u",
    			"v", "w", "x", "y", "z"
    	};
		int minCnt;
		boolean selected[];
	    public int solution(String begin, String target, String[] words) {
	    	boolean canProcess = false;
	    	
	    	// 단어 모음에 목표 단어가 있는지 확인
	    	for(int i = 0; i < words.length; i++) {
	    		if(target.equals(words[i])) {
	    			canProcess = true;
	    			break;
	    		}
	    	}
	    	
	    	// 없으면 0
	    	if(!canProcess) return 0;
	    	
	    	// 어딘가에 있는 경우
	    	minCnt = Integer.MAX_VALUE;
	    	selected = new boolean[words.length];
	    	
	    	// 인덱스 , 카운트 , 처음, 목표, 배열
	    	dfs(0, 0, begin, target, words);
	    	
	        if(minCnt == Integer.MAX_VALUE) return 0;
	        return minCnt;
	    }
	    
		private void dfs(int idx, int cnt, String begin, String target, String[] words) {
			if(cnt >= minCnt) return ; // 카운트가 현재 최소값보다 작다면 더 볼 필요가 없다
			if(begin.equals(target)) { // 해당 단어를 찾은 경우
				if(cnt < minCnt) { // 최소값 갱신
					minCnt = cnt;
				}
				return ;
			}
			
			if(idx == words.length) { // 모든 words 배열을 순회 한 경우에는 변환 불가로 판단
				return ;
			}
			
			// StringBuffer를 이용해서 각각 위치의 문자 변경
			StringBuffer current = new StringBuffer(begin); 
			
			for(int i = 0; i < current.length(); i++) { // 현재 단어의 모든 위치 순회
				for(int j = 0; j < alpha.length; j++) {	// 전체 알파벳으로 변환
					current.replace(i, i+1, alpha[j]); // 현재 순회 위치의 문자를 모든 알파벳 변환
					for(int k = 0; k < words.length; k++) { // 변환하고 words 배열에 있는지 확인
						if(current.toString().equals(words[k])) { // 있다!
							if(selected[k]) continue; // 이미 선택한 단어라면 Pass
							selected[k] = true;
							dfs(idx+1, cnt+1, current.toString(), target, words);
							selected[k] = false;
						}
					}
				}
				current = new StringBuffer(begin);
			}
		}
	}
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {
				"hot", "dot", "dog", "lot", "log", "cog"
		};
		System.out.println(new Solution().solution(begin, target, words));
	}
}
