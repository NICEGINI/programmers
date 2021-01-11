/**
 * 
 */
package level2;

import java.util.Stack;

/**
 * @author YSM
 *
 */
public class n진수 {
	public static void main(String[] args) {
		int n = 2, 
			t = 4, 
			m = 2, 
			p = 1;
		char number[] = {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F'};
		String answer = "";
		int num = 0; // 실제 숫자
		int personCnt = 1; // 차례를 나타낼 인덱스
		int numberCnt = 0; // 현재까지 누적한 내가 말 할 숫자의 수
		StringBuffer sb = new StringBuffer();
		while(true){
			// 숫자가 진법보다 작은 경우 체크
			if(num < n){
				if(personCnt == p){ // 자기 차례가 되었다
					sb.append(number[num]);
					personCnt++;
					numberCnt++;
				} else {
					personCnt++;
				}
				if(personCnt == m+1) personCnt = 1;
			} else{ // 큰 경우 체크. 해당 숫자를 해당 진법에 맞게 변환해서 써야한다.
				int q = num, r;
				Stack<Integer> stack = new Stack<>();
				while(true){ // 진법 변환
					r = q%n; // 나머지
					stack.push(r);
					q = q/n; // 몫
					if(q < n){
						stack.push(q);
						break;
					}
				}

				while(true){ // answer 추가
					if(stack.isEmpty()) break;
					int idx = stack.pop();
					if(personCnt == p){ // 자기 차례가 되었다
						sb.append(number[idx]);
						personCnt++;
						numberCnt++;
					}else{
						personCnt++;
					}
					if(personCnt == m+1) personCnt = 1;
					if(numberCnt == t) break;
				}
			}
			if(numberCnt == t) break;
			num++;
		}
		System.out.println(sb.toString());
	}
}