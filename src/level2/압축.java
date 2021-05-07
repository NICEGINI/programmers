/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 압축 {
	static class Solution {
	    public int[] solution(String msg) {
	    	HashMap<String, Integer> map = new HashMap<String, Integer>();
	    	for(int i = 0; i < 26; i++) {
	    		String key = String.valueOf((char)('A' + i));
	    		map.put(key, i+1);
	    	}
	    	
	    	List<Integer> list = new ArrayList<Integer>();
	    	int idx = 27; // 27번 부터 등록
	    	for(int i = 0; i < msg.length(); i++) {
	    		// 문자 사전에 등록 되었는지 확인
	    		char cur = msg.charAt(i);
	    		int value = map.get(String.valueOf(cur));
	    		if(map.containsKey(String.valueOf(cur))) {
	    			StringBuilder sb = new StringBuilder(String.valueOf(cur));
	    			for(int j = i+1; j < msg.length(); j++) {
	    				sb.append(msg.charAt(j));
	    				if(!map.containsKey(sb.toString())) {
	    					map.put(sb.toString(), idx++);
	    					i = j-1;
	    					break;
	    				} else {
	    					value = map.get(sb.toString());
	    					i = j;
	    				}
	    			}
	    			list.add(value);
	    		}
	    	}
	    	
	    	// 숫자 옮기기
	        int[] answer = new int[list.size()];
	        int cnt = 0;
	        for(int out : list) {
	        	answer[cnt++] = out;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		System.out.println(new Solution().solution(msg));
	}
}
