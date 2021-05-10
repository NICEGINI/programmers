/**
 * 
 */
package KAKAO_INTERN;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class test3 {
	static class Solution {
		public String solution(int n, int k, String[] cmd) {
			Stack<Integer> stack = new Stack<Integer>();
			int idx = k;
			int length = n;
			for (int i = 0; i < cmd.length; i++) {
				String[] command = cmd[i].split(" ");
				switch (command[0]) {
				case "U":
					idx -= Integer.parseInt(command[1]);
					break;
				case "D":
					idx += Integer.parseInt(command[1]);
					break;
				case "C":
					stack.push(idx);
					length--;
					idx = idx >= length ? idx - 1 : idx;
					break;
				case "Z":
					int pos = stack.pop();
					if (pos <= idx)
						idx++;
					length++;
					break;
				}
			}

			StringBuilder answer = new StringBuilder();
			for (int i = 0; i < length; i++) {
				answer.append("O");
			}

			while (!stack.isEmpty()) {
				int pos = stack.pop();
				answer.insert(pos, "X");
			}

			return answer.toString();
		}
	}

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
		System.out.println(new Solution().solution(n, k, cmd));
	}
}
