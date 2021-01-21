package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 나중에 시간을 내서라도 다시 꼭 곡 꼭
 * 다시 풀어보고 어떤 로직인지 기억하기.
 * HashSet 사용하는 방법과
 * ArrayList에 HashSet<Integer>형식 쓰는 거도 익숙해지기
 * */
public class 후보키 {
	static class Solution {
		ArrayList<HashSet<Integer>> candidateKeys;
		int Answer;
	    public int solution(String[][] relation) {
	    	candidateKeys = new ArrayList<>();
	    	int n = relation[0].length;
	    	
	    	HashSet<Integer> keys = new HashSet<>();
	    	
	    	// 1개 ~ n개까지의 조합을 뽑아내자
	    	for(int i = 1; i <= n; i++) {
	    		combination(0, 0, i, keys, n, relation);
	    	}
	    	
	        return Answer;
	    }

		// 부분 집합
		private void combination(int idx, int start, int keysize, HashSet<Integer> keys, int n, String[][] relation) {
			if(idx == keysize) {
				
				// 중복 선택 방지
				for(HashSet<Integer> key : candidateKeys) {
					if(keys.containsAll(key)) return ;
				}
				
				int count = 0;
				HashMap<String, String> map = new HashMap<>();
				for(int i = 0; i < relation.length; i++) {
					StringBuilder sb = new StringBuilder();
					for(int k : keys) { // 선택한 인덱스 체크
						sb.append(relation[i][k]);
					}
					if(map.containsKey(sb.toString())) return; // 중복 선택시 멈춤
					map.put(sb.toString(), sb.toString());
					
					count++;
				}
				
				// 중복 선택 없이 구별이 가능한 경우
				// 후보키 리스트에 저장
				if(count == relation.length) {
					candidateKeys.add(keys);
					Answer++;
				}
				
				return ;
			}
			for(int i = start; i < n; i++) {
				HashSet<Integer> selectedKeys = new HashSet<>(keys);
				selectedKeys.add(i);
				combination(idx+1, i+1, keysize, selectedKeys, n, relation);
			}
		}
	}
	public static void main(String[] args) {
		String[][] relation = {
						{"100","ryan","music","2"},
						{"200","apeach","math","2"},
						{"300","tube","computer","3"},
						{"400","con","computer","4"},
						{"500","muzi","music","3"},
						{"600","apeach","music","2"}};
		System.out.println(new Solution().solution(relation));
	}
}
