/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 거스름돈 {
	static class Solution {
		public int solution(int n, int[] money) {
			int mod = 1000000007;
			int[] D = new int[n + 1];
			int money_size = money.length;

			D[0] = 1;
			// 가장 최소의 잔돈의 배수는 무조건 1가지의 경우를 가진다.
			for (int i = money[0]; i <= n; i += money[0]) {
				D[i] = 1;
			}

			for (int j = 1; j < money_size; j++) {
				for (int i = 1; i <= n; i++) {
					if (i >= money[j])
						D[i] += D[i - money[j]] % mod;
				}
			}

			int answer = D[n];

			return answer;
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int[] money = { 1, 2, 5 };
		System.out.println(new Solution().solution(n, money));
	}
}
