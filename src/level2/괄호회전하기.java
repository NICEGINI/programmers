/**
 * 
 */
package level2;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class 괄호회전하기 {
	static class Solution {
		public int solution(String s) {
			int length = s.length();
			int answer = 0;
			StringBuilder sb = new StringBuilder(s);
			for (int i = 0; i < length; i++) {
				boolean isPossible = true; // 가능한지 판단
				Stack<Character> stack = new Stack<Character>();
				char first_c = sb.charAt(0); // 가장 앞의 괄호
				// 닫는 괄호가 처음에 오면 어떤 경우도 불가능
				if(first_c == ']' || first_c == '}' || first_c == ')') {
					// 가장 앞자리 괄호를 뒤로 넘기고 다음으로
					char first = sb.charAt(0);
					sb.deleteCharAt(0);
					sb.append(first);
					continue;
				}
				// 여는 괄호라면 스택에 적재
				stack.push(first_c);
				// 2번째 괄호부터 조사
				for (int j = 1; j < length; j++) {
					char cur_c = sb.charAt(j);
					if (stack.isEmpty()) { // 스택이 빈 경우
						// 닫는 괄호가 처음이면 무조건 불가능
						if(cur_c == ']' || cur_c == '}' || cur_c == ')') {
							isPossible = false;
							break;
						}
						stack.push(cur_c);
						// 여는 괄호면 일단 적재
					} else if (cur_c == '[' || cur_c == '{' || cur_c == '(') {
						stack.push(cur_c);
					} else { // 빈 상태가 아닌데 닫는 괄호인 경우
						char pre_c = stack.peek();
						switch (pre_c) { // 짝 조사
						case '[':
							if (cur_c == ']')
								stack.pop();
							else
								isPossible = false;
							break;
						case '(':
							if (cur_c == ')')
								stack.pop();
							else
								isPossible = false;
							break;
						case '{':
							if (cur_c == '}')
								stack.pop();
							else
								isPossible = false;
							break;
						}
					}
					if (!isPossible)
						break;
				}
				// 현재 스택에 괄호가 없는 상태에만 가능
				if (isPossible && stack.isEmpty())
					answer++;
				// 가장 앞자리 뒤로 넘김
				char first = sb.charAt(0);
				sb.deleteCharAt(0);
				sb.append(first);
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		String s = "{{{{{{{";
		System.out.println(new Solution().solution(s));
	}
}
