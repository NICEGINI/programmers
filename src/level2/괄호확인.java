/**
 * 
 */
package level2;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class 괄호확인 {
	static class Solution {
	    boolean solution(String s) {
	        boolean answer = true;

	        Stack<Character> stack = new Stack<Character>();
	        
	        for(int i = 0; i < s.length(); i++) {
	        	if(s.charAt(i) == '(') {
	        		stack.push('(');
	        	} else {
	        		if(!stack.isEmpty()) {
	        			stack.pop();
	        		} else return false;
	        	}
	        }
	        
	        if(!stack.isEmpty())
	        	answer = false;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String s = "((())";
		System.out.println(new Solution().solution(s));
	}
}
