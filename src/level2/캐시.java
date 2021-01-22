/**
 * 
 */
package level2;

import java.util.HashMap;

/**
 * @author YSM
 *
 */
public class 캐시 {
	static class Solution {
		int HIT = 1, NOHIT = 5;
	    public int solution(int cacheSize, String[] cities) {
	    	HashMap<String, Integer> map = new HashMap<>();
	    	
	    	int idx = 0;
	    	int answer = 0;
	    	
	    	for(int i = 0; i < cities.length; i++) {
	    		if(!map.containsKey(cities[i])) { // 적중 안함
	    			if(idx < cacheSize) { // 캐시 다 차기 전
		    			map.put(cities[i], 1);
		    			idx++;
	    			} else { // 캐시 다 차고 난 후 
	    				
	    			}
	    			answer += NOHIT;
	    		} else {
	    			answer += HIT;
	    			map.put(cities[i], map.get(cities[i]) + 1);
	    		}
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {
				"Jeju", "Pangyo", "Seoul", "NewYork", "LA", 
				"Jeju", "Pangyo", "Seoul", "NewYork", "LA"
				};
		
		System.out.println(new Solution().solution(cacheSize, cities) );
	}
}
