/**
 * 
 */
package level3;

import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 셔틀버스 {
	static class Solution {
	    public String solution(int n, int t, int m, String[] timetable) {
	    	PriorityQueue<String> wait_pQueue = new PriorityQueue<String>((o1,o2)->o1.compareTo(o2));
	    	
	    	for(int i = 0; i < timetable.length; i++) {
	    		wait_pQueue.offer(timetable[i]); // 도착 시간별로 정렬 저장
	    	}
	    	
	    	PriorityQueue<String> bus_queue = new PriorityQueue<String>();
	    	
	    	// 버스 도착 시간 계산
	    	calc_bus_time(bus_queue, n, t);
	    	
	    	// 도착 시간과 버스의 댓수를 기준으로 콘의 시간 계산
	        String answer = calc_corn_time(wait_pQueue, bus_queue, n, t, m);
	        return answer;
	    }

		/** 콘이 와야 할 시간 계산 */
		private String calc_corn_time(PriorityQueue<String> wait_pQueue, 
									  PriorityQueue<String> bus_queue, int n, int t, int m) {
			int bus_cnt = 1;
			while(!bus_queue.isEmpty()) {
				String bus_time = bus_queue.poll();
				String[] bus_time_hh_mm = bus_time.split(":");
				
				String cur_bus_hh = bus_time_hh_mm[0];
				String cur_bus_mm = bus_time_hh_mm[1];
				
				int man_cnt = 0;
				
				String last_man = "";
				
				while(true) {
						if(!wait_pQueue.isEmpty()) {
						String[] cur_wait_time = wait_pQueue.peek().split(":");
						
						String cur_wait_hh = cur_wait_time[0];
						String cur_wait_mm = cur_wait_time[1];
		
						if(cur_wait_hh.compareTo(cur_bus_hh) < 0) { // 버스 시 보다 먼저 온 경우
							last_man = wait_pQueue.poll();
							man_cnt++;
						} else if(cur_wait_hh.compareTo(cur_bus_hh) == 0) { // 버스 시와 똑같이 온 경우?
							if(cur_wait_mm.compareTo(cur_bus_mm) <= 0) { // 버스 분 보다 먼저 왔거나 같이 온 경우만
								last_man = wait_pQueue.poll();
								man_cnt++;
							} else { // 대기열이 버스보다 더 늦게 온 경우 멈춤
								break;
							}
						} else { // 대기열이 버스보다 더 늦게 온 경우 멈춤
							break;
						}
						if(man_cnt == m) break; // 버스에 사람이 가득 찼다면 멈춤
					} else {
						break;
					}
				}
				
				if(n == bus_cnt) { // 마지막 버스인지 판단.
					if(man_cnt < m) { // 자리가 넉넉
						return bus_time; // 버스 시간에 맞춰서 오면 된다.
					} else { // 자리가 없어!
						String[] last = last_man.split(":");
						
						// 마지막 사람보다 1분 먼저 도착해야 한다.
						int last_hh = Integer.parseInt(last[0]);
						int last_mm = Integer.parseInt(last[1]);
						
						if(last_mm > 0) {
							last_mm--; // 1분 빨리!
						} else { // 00분이었다
							last_mm = 59; 
							last_hh--;
						}
						
						StringBuilder sb = new StringBuilder();
						
			    		if(last_hh < 10) {
			    			sb.append("0"+last_hh+":");
			    		} else {
			    			sb.append(last_hh+":");
			    		}
			    		if(last_mm < 10) {
		    				sb.append("0"+last_mm);
		    			} else {
		    				sb.append(last_mm);
		    			}
						return sb.toString();
					}
				}
				bus_cnt++;
			}
			
			return null;
		}

		/** 모든 버스의 도착 시간 계산 */
		private void calc_bus_time(PriorityQueue<String> bus_queue, int n, int t) {
			bus_queue.offer("09:00");
	    	String pre_bus = bus_queue.peek();
	    	
	    	for(int i = 1; i < n; i++) {
	    		String[] bus_time = pre_bus.split(":");
	    		int bus_hh = Integer.parseInt(bus_time[0]);
	    		int bus_mm = Integer.parseInt(bus_time[1]);
	    		
	    		if(t != 60) { // 간격이 1시간인지 판단
	    			bus_mm += t;
	    			if(bus_mm >= 60) {
	    				bus_mm -= 60;
	    				bus_hh++;
	    			}
	    		} else {
	    			bus_hh++;
	    		}
	    		StringBuilder sb = new StringBuilder();
	    		if(bus_hh < 10) {
	    			sb.append("0"+bus_hh+":");
	    		} else {
	    			sb.append(bus_hh+":");
	    		}
	    		if(bus_mm < 10) {
    				sb.append("0"+bus_mm);
    			} else {
    				sb.append(bus_mm);
    			}
	    		bus_queue.offer(sb.toString());
	    		pre_bus = sb.toString();
	    	}
		}
	}
	public static void main(String[] args) {
		int n = 2, t = 10, m = 2;
		String[] timetable = {
				"09:10", "09:09", "08:00"
		};
		System.out.println(new Solution().solution(n, t, m, timetable));
	}
}
