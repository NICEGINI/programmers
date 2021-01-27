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
	    	// 캐시길이가 0이라면 하나도 히트될 수 없음
	    	if(cacheSize == 0) return cities.length * NOHIT;
	    	List<String> list = new ArrayList<String>();
	    	
	    	int answer = 0;
	    	
	    	for(int i = 0; i < cities.length; i++) {
	    		// 현재 캐시 리스트에 현재 도시가 있는지 없는지 파악
	    		if(isHit(list, cities[i].toLowerCase(), cacheSize)) {
	    			answer += HIT; // 있으면 + 1
	    		} else {
	    			answer += NOHIT; // 없으면 + 5
	    		}
	    	}
	    	
	        return answer;
	    }
	    
		private boolean isHit(List<String> list, String city, int cacheSize) {
			boolean flag = false; // HIT / NOHIT 구분 flag
			if(list.contains(city)) { // 리스트에 있으면
				list.remove(city); // 현재 도시 일단 제거
				flag = true; // HIT!
			} else { // NOHIT!
				if(list.size() == cacheSize) { // 리스트와 캐시 사이즈가 같은 경우
					list.remove(0); // 가장 앞 원소 제거
				}
				flag = false;
			}
			list.add(city); // 맞았든 맞지 않았든 현재 도시 가장 마지막 배치
			
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
