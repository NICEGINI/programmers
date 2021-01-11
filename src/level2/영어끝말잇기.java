/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 영어끝말잇기 {
	static class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        String[] speaked = new String[words.length];
	        
	        int personIdx = 2, totalcnt = 1;
	        String preword = speaked[0] = words[0];
	        boolean flag = false;
	        for(int i = 1; i < words.length; i++) {
	        	if(flag) break;
	        	char end = preword.charAt(preword.length()-1);
	        	char start = words[i].charAt(0);
	        	
	        	if(end != start) {
	        		answer[0] = personIdx;
		        	answer[1] = totalcnt;
	        		break;
	        	}
	        	
	        	for(int j = 0; j < i; j++) {
	        		if(words[i].equals(speaked[j])) {
	        			answer[0] = personIdx;
		        		answer[1] = totalcnt;
		        		flag = true;
		        		break;
	        		}
	        	}
	        	
	        	if(++personIdx == n+1) {
                    personIdx = 1;
                    totalcnt++;
                }
                speaked[i] = preword = words[i];
	        }

	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] words = {"land", "dream", "mom", "mom"};
		System.out.println(new Solution().solution(2,words));
	}
}
