/**
 * 
 */
package KAKAO_INTERN;

import java.util.HashMap;

/**
 * @author YSM
 *
 */
public class test1 {
	static class Solution {
	    public int solution(String s) {
	    	HashMap<String, Integer> map = new HashMap<String, Integer>();
	    	// 0~9까지 문자 대응
	    	map.put("zero", 0);
	    	map.put("one", 1);
	    	map.put("two", 2);
	    	map.put("three", 3);
	    	map.put("four", 4);
	    	map.put("five", 5);
	    	map.put("six", 6);
	    	map.put("seven", 7);
	    	map.put("eight", 8);
	    	map.put("nine", 9);
	    	
	    	StringBuilder sb = new StringBuilder();
	    	for(int i = 0; i < s.length(); i++) {
	    		char cur_c = s.charAt(i); // 현재 문자열 확인
	    		if(cur_c >= '0' && cur_c <= '9') { // 숫자면 그냥 넣기
	    			sb.append(cur_c);
	    		} else { // 문자인 경우
	    			StringBuilder key = new StringBuilder();
	    			for(int j = i; j < s.length(); j++) { // 문자를 찾아야한다.
	    				key.append(s.charAt(j));
	    				if(map.containsKey(key.toString())) { // 숫자 찾음
	    					sb.append(map.get(key.toString()));
	    					i = j;
	    					break;
	    				}
	    			}
	    		}
	    	}
	        int answer = Integer.parseInt(sb.toString());
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String s = "one4seveneight";
		System.out.println(new Solution().solution(s));
	}
}
