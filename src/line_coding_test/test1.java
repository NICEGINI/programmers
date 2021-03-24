/**
 * 
 */
package line_coding_test;

/**
 * @author YSM
 *
 */
public class test1 {
	static class Solution {
	    public String solution(String[] table, String[] languages, int[] preference) {
	    	String answer = "";
	    	int max_prefer = Integer.MIN_VALUE;
	    	
	    	for(int i = 0; i < table.length; i++) {
	    		String[] job = table[i].split(" "); // 직업별로 언어를 나누자
	    		int prefer = 0;
	    		for(int j = 1; j < job.length; j++) { // 각 언어별 점수를 알아내자
	    			int grade = 6 - j;
	    			for(int k = 0; k < languages.length; k++) {
	    				if(languages[k].equals(job[j])) {
	    					prefer += grade*preference[k];
	    				}
	    			}
	    		}
	    		// 최대치의 갱신이 필요하다
	    		if(max_prefer < prefer) {
	    			max_prefer = prefer;
	    			answer = job[0];
	    		} else if(max_prefer == prefer) {
	    			if(answer.compareTo(job[0]) > 0) {
	    				answer = job[0];
	    			}
	    		}
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String table[] = {
				"SI JAVA JAVASCRIPT SQL PYTHON C#", 
				"CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", 
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", 
				"PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", 
				"GAME C++ C# JAVASCRIPT C JAVA"
		};
		String languages[] = {
				"JAVA", "JAVASCRIPT"
		};
		int[] preference = {
				7, 5
		};
		System.out.println(new Solution().solution(table, languages, preference));
	}
}
