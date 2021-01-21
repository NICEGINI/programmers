/**
 * 
 */
package level2;

public class 카펫 {
	static class Solution {
	    public int[] solution(int brown, int yellow) {
	    	int size = brown + yellow; // 카펫의 전체 크기
	    	
	    	int[] answer = new int[2];
	    	
	    	for(int i = 3; i < size; i++) {
	    		int width = i; // 가로길이를 변경해가며 카펫 크기 유추
	    		int height = size / i; // 카펫의 세로길이
	    		
	    		if(width < height) continue; // 가로가 짧은 경우는 보지 않는다
	    		
	    		// 카펫 전체가 노란색으로 지정되어 있고
	    		// 테두리만 갈색으로 칠하는 경우라고 생각
	    		// 간단한 수식으로 구할 수 있다
	    		// 중복 값이 4군데 있으므로 -4 해주자
	    		int sum = width*2 + height*2 - 4; 
	    		
	    		if(sum == brown) { // 테두리의 계산값이 갈색의 총 수와 같으면 정답
	    			answer[0] = width;
	    			answer[1] = height;
	    			break;
	    		}
	    	}
	    	
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int brown = 24, yellow = 24;
		System.out.println(new Solution().solution(brown, yellow));
	}
}
