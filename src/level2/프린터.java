/**
 * 
 */
package level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class 프린터 {
	static class Solution {
	    public int solution(int[] priorities, int location) {
	    	Queue<Integer> priQueue = new LinkedList<Integer>(); // 우선순위 저장
	    	Queue<Integer> orderQueue = new LinkedList<Integer>(); // 우선순위 위치 인덱스 저장
	    	
	    	for(int i = 0 ; i < priorities.length; i++) {
	    		priQueue.offer(priorities[i]); // 현재 숫자 넣기
	    		orderQueue.offer(i); // 인덱스 저장
	    	}

	    	int answer = 0; // 정답
	    	
	    	while(!priQueue.isEmpty()) { // 원하는 위치까지 도달할 때까지 반복
	    		Queue<Integer> tmpQueue = new LinkedList<Integer>(); // 임시 우선순위
	    		Queue<Integer> tmpOrderQueue = new LinkedList<Integer>(); // 임시 위치인덱스
	    		
	    		int cur_pri = priQueue.poll(); // 현재 우선순위
	    		
	    		tmpQueue.offer(cur_pri); // 일단 임시에 담자
	    		tmpOrderQueue.offer(orderQueue.poll()); // 순번 기억
	    		
	    		boolean flag = false; // 자신보다 큰 값이 있는지 파악
	    		
	    		while(!priQueue.isEmpty()) { // 현재 자신을 뺀 나머지와 비교
	    			int next_pri = priQueue.peek(); // 다음 값 슬쩍 보기
	    			
	    			if(cur_pri >= next_pri) { // 자기보다 작거나 같은 수라면 임시 Queue에 저장
	    				tmpQueue.offer(priQueue.poll());
	    				tmpOrderQueue.offer(orderQueue.poll());
	    			} else { // 자기보다 큰 수가 나타났다면?!
	    				flag = true;
	    				while(!tmpQueue.isEmpty()) { // 임시 큐에 담은 숫자들을 옮겨담자
	    					priQueue.offer(tmpQueue.poll());
	    					orderQueue.offer(tmpOrderQueue.poll());
	    				}
	    				break; // 큰 값이 나타났으면 멈춤
	    			}
	    		}
	    		
	    		if(!flag) { // 자기보다 큰 수 없었음
    				answer++; // 현재 자신이 출력되므로 카운트+1
    				tmpQueue.poll(); // 자기 자신은 출력
    				int cur_order = tmpOrderQueue.poll(); // 현재 인덱스가
    				
    				if(cur_order == location) break; // 원하는 위치라면 전체 멈춤
    				
    				while(!tmpQueue.isEmpty()) { // 임시 큐에 담은 숫자들을 옮겨담자
    					priQueue.offer(tmpQueue.poll());
    					orderQueue.offer(tmpOrderQueue.poll());
    				}
    			}
	    	}
	    	
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int priorities[] = { 2, 1, 3, 2 };
		int location = 0;
		
		System.out.println(new Solution().solution(priorities, location));
	}
}
