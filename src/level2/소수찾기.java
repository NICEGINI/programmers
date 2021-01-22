package level2;

import java.util.HashSet;
import java.util.Iterator;

public class 소수찾기 {
	static class Solution {
	    public int solution(String numbers) {
	    	HashSet<Integer> set = new HashSet<>(); // 중복제거
	    	
	    	int length = numbers.length();
	    	
	    	boolean[] selected = new boolean[length];
	    	
	    	// 가능한 모든 순서의 조합을 찾아내자
	    	for(int i = 1; i <= length; i++) { // 사이즈에 맞게 반복
	    		StringBuilder sb = new StringBuilder();
	    		permutation(0, i, numbers, sb, selected, set);
	    	}
	    	
	    	// 모든 숫자를 가지고 소수인지 판단을 하자
	    	int answer = checknumbers(set);
	        return answer;
	    }
	    
	    /**
	     * 소수 판단
	     * */
		private int checknumbers(HashSet<Integer> set) {
			int cnt = 0;
			/*
			 * HashSet은 get메서드가 없다
			 * Iterator구조를 이용해서 반복을 확인하자
			 * */
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()) {
				int num = iter.next();
				if(num <= 1) continue; // 0 또는 1 제외
				boolean flag = true;
				// 자기자신 이외에 나뉘어 지는 숫자 있는지 판단
				for(int i = 2; i < num; i++) {
					if(num % i == 0) {
						flag = false; // 있다면 소수가 아니다
						break;
					}
				}
				if(flag) cnt++;
			}
			return cnt;
		}

		/**
		 * 모든 경우의 수를 찾아내잦
		 * */
		private void permutation(int idx, int size, String numbers, StringBuilder sb, boolean[] selected, HashSet<Integer> set) {
			if(idx == size) {
				// 만들어낸 숫자 Set 저장
				set.add(Integer.parseInt(sb.toString()));
				return ;
			}
			// 일반적인 순열 + 문자다루기
			for(int i = 0; i < numbers.length(); i++) {
				if(selected[i]) continue;
				selected[i] = true;
				StringBuilder nextSb = new StringBuilder(sb);
				nextSb.append(numbers.charAt(i));
				permutation(idx+1, size, numbers, nextSb, selected, set);
				selected[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(new Solution().solution(numbers));
	}
}
