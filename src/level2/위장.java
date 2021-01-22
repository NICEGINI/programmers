package level2;

import java.util.HashMap;
import java.util.Map.Entry;

public class 위장 {
	static class Solution {
	    public int solution(String[][] clothes) {
	    	int n = clothes.length;
	    	
	    	HashMap<String, Integer> map = new HashMap<>();
	    	
	    	for(int i = 0; i < n; i++) {
	    		if(map.containsKey(clothes[i][1]))
	    			map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
	    		else 
	    			map.put(clothes[i][1], 2);
	    	}
	    	
	        int answer = 1;
	        
	        for(String key : map.keySet()) {
	        	answer *= map.get(key);
	        }
	        
	        return answer-1;
	    }
	}
	public static void main(String[] args) {
		String[][] clothes = {
				{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"}
		};
		System.out.println(new Solution().solution(clothes));
	}
}
