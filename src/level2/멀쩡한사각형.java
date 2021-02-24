/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 멀쩡한사각형 {
	static class Solution {
	    public long solution(int w, int h) {
	        long area = (long)(w * h);
	        long break_area = w + h - gcd(w,h);
	        
	        long answer = area - break_area;
	        
	        return answer;
	    }

		private int gcd(int w, int h) {
			if(w%h == 0) return h;
			return gcd(h, w%h);
		}
	    
	    
	}
	public static void main(String[] args) {
		int w = 8, h = 12;
		
		System.out.println(new Solution().solution(w, h));
	}
}
