/**
 * 
 */
package level2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author YSM
 *
 */
public class 큰수만들기 {
	public static void main(String[] args) {
		int k = 8;
		String number = "987654321";
		int numberLength = number.length();
		StringBuilder answer = new StringBuilder();
		
		Deque<Character> deque = new LinkedList<>();
		
		deque.push(number.charAt(0)); // 가장 처음 숫자 스택 적립
		
		int idx = 1, discard = 0;
		while(true) {
			if(idx == numberLength) {
				while(!deque.isEmpty()) {
					answer.append(deque.pollLast());
				}
				int remain = numberLength - k;
				String tmpanswer = answer.substring(0, remain);
				answer = new StringBuilder();
				answer.append(tmpanswer);
				break;
			}
			char next = number.charAt(idx);
			char peek = deque.peekFirst();
			if(peek < next) {
				deque.pollFirst();
				discard++;
				if(discard != k){
					while(true) {
						char pre = '0';
						if(!deque.isEmpty()) {
							pre = deque.peekFirst();
							if(pre < next) {
								deque.pollFirst();
								discard++;
								if(discard == k) break;
							} else {
								break;
							}
						} else break;
					}
				}
				deque.push(next);
			}
			else {
				deque.push(next);
			}
			idx++;
			if(discard == k) {
				while(!deque.isEmpty()) {
					answer.append(deque.pollLast());
				}
				answer.append(number.substring(idx, numberLength));
				break;
			}
		}
		System.out.println(answer.toString());
	}
}