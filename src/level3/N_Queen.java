/**
 * 
 */
package level3;

/**
 * @author YSM
 *
 */
public class N_Queen {
	static class Solution {
		private static int cntMax; 
	    public int solution(int n) {
	    	
	    	int[] col = new int[n+1];
	    	setQueen(1, col, n);
	        int answer = cntMax;
	        return answer;
	    }
	    
		private void setQueen(int idx, int[] col, int size) {
			if(idx > size) {
				cntMax++;
				return;
			}
			for(int i = 1; i <= size; i++) {
				col[idx] = i;
				if(checking(idx, col)) {
					setQueen(idx+1, col, size);
				}
			}
		}
		private boolean checking(int idx, int[] col) {
			for(int i = 1; i < idx; i++) {
				// 같은 직선라인 혹은 대각라인에 있는지 체크
				if(col[idx] == col[i] || Math.abs(col[idx] - col[i]) == idx - i) return false;
			}
			
			return true;
		}
	}
	public static void main(String[] args) {
		int n = 4;
		System.out.println(new Solution().solution(n));
	}
}
