/**
 * 
 */
package level2;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class 괄호변환 {
	static class Solution {
		int pos;
	    public String solution(String p) {
	    	if(p.equals("")) return p; // 빈 문자열 반환
	    	
	        return process(p); // 괄호 변환 시작
	    }
	    
		private String process(String p) {
			if(p.equals("")) return p; // 빈 문자열 반환
			// 현재 문자열이 올바른지 확인
			// pos위치를 찾아야한다
			boolean cur_correct = isCorrect(p); 
	    	
	    	String u = p.substring(0, pos);
	    	String v = p.substring(pos, p.length());
	    	
	    	if(cur_correct) return u + process(v);
	    	
	        String answer = "(" + process(v) + ")";
	        
	        for(int i = 1; i < u.length()-1; i++) {
	        	if(u.charAt(i) == '(') {
	        		answer += ")";
	        	} else {
	        		answer += "(";
	        	}
	        }
	        
			return answer;
		}

		private boolean isCorrect(String p) {
			boolean flag = true;
			int left = 0, right = 0;
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == '(') {
					left++;
					stack.push('(');
				} else {
					right++;
					if(stack.isEmpty()) {
						flag = false;
					} else {
						stack.pop();
					}
				}
				if(left == right) {
					pos = i + 1;
					return flag;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		String p = "()))((()";
		System.out.println(new Solution().solution(p));
	}
}
