/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 스타수열 {
	static class Solution {
	    public int solution(int[] a) {
	    	int length = a.length;
	    	if(length < 2) return 0;
	    	
	    	int[] count = new int[length+1];
	    	
	    	for(int i = 0; i < length; i++) {
	    		count[a[i]]++; // 각 숫자가 얼마나 나왔는지 판단
	    	}
	    	
	    	int answer = 0;
	    	for(int i = 0; i <= length; i++) {
	    		// 현재 star 수열의 길이보다 짧다면 볼 필요 없다.
	    		if(count[i] * 2 <= answer) continue;
	    		int star = 0;
	    		for(int j = 0; j < length-1; j++) {
	    			if((a[j] == i || a[j+1] == i)&&(a[j] != a[j+1])){
	    				star += 2;
	    				j++;
	    			}
	    		}
	    		answer = answer > star ? answer : star;
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] a = {5,2,3,3,5,3};
		System.out.println(new Solution().solution(a));
	}
}
