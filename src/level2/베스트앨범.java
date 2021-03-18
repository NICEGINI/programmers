/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author YSM
 *
 */
public class 베스트앨범 {
	static class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	    	HashMap<String, Integer> total = new HashMap<>();
	    	HashMap<Integer, Integer> play_map = new HashMap<>();
	    	HashMap<Integer, String> genre_map = new HashMap<>();
	    	
	    	for(int i = 0; i < genres.length; i++) {
	    		String genre = genres[i];
	    		int value = plays[i];
	    		if(total.containsKey(genre)) {
	    			total.put(genre, total.get(genre)+value);
	    		}
	    		else
	    			total.put(genre, value);
    			play_map.put(i, value);
    			genre_map.put(i, genre);
	    	}
	    	
	    	// 맵 value 기준 내림차순 정렬
	    	List<Entry<String, Integer>> mapList = new ArrayList<Entry<String, Integer>>(total.entrySet());
	    	List<Entry<Integer, Integer>> playList = new ArrayList<Entry<Integer, Integer>>(play_map.entrySet());
	    	List<Entry<Integer, String>> genreList = new ArrayList<Entry<Integer, String>>(genre_map.entrySet());
	    	Collections.sort(mapList, (o1, o2)-> -o1.getValue().compareTo(o2.getValue()));
	        
	    	List<Integer> answerList = new ArrayList<Integer>();
	    	
	    	for(Entry<String, Integer> entry : mapList) {
	    		String genre = entry.getKey();
	    		List<Entry<Integer, Integer>> tmpList = new ArrayList<>();
	    		for(Entry<Integer, String> genre_entry: genreList) {
	    			if(genre_entry.getValue().equals(genre)) {
	    				int key = genre_entry.getKey();
	    				tmpList.add(playList.get(key));
	    			}
	    		}
	    		Collections.sort(tmpList, (o1, o2)-> -o1.getValue().compareTo(o2.getValue()));
	    		
	    		int cnt = 0;
	    		for(Entry<Integer, Integer> order: tmpList) {
	    			answerList.add(order.getKey());
	    			cnt++;
	    			if(cnt == 2) break;
	    		}
	    	}
	    	
	    	int[] answer = new int[answerList.size()];
	    	for(int i = 0; i < answerList.size(); i++) {
	    		answer[i] = answerList.get(i);
	    	}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] genres = {
				"classic", "pop", "classic", "classic", "pop"
		};
		int[] plays = {
				500, 600, 150, 800, 2500
		};
		System.out.println(new Solution().solution(genres, plays));
	}
}	
