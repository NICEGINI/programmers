/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 스티커모으기 {
	static class Solution {
	    public int solution(int sticker[]) {
	    	int length = sticker.length;
	    	if(length <= 3) {
	    		int max = 0;
	    		for(int i = 0; i < length; i++) {
	    			max = max > sticker[i] ? max : sticker[i];
	    		}
	    		return max;
	    	}
	    	int[] dp1 = new int[length];
	    	int[] dp2 = new int[length];
	    	
	    	// 1번 선택 한 경우, 1번 선택 안한 경우
	    	dp1[0] = dp1[1] = sticker[0];
	    	
	    	// 2번 선택 한 경우
	    	dp2[0] = 0;
	    	dp2[1] = sticker[1];
	    	
	    	for(int i = 2; i < length-1; i++) {
	    		dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
	    		dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
	    	}
	    	
	    	dp1[length-1] = Math.max(dp1[length-2], dp1[length-3]);
	    	dp2[length-1] = Math.max(dp2[length-2], dp2[length-3] + sticker[length-1]);
	        int answer = Math.max(dp1[length-1], dp2[length-1]);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
		System.out.println(new Solution().solution(sticker));
	}
}
