/**
 * 
 */
package level2;

/**
 * 1, 2, 3, 4 / 5, 6, 7, 8
 * 1, 4 / 5, 7
 * 4 / 7
 *
 */
public class 예상대진표_비트연산 {
	static class Solution
	{
	    public int solution(int n, int a, int b)
	    {
	    	 int answer = 0;
	         while(a != b){
	             a = (a+1) >> 1;
	             b = (b+1) >> 1;
	             answer++;
	         }
	        
	         return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(8, 4, 7));
	}
}
