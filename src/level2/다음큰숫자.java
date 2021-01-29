/**
 * 
 */
package level2;

public class 다음큰숫자 {
	static class Solution {
	    public int solution(int n) {
	    	// 10진수 이진변환해서 스트링으로 넘겨줌
	    	String b_num = Integer.toBinaryString(n);
	    	int onecnt = 0; 
	    	
	    	// 현재 n의 1의 개수를 카운트
	    	for(char binary : b_num.toCharArray()) {
	    		if(binary == '1') {
	    			onecnt++;
	    		}
	    	}
	    	
	    	int answer = 0;
	    	
	    	// n보다 큰 수 중 1의 수가 같은 수를 찾는다
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
