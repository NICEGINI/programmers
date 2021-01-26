/**
 * 
 */
package level2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 뉴스_클러스터링 {
	static class Solution {
		double duplicate, length;
	    public int solution(String str1, String str2) {
	        // 리스트을 이용해서 해결하자!
	    	List<String> str_list_one = new LinkedList<String>();
	    	List<String> str_list_two = new LinkedList<String>();
	    	
	    	str1 = str1.toLowerCase();
	    	str2 = str2.toLowerCase();
	    	
	        // str1과 str2를 2덩이씩 나눈 다음
	    	// 각 리스트에 맞게 배치
	        divide(str1, str_list_one);
	        divide(str2, str_list_two);
	        
	        // 중복개수와 합했을때의 길이를 구해보자
	        find(str_list_one, str_list_two);
	    	
	        // 중복 개수 / 전체길이 하면 될 거 같다
	        if(length == 0) return 65536;
	        double calc = duplicate/length;
	        int answer = (int)(calc*65536);
	        return answer;
	    }

	    /*
	     * 중복값(교집합)과 전체길이(합집합)를 구하자
	     * */
		private void find(List<String> str_list_one, List<String> str_list_two) {
			for(String key : str_list_one) { // 리스트 하나를 기준으로 삼아 다른 리스트 항목을 제거하는 형식
				if(str_list_two.contains(key)) { // 요소가 있으면
					str_list_two.remove(key); // 제거
					duplicate++; // 중복 + 1
				}
				length++; // 전체 길이 + 1
			}
			
			length += str_list_two.size(); // 중복이 아닌 나머지 값이 남아 있는 경우 그만큼 더해주자
		}

		/*
		 * 문자열 자르기 로직
		 * */
		private void divide(String str, List<String> str_list) {
			for(int i = 0; i < str.length(); i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < 2; j++) {
					if(i+j < str.length()) {
						char next_char = str.charAt(i+j);
						if('a' <= next_char && next_char <= 'z')
							sb.append(next_char);
						
					}
				}
				if(sb.length() > 1) { // 알파벳이 아닌 경우를 만나면 길이가 1일 것.
					str_list.add(sb.toString());
				}
			}
		}
	}
	public static void main(String[] args) {
		String str1 = "handshake";
		String str2 = "shake hands";
		System.out.println(new Solution().solution(str1, str2));
	}
}
