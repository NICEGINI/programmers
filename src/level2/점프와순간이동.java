/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 점프와순간이동 {
	static public class Solution {
	    public int solution(int n) {
	    	int tel = n;
	    	int k = 0;
	    	
	    	while(tel != 0) {
	    		if(tel%2 == 0) tel = tel/2;
	    		else {
	    			tel = tel-1;
	    			k++;
	    		}
	    	}
	    	
	        int ans = k;
	        return ans;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(100));
	}
}
