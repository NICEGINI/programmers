/**
 * 
 */
package level2;

import java.util.HashMap;

/**
 * @author YSM
 *
 */
public class 다단계칫솔판매 {
	static class Solution {
		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
			HashMap<String, String> connect = new HashMap<String, String>(); // 추천인과 연결된 정보
			HashMap<String, Integer> getTotalSell = new HashMap<String, Integer>(); // 판매 정보
			for (int i = 0; i < enroll.length; i++) { // 모든 추천인과 연결
				String key = enroll[i];
				String value = referral[i];
				connect.put(key, value);
			}

			for (int i = 0; i < seller.length; i++) { // 판매를 한 사람의 수만큼 반복
				String key = seller[i]; // 판매원
				int totalSell = amount[i] * 100; // 판매 금액
				int sell = totalSell * 10 / 100; // 상납 금액
				if (getTotalSell.containsKey(key)) { // 판매원이 이전에 입력된 금액이 있다면 누적
					getTotalSell.put(key, getTotalSell.get(key) + totalSell - sell);
				} else {// 없으면 새로 넣어줌
					getTotalSell.put(key, totalSell - sell);
				}

				String connectPerson = connect.get(key); // 추천인 확인
				while (!connectPerson.equals("-")) { // 추천인이 더이상 없을때까지 반복
					if (getTotalSell.containsKey(connectPerson)) { // 추천인이 현재 누적금액에 있는 경우 더해줌. 금액은 판매 금액의 90%
						getTotalSell.put(connectPerson,
								getTotalSell.get(connectPerson) + (int) Math.ceil((double) sell * 90 / 100));
					} else { // 없으면 새로 넣어줌
						getTotalSell.put(connectPerson, (int) Math.ceil((double) sell * 90 / 100));
					}
					sell = sell * 10 / 100; // 다음 추천인의 금액은 현재 판매액의 10%
					connectPerson = connect.get(connectPerson); // 다음 추천인
				}
			}

			int[] answer = new int[enroll.length]; // 모든 사람의 금액 확인
			for (int i = 0; i < enroll.length; i++) {
				String key = enroll[i];
				if (getTotalSell.containsKey(key))
					answer[i] = getTotalSell.get(key);
				else // 판매금액이 없는 경우에는 0원
					answer[i] = 0;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int[] amount = { 12, 4, 2, 5, 10 };
		System.out.println(new Solution().solution(enroll, referral, seller, amount));
	}
}
