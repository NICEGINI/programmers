/**
 * 
 */
package level2;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class 짝지어제거하기2 {
	static class Solution {
		public int solution(String s) {
			Stack<Character> stack = new Stack<Character>();
			for(char c : s.toCharArray()) {
				if(stack.isEmpty()) {
					stack.push(c);
				} else {
					char pre = stack.peek();
					if(pre == c) {
						stack.pop();
					} else {
						stack.push(c);
					}
				}
			}
			int answer = stack.size() == 0 ? 1 : 0;
			return answer;
		}
	}

	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(new Solution().solution(s));
	}
}
