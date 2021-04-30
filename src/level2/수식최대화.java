/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 수식최대화 {
	static class Solution {
		private static long MAX;

		public long solution(String expression) {
			List<Character> op_list = new ArrayList<>();
			List<Long> operand_list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if(c == '+' || c == '-' || c == '*') {
					op_list.add(c);
					operand_list.add(Long.parseLong(sb.toString()));
					sb = new StringBuilder();
				} else {
					sb.append(c);
				}
			}
			operand_list.add(Long.parseLong(sb.toString()));
			
			boolean[] selected = new boolean[3];
			int[] sel_idx = new int[3];
			permutation(0, 3, expression, op_list, operand_list, selected, sel_idx);
			
			long answer = MAX;
			return answer;
		}

		private void permutation(int idx, int opCnt, String expression, List<Character> op_list, List<Long> operand_list, boolean[] selected, int[] sel_idx) {
			if(idx == opCnt) {
				long res = calc(expression, op_list, operand_list, sel_idx);
				MAX = MAX > res ? MAX : res;
				return;
			}
			for(int i = 0; i < 3; i++) {
				if(selected[i]) continue;
				selected[i] = true;
				sel_idx[idx] = i;
				permutation(idx+1, opCnt, expression, op_list, operand_list, selected, sel_idx);
				selected[i] = false;
			}
		}

		private long calc(String expression, List<Character> op_list, List<Long> operand_list, int[] order) {
			char[] ops = {'+', '-', '*'};
			List<Character> tmp_op_list = new ArrayList<>(op_list);
			List<Long> tmp_operand_list = new ArrayList<>(operand_list);
			
			for(int i = 0; i < 3; i++) {
				char cur_op = ops[order[i]];
				
				for(int j = 0; j < tmp_op_list.size(); j++) {
					if(tmp_op_list.get(j).equals(cur_op)) {
						long num1 = tmp_operand_list.get(j);
						long num2 = tmp_operand_list.get(j+1);
						long res = start_calc(num1, num2, cur_op);
						
						tmp_op_list.remove(j);
						tmp_operand_list.remove(j+1);
						tmp_operand_list.remove(j);
						tmp_operand_list.add(j, res);
						j--;
					}
				}
			}
			return Math.abs(tmp_operand_list.get(0));
		}

		private long start_calc(long num1, long num2, char cur_op) {
			switch(cur_op) {
			case '+':
				return num1+num2;
			case '-':
				return num1-num2;
			case '*':
				return num1*num2;
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(new Solution().solution(expression));
	}
}
