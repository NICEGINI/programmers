/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 가장_긴_팰린드롬 {
	static class Solution {
		public int solution(String s) {
			int size = s.length();
			int max_length = Integer.MIN_VALUE; // 가장 긴 팰린드롬 저장

			for (int i = 0; i < size; i++) { // 가장 왼쪽부터 시작해서 가장 끝까지
				int left = i; // 한칸씩 이동
				int right = size - 1; // 오른쪽은 항상 끝이 시작
				int cur_length = 0; // 현재 팰린드롬 길이
				int idx = 1; // 몇번째 반복인지 알려줄 인덱스

				while (left < right) {
					char left_c = s.charAt(left);
					char right_c = s.charAt(right);

					if (left_c == right_c) {
						left++;
						right--;
						cur_length += 2;
					} else {
						cur_length = 0;
						left = i;
						right = size - 1 - idx;
						idx++;
					}
				}
				if (left == right)
					cur_length++;

				max_length = max_length > cur_length ? max_length : cur_length;

			}

			int answer = max_length;

			return answer;
		}
	}

	public static void main(String[] args) {
		String s = "abcbaqwqabcba";
		System.out.println(new Solution().solution(s));
	}
}
