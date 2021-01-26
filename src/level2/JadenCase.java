/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class JadenCase {
	static class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();
	    	String[] strArray = s.split(" "); // " " 공백을 기준으로 split
	    	
	    	for(int i = 0; i < strArray.length; i++) {
	    		String tmp = strArray[i];
	    		if(!tmp.equals("")) { // 해당 문자열이 공백이 아니라면
		    		if('a' <= tmp.charAt(0) && tmp.charAt(0) <= 'z' || // 소문자 - 대문자인 경우
		    		   'A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z') {
		    			String first = tmp.substring(0,1).toUpperCase();
		    			String remain = tmp.substring(1, tmp.length()).toLowerCase();
		    			sb.append(first + remain);
		    		}else { // 숫자인 경우
		    			sb.append(tmp.toLowerCase());
		    		}
		    		sb.append(" "); // 공백 하나 추가
	    		} else { // 공백이면 공백 그대로 출력
	    			sb.append(" ");
	    		}
	    	}
	    	
	    	sb.replace(sb.length()-1, sb.length(), ""); // 문자로 끝이 났다면 공백 하나가 있다. 제거
	    	
	    	// 마지막에 공백인 경우도 제거해 주어야 한다.
	    	for(int i = s.length()-1; i >= 0; i--) {
	    		if(s.charAt(i) == ' ') {
	    			sb.append(s.charAt(i));
	    		} else break;
	    	}
	    	
	        String answer = sb.toString();
	        return answer;
		}

	}
	public static void main(String[] args) {
		String s = " A  Sdf Fft  ";
		
		System.out.println(new Solution().solution(s));
	}
}
