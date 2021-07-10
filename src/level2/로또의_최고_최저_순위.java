/**
 * 
 */
package level2;

import java.util.Arrays;

/**
 * @author YSM
 *
 */
public class 로또의_최고_최저_순위 {
	static class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	    	// 내림차순 정렬
	    	Arrays.sort(lottos);
	    	Arrays.sort(win_nums);
	    	
	    	// 최악의 경우, 최선의 경우
	    	int worst_hit = 0;
	    	int best_hit = 0;
	    	
	    	// 현재 내 로또 순서, 정답 로또 순서
	    	int my_order = 6;
	    	int win_order = 6;
	    	
	    	while(true) {
	    		// 현재 내 번호와 정답과 비교
	    		int lotto = lottos[my_order-1];
	    		int winnum = win_nums[win_order-1];
	    		
	    		// 맞은 경우
	    		if(lotto == winnum) {
	    			// 최악 최선 +1
	    			worst_hit++;
	    			best_hit++;
	    			
	    			// 순서 -1
	    			my_order--;
	    			win_order--;
	    		} else if(lotto > winnum) { // 내 번호가 정답보다 큰 경우
	    			my_order--; // 내 다음 번호 확인
	    		} else if(winnum > lotto) { // 정답이 내 번호보다 큰 경우
	    			win_order--; // 다음 정답 번호 확인
	    		}
	    		
	    		if(lotto == 0) { // 뒤의 번호를 알 수 없는 경우
	    			best_hit += my_order; // 최선인 경우에 남은 경우의 수를 모두 더해줌
	    			break;
	    		}
	    		
	    		if(win_order == 0) { // 정답의 순서가 끝인경우
	    			// 내 번호중 모르는 번호가 몇개인지 파악
	    			for(int i = my_order-1; i >= 0; i--) {
	    				int rest_num = lottos[i];
	    				if(rest_num == 0) {
	    					best_hit += i+1; // 최선에 더해준다
	    					break;
	    				}
	    			}
	    			break;
	    		} 
	    		
	    		if(my_order == 0) break; // 내 번호가 끝난 경우 종료
	    	}
	    	
	    	// 최선, 최악의 경우를 가지고 몇등할지 파악
	        int[] answer = {set_grade(best_hit), set_grade(worst_hit)};
	        return answer;
	    }

	    // 등수를 파악하자
		private int set_grade(int hits) {
			switch(hits) {
			case 0:
			case 1:
				return 6;
			case 2:
				return 5;
			case 3:
				return 4;
			case 4:
				return 3;
			case 5:
				return 2;
			case 6:
				return 1;
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		System.out.println(new Solution().solution(lottos, win_nums));
	}
}
