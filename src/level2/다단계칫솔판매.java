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
			HashMap<String, String> connect = new HashMap<String, String>();
			HashMap<String, Integer> getTotalSell = new HashMap<String, Integer>();
			for (int i = 0; i < enroll.length; i++) {
				String key = enroll[i];
				String value = referral[i];
				connect.put(key, value);
			}

			for (int i = 0; i < seller.length; i++) {
				String key = seller[i];
				int totalSell = amount[i] * 100;
				int sell = totalSell * 10 / 100;
				if (getTotalSell.containsKey(key)) {
					getTotalSell.put(key, getTotalSell.get(key) + totalSell - sell);
				} else
					getTotalSell.put(key, totalSell - sell);
				String connectPerson = connect.get(key);
				while (!connectPerson.equals("-")) {
					if (getTotalSell.containsKey(connectPerson)) {
						getTotalSell.put(connectPerson, getTotalSell.get(connectPerson) + (int) Math.ceil((double)sell * 90 / 100));
					} else {
						getTotalSell.put(connectPerson, (int) Math.ceil((double) sell * 90 / 100));
					}
					sell = sell * 10 / 100;
					connectPerson = connect.get(connectPerson);
				}
			}

			int[] answer = new int[enroll.length];
			for (int i = 0; i < enroll.length; i++) {
				String key = enroll[i];
				if (getTotalSell.containsKey(key))
					answer[i] = getTotalSell.get(key);
				else
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
