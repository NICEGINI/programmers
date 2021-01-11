/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	static class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	    	Queue<int[]>queue = new LinkedList<int[]>();
	    	for(int i = 0; i < progresses.length; i++) { // 진행률과 개발속도를 큐에 저장
	    		queue.offer(new int[]{progresses[i], speeds[i]});
	    	}
	    	
	    	List<Integer> answerList = new ArrayList<Integer>();
	    	
	    	while(!queue.isEmpty()) { // 큐를 순회 할 것인데
	    		int size = queue.size(); // 사이즈별로 순회
	    		int idx = 0; // 가장 앞을 가리켜 줄 인덱스
	    		int count = 0; // 현재 사이즈에서 나올 수 있는 카운트
	    		
	    		for(int s = 0; s < size; s++) { // 사이즈 별 순회 시작
	    			int[] curProgress = queue.poll(); // 현재 진행률
	    			int nextProgress = curProgress[0] + curProgress[1]; // 다음 진행률
	    			// 가장 앞에있는 기능이고 진행률이 100이 넘었으면
	    			if(idx == s && nextProgress >= 100) { // 인덱스와 진향률을 함께 비교
	    				count++; // 기능 배포
	    				idx++; // 가장 앞 기능 순서 지정
	    			} else { // 아직 완료 안됐으면 다시 큐로
	    				queue.offer(new int[] {nextProgress, curProgress[1]});
	    			}
	    		}
	    		
	    		// 배포가 1개라도 되었을 경우에 리스트 저장
	    		if(count != 0) answerList.add(count);
	    	}
	    	// answer에 옮겨주자
	        int[] answer = new int[answerList.size()];
	        for(int i = 0; i < answer.length; i++) {
	        	answer[i] = answerList.get(i);
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int progresses[] = {95, 90, 99, 99, 80, 99};
		int speeds[] = {1, 1, 1, 1, 1, 1};
		System.out.println(new Solution().solution(progresses, speeds));
	}
}
