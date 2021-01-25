/**
 * 
 */
package level3;

import java.util.HashSet;

/**
 * @author YSM
 *
 */
public class N으로표현 {
	static class Solution {
	    public int solution(int N, int number) {
	    	// N과 숫자가 같은 경우는 1가지 경우
	    	if(N == number) return 1;
	        int answer = -1;
	        
	        // 중복제거를 위해 HashSet 이용
	        HashSet<Integer> set_list[] = new HashSet[8];
	        
	        // 1~8자리만큼 N으로 이루어진 숫자 생성  
	        int num = 0;
	        for(int i = 0; i < 8; i++) {
	        	set_list[i] = new HashSet<Integer>();
	        	num = num*10 + N;
	        	set_list[i].add(num);
	        }
	        
	        // 사칙연산을 이용해서 나올 수 있는 모든 수 저장
	        for(int i = 1; i < 8; i++) {
	        	for(int j = 0; j < i; j++) {
	        		for(int op1 : set_list[j]) {
	        			for(int op2 : set_list[i-j-1]) {
	        				set_list[i].add(op1-op2);
	        				set_list[i].add(op1+op2);
	        				set_list[i].add(op1*op2);
	        				if(op2 != 0) set_list[i].add(op1/op2);
	        			}
	        		}
	        	}
	        	
	        	// 다음 작업으로 넘어가기 전에 결과중에 원하는 결과가 있는지 확인
	        	if(set_list[i].contains(number)) {
	        		answer = i+1;
	        		break;
	        	}
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int N = 5;
		int number = 5;
		
		System.out.println(new Solution().solution(N, number));
	}
}
