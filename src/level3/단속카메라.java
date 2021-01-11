/**
 * 
 */
package level3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 단속카메라 {
	public static void main(String[] args) {
		int[][] route = {
				{-20, 15},
				{-14, -5},
				{-18, -13},
				{-5, -3},
		};
		
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i = 0; i < route.length; i++) {
			pQueue.offer(route[i]); // 내림차순 정렬
		}
		
		int cctvCnt = 0;
		int cctvPos = 30001;
		
		while(!pQueue.isEmpty()) {
			int[] curCar = pQueue.poll();
			if(cctvPos > curCar[0]) {
				if(cctvPos <= curCar[1]) continue; // 구간안에 있으면 pass
				cctvPos = curCar[0]; // 현재 자동차 구간보다 뒤에 있다면 앞으로
				cctvCnt++;
			}
		}
		System.out.println(cctvCnt);
	}
}
