/**
 * 
 */
package level2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YSM
 *
 */
public class 가장큰수 {
	public static void main(String[] args) {
		int[] numbers = {40, 12};
		/* 일반 코딩
		PriorityQueue<String> pQueue = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1);
			}
		});
		*/
		// 람다식 코딩
		PriorityQueue<String> pQueue = new PriorityQueue<String>((o1, o2) -> -(o1+o2).compareTo(o2+o1));
		
		int zerocnt = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 0) zerocnt++;
			pQueue.offer(String.valueOf(numbers[i]));
		}
		if(zerocnt == numbers.length) System.out.println(0);
		
		StringBuilder sb = new StringBuilder();
		while(!pQueue.isEmpty())
			sb.append(pQueue.poll());
		
		System.out.println(sb.toString());
	}
}
