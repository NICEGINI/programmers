/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 조이스틱 {
	static class Solution {
		public int solution(String name) {
			char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
					'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
			int[] alphacnt = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

			int answer = 0;
			int length = name.length();

			// A를 제외한 모든 단어의 이동 추가
			for (int i = 0; i < length; i++) {
				char cur_alpha = name.charAt(i);
				if (cur_alpha != 'A') {
					for (int j = 1; j < 27; j++) {
						if (alpha[j] == name.charAt(i)) {
							answer += alphacnt[j];
							break;
						}
					}
				}
			}

			// 다음 단어로 넘어가기 위한 이동 추가
			int min = length-1;
			for (int i = 0; i < length; i++) {
				char cur_alpha = name.charAt(i);
				if (cur_alpha != 'A') { // 현재 알파벳이 A가 아닌 경우
					int idx = i+1; // 오른쪽 A의 개수를 파악
					while (true) { // 오른쪽 확인
						if (idx == length)
							break;
						char next_alpha = name.charAt(idx);
						if (next_alpha != 'A') // A가 아닌 알파벳을 만나면 멈춤
							break;
						idx++;
					}
					int move_cnt = 2*i + length - idx;
					min = Math.min(min, move_cnt);
				}
			}
			return answer+min;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution("JEROEN"));
	}
}
