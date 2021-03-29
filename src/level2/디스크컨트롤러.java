/**
 * 
 */
package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author YSM
 *
 */
public class 디스크컨트롤러 {
	static class Solution {
		static class Disk{
			int in, process;

			public Disk(int in, int process) {
				this.in = in;
				this.process = process;
			}
		}
	    public int solution(int[][] jobs) {
	    	PriorityQueue<Disk> pQueue = new PriorityQueue<Disk>((o1, o2) -> o1.process - o2.process);
	    	Arrays.sort(jobs, (o1, o2)-> o1[0] - o2[0]);
	    	Queue<Disk> queue = new LinkedList<Disk>();
	    	
	    	for(int i = 0; i < jobs.length; i++) {
    			int in = jobs[i][0];
    			int process = jobs[i][1];
    			queue.offer(new Disk(in, process));
	    	}
	    	
	    	int time = 0;
	    	while(!queue.isEmpty()) {
	    		if(queue.peek().in == time) {
	    			Disk first = queue.poll();
	    			pQueue.offer(new Disk(first.in, first.process));
	    			if(queue.isEmpty()) break;
    				if(queue.peek().in != time) break; 
	    		} else 
	    			time++;
	    	}
	    	
	    	int mean_time = 0;
	    	int cnt = jobs.length;
	    	
	    	while(!pQueue.isEmpty()) {
	    		Disk cur_disk = pQueue.poll();
	    		mean_time += cur_disk.process + time - cur_disk.in;
	    		time += cur_disk.process;
	    		
	    		while(!queue.isEmpty()) {
	    			if(time >= queue.peek().in) {
	    				pQueue.offer(queue.poll());
	    			} else break;
	    		}
	    		if(pQueue.isEmpty() && !queue.isEmpty()) {
	    			time = queue.peek().in;
	    			while(!queue.isEmpty()) {
	    				if(time >= queue.peek().in) {
		    				pQueue.offer(queue.poll());
		    			} else break;
	    			}
	    		}
	    	}
	        int answer = mean_time / cnt;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		System.out.println(new Solution().solution(jobs));
	}
}
