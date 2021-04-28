/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class 기지국설치 {
	static class Solution {
	    public int solution(int n, int[] stations, int w) {
	    	int width = w*2+1; // 전체 전파 닿는 거리
	    	int pre = 0;
	    	int answer = 0;
	    	
	    	for(int station : stations) {
	    		int left = station - w - 1;
	    		int right = station + w - 1;

	    		// 전파가 닿는 곳에 있으면 패스
	    		if(pre >= left && pre <= right) {
	    			pre = right + 1;
	    			continue;
	    		}
	    		
	    		int build = (left - pre) / width;
	    		int rest = (left - pre) % width;
	    		
	    		if(rest > 0) {
	    			build++;
	    		}
	    		
	    		answer += build;
	    		
	    		// 현재 기지국의 전파가 닿는 곳까지
	    		pre = right + 1;
	    	}
	    	
	    	// 다 순회해도 끝까지 도달하지 않은 경우가 분명히 있다
	    	if(pre < n) {
	    		int build = (n - pre) / width;
	    		int rest = (n - pre) % width;
	    		
	    		if(rest > 0) {
	    			build++;
	    		}
	    		
	    		answer += build;
	    	}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int N = 16;
		int[] stations = {9};
		int W = 2;
		System.out.println(new Solution().solution(N, stations, W));
	}
}
