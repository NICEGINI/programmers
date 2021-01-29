package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 튜플_list{
	static class Solution {
		public int[] solution(String s) {
			s = s.substring(1, s.length() - 1);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '{') continue;
				if (c == ',') {
					sb.append(':');
					continue;
				}
				if (c == '}') {
					sb.append(',');
					i++;
					continue;
				}
				sb.append(c);
			}

			String[] elements = sb.substring(0, sb.length() - 1).toString().split(",");

			Arrays.sort(elements, ((s1, s2) -> {
				return s1.toString().length() - s2.toString().length();
			}));

			List<Integer> list = new ArrayList<Integer>();

			for(String nums : elements) {
				sb = new StringBuilder();
				for(int i = 0; i < nums.length(); i++) {
					if(nums.charAt(i) == ':') {
						int next_num = Integer.parseInt(sb.toString());
						if(!list.contains(next_num)) {
							list.add(next_num);
						}
						sb = new StringBuilder();
						continue;
					}
					sb.append(nums.charAt(i));
				}
				int next_num = Integer.parseInt(sb.toString());
				if(!list.contains(next_num)) {
					list.add(next_num);
				}
			}

			int[] answer = new int[list.size()];
			int idx = 0;
			for(int num : list) {
				answer[idx++] = num;
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(new Solution().solution(s));
	}
}