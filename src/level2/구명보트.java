/**
 * 
 */
package level2;

import java.util.Arrays;

/**
 * @author YSM
 *
 */
public class 구명보트 {
	public static void main(String[] args) {
		int people[] = {50,50,70,80};
		int limit = 100;
		
		Arrays.sort(people);
		
		int maxWeight = people.length-1; // 가장 무거운 사람
		int boatCnt = 0;
		int minWeight = 0; // 가장 가벼운 사람
		
		while(maxWeight >= minWeight) {
			int sum = people[maxWeight] + people[minWeight];
			if(sum <= limit) {
				maxWeight--;
				minWeight++;
				boatCnt++;
			} else {
				boatCnt++;
				maxWeight--;
			}
		}
		
		System.out.println(boatCnt);
	}
}
