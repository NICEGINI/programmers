/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YSM
 *
 */
public class 캐시 {
	static class Solution {
		int HIT = 1, NOHIT = 5;
	    public int solution(int cacheSize, String[] cities) {
	    	if(cacheSize == 0) return cities.length * NOHIT;
	    	List<String> list = new ArrayList<String>();
	    	
	    	int answer = 0;
	    	
	    	for(int i = 0; i < cities.length; i++) {
	    		if(isHit(list, cities[i].toLowerCase(), cacheSize)) {
	    			answer += HIT;
	    		} else {
	    			answer += NOHIT;
	    		}
	    	}
	    	
	        return answer;
	    }
	    
		private boolean isHit(List<String> list, String city, int cacheSize) {
			boolean flag = false;
			if(list.contains(city)) {
				list.remove(city);
				flag = true;
			} else {
				if(list.size() == cacheSize) {
					list.remove(0);
				}
				flag = false;
			}
			list.add(city);
			
			return flag;
		}
	}
	public static void main(String[] args) {
		int cacheSize = 2;
		String[] cities = {
				"Jeju", "Pangyo", "NewYork", "newyork"
				};
		
		System.out.println(new Solution().solution(cacheSize, cities) );
	}
}
