/**
 * 
 */
package level2;

import java.util.Arrays;
import java.util.HashSet;

public class 전화번호_목록 {
	static class Solution {
	    public boolean solution(String[] phone_book) {
	    	Arrays.sort(phone_book); // 오름차순 정렬
	    	HashSet<String> set = new HashSet<String>(); 
	    	boolean answer = true;
	    	for(int i = 0; i < phone_book.length; i++) {
	    		String number = phone_book[i]; // 현재 확인할 전화번호
	    		for(int idx = 0; idx < number.length(); idx++) { // 각 문자를 모두 확인
	    			if(set.contains(number.substring(0, idx))) { // substring된 문자 확인
	    				answer = false; // 이미 있는 접두사
	    				break;
	    			}
	    		}
	    		if(!answer) break;
	    		set.add(number); // 없는 접두사라면 Hash저장
	    	}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] phone_book = {
				"113","44", "4544"
		};
		System.out.println(new Solution().solution(phone_book));
	}
}
