/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class _2개이하로다른비트 {
	static class Solution {
	    public long[] solution(long[] numbers) {
	        long[] answer = new long[numbers.length];
	        for(int i = 0; i < numbers.length; i++) {
	        	answer[i] = diffBit(numbers[i]);
	        }
	        return answer;
	    }

		private long diffBit(long number) {
			String binary = "0" + Long.toBinaryString(number);
			StringBuilder res = new StringBuilder(binary);
			
			int lastZeroIdx = res.lastIndexOf("0"); // 가장 마지막 0의 위치
			res.setCharAt(lastZeroIdx, '1'); // 1로 변경
			if(!isEven(number)) { // 홀수
				// 가장 처음 나온 0 자리의 다음 자리부터 검색
				res.setCharAt(res.indexOf("1", lastZeroIdx+1), '0'); // 0으로 변경
			}
			
			return convertBinaryToDecimal(res.toString());
		}

		private long convertBinaryToDecimal(String binary) {
			return Long.parseLong(binary,2);
		}

		private boolean isEven(long number) {
			return number %2 == 0 ? true : false;
		}
	}
	public static void main(String[] args) {
		long[] numbers = {2, 7};
		System.out.println(new Solution().solution(numbers));
	}
}
