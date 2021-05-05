/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 문자열압축 {
	static class Solution {

	    public int solution(String s) {
	        if (s.length() == 1) return 1;

	        int answer = 1001;
	        for (int length = s.length() / 2; length > 0; length--) {
	            String current, next = "", result = "";
	            int repeat = 1;
	            for (int count = 0; count <= s.length() / length; count++) {
	                current = next;
	                int start = count * length;
	                int end = Math.min(length * (count + 1), s.length());
	                next = s.substring(start, end);

	                if (current.equals(next)) {
	                    repeat++;
	                } else {
	                    result += (getRepeatCount(repeat) + current);
	                    repeat = 1;
	                }
	            }
	            result += (getRepeatCount(repeat) + next);
	            answer = Math.min(answer, result.length());
	        }
	        
	        return answer;
	    }

	    private String getRepeatCount(int hit) {
	        return hit > 1 ? String.valueOf(hit) : "";
	    }
	}
	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println(new Solution().solution(s));
	}
}
