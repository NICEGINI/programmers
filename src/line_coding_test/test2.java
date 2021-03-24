/**
 * 
 */
package line_coding_test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author YSM
 *
 */
public class test2 {
	static class Solution {
		static int ONE = 1, TWO =2 , THREE = 3, FOUR = 4, FIVE = 5;
	    public int[] solution(String inp_str) {
	    	HashSet<Integer> violation = new HashSet<Integer>();
	    	
	    	// 규칙1
	    	int length = inp_str.length();
	    	if(length < 8 || length > 15) violation.add(ONE);
	    		
	    	// 규칙2, 3, 4, 5
	    	HashMap<Character, Integer> char_cnt_map = new HashMap<Character, Integer>();
	    	boolean[] sec_rule = new boolean[4];
	    	char pre_char = ' ';
	    	int pre_cnt = 1;
	    	
	    	for(int i = 0; i < length; i++) {
	    		char cur_char = inp_str.charAt(i);
	    		if('A' <= cur_char && cur_char <= 'Z') { // 대문자
	    			sec_rule[0] = true;
	    		} else if('a' <= cur_char && cur_char <= 'z') { // 소문자
	    			sec_rule[1] = true;
	    		} else if('0' <= cur_char && cur_char <= '9') { // 영문자
	    			sec_rule[2] = true;;
	    		} else { // 특수문자
	    			switch(cur_char) {
		    			case '~':
		    			case '!':
		    			case '@':
		    			case '#':
		    			case '$':
		    			case '%':
		    			case '^':
		    			case '&':
		    			case '*':
			    			sec_rule[3] = true;;
		    				break;
		    			default:
		    				violation.add(TWO);
		    				break;
	    			}
	    		}
	    		
	    		if(pre_char == cur_char) {
    				pre_cnt++;
    				if(pre_cnt >= 4) {
    					violation.add(FOUR);
    				}
    			} else {
    				pre_cnt = 1;
    			}
	    		
	    		pre_char = cur_char;
	    		
	    		if(char_cnt_map.containsKey(cur_char)) {
	    			int cnt = char_cnt_map.get(cur_char);
	    			if(cnt >= 4) violation.add(FIVE); // 규칙 5 위반
	    			char_cnt_map.put(cur_char, cnt + 1);
	    		} else
	    			char_cnt_map.put(cur_char, 1);
	    	}
	    	
	    	int true_cnt = 0;
	    	for(int i = 0; i < sec_rule.length; i++) {
	    		if(sec_rule[i]) true_cnt++;
    		}
	    	if(true_cnt < 3)
	    		violation.add(THREE);
	    	
	    	if(violation.size() == 0) {
	    		int[] answer = {0};
	    		return answer;
	    	}
	    	
	    	int[] answer = new int[violation.size()];
	    	int idx = 0;
	    	for(int cnt : violation) {
	    		answer[idx++] = cnt;
	    	}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String inp_str = "CaCbCgCdC888834A";
		System.out.println(new Solution().solution(inp_str));
	}
}
