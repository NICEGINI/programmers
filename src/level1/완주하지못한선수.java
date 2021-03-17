/**
 * 
 */
package level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author YSM
 *
 */
public class 완주하지못한선수 {
	static class Solution {
	    public String solution(String[] participant, String[] completion) {
	    	HashMap<String,Integer> map = new HashMap<String,Integer>();
	    	for(int i = 0; i < participant.length; i++) {
	    		String key = participant[i];
	    		if(map.containsKey(key))
	    			map.put(key, map.get(key)+1);
	    		else
	    			map.put(key, 1);
	    	}
	    	
	    	for(int i = 0; i < completion.length; i++) {
	    		String key = completion[i];
	    		if(map.containsKey(key)) {
	    				map.put(key, map.get(key)-1);
	    				if(map.get(key) == 0) {
	    					map.remove(key);
	    				}
	    		}
	    		
	    	}
	    	
	        Set<String> set = map.keySet();
	        Iterator<String> iter = set.iterator();
	        
	        String answer = "";
	        while(iter.hasNext()) {
	        	answer = iter.next();
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(new Solution().solution(participant, completion));
	}
}
