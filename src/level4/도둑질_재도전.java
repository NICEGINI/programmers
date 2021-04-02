/**
 * 
 */
package level4;

/**
 * @author YSM
 *
 */
public class 도둑질_재도전 {
	static class Solution{
		public int solution(int[] money) {
			int size = money.length;
			int[] dp = new int[size-1];
			int[] dp2 = new int[size];
			
			// 첫번째 집을 선택 하는 경우
			dp[0] = money[0];
			dp[1] = 0; // 첫번째 집을 선택했기 때문에 
			
			// 첫번째 집을 선택하지 않는 경우
			dp2[0] = 0;
			dp2[1] = money[1];
			
			for(int i = 2; i < size-1; i++) {
				dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
			}
			
			for(int i = 2; i < size; i++) {
				dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
			}
			
			int answer = Math.max(dp[size-2], dp2[size-1]);
			return answer;
		}
	}
	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		System.out.println(new Solution().solution(money));
	}
}
