/**
 * 
 */
package KaKao_comerce;

/**
 * @author YSM
 *
 */
public class test1 {
	static class Solution {
	    public int solution(int[] gift_cards, int[] wants) {
	    	int[] cards = new int[100001];
	    	for(int i = 0; i < gift_cards.length; i++) {
	    		cards[gift_cards[i]]++;
	    	}
	    	int answer = 0;
	    	
	    	for(int i = 0; i < wants.length; i++) {
	    		cards[wants[i]]--;
	    	}
	    	
	    	for(int i = 0; i < cards.length; i++) {
	    		if(cards[i] < 0) answer++;
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] gift_cards = {4, 5, 3, 2, 1};
		int[] wants = {2, 4, 4, 5, 1};
		System.out.println(new Solution().solution(gift_cards, wants));
	}
}
