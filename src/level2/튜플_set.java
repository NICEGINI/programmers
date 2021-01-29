/**
 * 
 */
package level2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author YSM
 *
 */
public class 튜플_set {
	static class Solution {
		public int[] solution(String s) {
			HashSet<String> set = new HashSet<String>();
			
			String elements[] = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
			
			Arrays.sort(elements, ((s1, s2) -> {
				return s1.toString().length() - s2.toString().length();
			}));
			
			int[] answer = new int[elements.length];
			int idx = 0;
			for(String element : elements) {
				for(String num : element.split(",")) {
					if(set.add(num)) answer[idx++] = Integer.parseInt(num);
				}
			}
			
			return answer;
		}
	}

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(new Solution().solution(s));
	}
}
