/**
 * 
 */
package level2;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class _124_나라의숫자 {
	public static void main(String[] args) {
		int n = 10;
		int numbers[] = {4, 1, 2};
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<>();
		// 3보다 작은 경우
		if(n < 3) {
			sb.append(numbers[n]);
		}
		// 3보다 큰 경우
		else {
			int q = n, r, carry = 0;
			while(true) {
				r = q%3;
				if(r == 0) { // 3의 배수인 경우에는 
					carry = -1; // 몫에서 -1 해줘야한다.
				}
				stack.push(numbers[r]); // r 인덱스에 있는 숫자 스택에 적재
				q = q/3 + carry; // 몫 재계산
				if(q < 3) { // 3보다 작으면
					if(q != 0) // q가 0인 경우는 제외
						stack.push(q); // 몫 적재
					break;
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
}
