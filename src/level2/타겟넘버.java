/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 타겟넘버 {
	private static int cnt;
	public static void main(String[] args) {
		int numbers[] = {1, 1, 1, 1, 1};
		int target = 3;
		
		int sum = 0, summinus = 0;
		for(int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
			summinus -= numbers[i];
		}
		
		if(sum == target || summinus == target) {
			System.out.println(1);
		} else {
			dfs(0, numbers, numbers.length, target, 0);
			System.out.println(cnt);
		}
	}

	private static void dfs(int idx,int[] numbers, int length, int target, int sum) {
		if(idx == length) {
			if(sum == target) {
				cnt++;
			}
			return ;
		}
		dfs(idx+1, numbers, length, target, sum+numbers[idx]);
		dfs(idx+1, numbers, length, target, sum-numbers[idx]);
	}
}
