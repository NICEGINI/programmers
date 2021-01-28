/**
 * 
 */
package level2;

public class 다음큰숫자 {
	static class Solution {
	    public int solution(int n) {
	    	String b_num = Integer.toBinaryString(n);
	    	int onecnt = 0;
	    	
	    	for(char binary : b_num.toCharArray()) {
	    		if(binary == '1') {
	    			onecnt++;
	    		}
	    	}
	    	
	    	int answer = 0;
	    	
	    	for(int next = n+1; next <= 10000000; next++) {
	    		int next_one_cnt = 0;
	    		String next_binary = Integer.toBinaryString(next);
	    		for(char binary : next_binary.toCharArray()) {
		    		if(binary == '1') {
		    			next_one_cnt++;
		    		}
		    	}
	    		if(onecnt == next_one_cnt) {
	    			answer = next;
	    			break;
	    		}
	    	}
	    	
	    	return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 6;
		System.out.println(new Solution().solution(n));
	}
}
