package level2;

import java.util.Stack;

public class 이진변환 {
	static class Solution {
	    public int[] solution(String s) {
	    	int zeroCnt = 0;
	    	int changeCnt = 0;
	    	
	    	while(s.length() != 1) {
	    		changeCnt++;
	    		StringBuilder sb = new StringBuilder();
		    	for(int i = 0; i < s.length(); i++) {
		    		if(s.charAt(i) == '0') {
		    			zeroCnt++;
		    		} else {
		    			sb.append("1");
		    		}
		    	}
		    	
		    	if(sb.length() == 1) break;
		    	
		    	Stack<Integer> stack = new Stack<>();
		    	
		    	int q = sb.length(), r = 0;
		    	
		    	while(true) {
		    		r = q % 2;
		    		q = q / 2;
		    		stack.push(r);
		    		if(q == 1) {
		    			stack.push(q);
		    			break;
		    		}
		    	}
		    	
		    	sb = new StringBuilder();
		    	while(!stack.isEmpty()) {
		    		sb.append(stack.pop());
		    	}
		    	
		    	s = sb.toString();
		    	
	    	}
	    	
	        int[] answer = {changeCnt, zeroCnt};
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String s = "01110";
		System.out.println(new Solution().solution(s));
	}
}
