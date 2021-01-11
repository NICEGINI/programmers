package level3;
/**
 * 기둥 : 바닥 / 보의 한쪽 끝 / 또 다른 기둥 위만 설치 가능 
 * 보 : 한쪽 끝부분이 기둥 / 양쪽 끝 부분이 다른 보와 연결
 * build_frame의 원소 = {x, y, a, b} 
 * x : 가로 좌표
 * y : 세로 좌표 
 * a : 기둥 - 0 / 보 - 1 
 * b : 설치 - 1 / 파괴 - 0
 * 
 * 설치 지점 -> 설치 끝 지점 2좌표씩 차지하며 설치/제거 하면 될 거 같음
 */
public class 기둥과_보_설치 {
	static class Solution {
	    
	    static final int PILLAR = 0;
	    static final int BEAM = 1;
	    static final int DESTRUCT = 0;
	    static final int CONSTRUCT = 1;
	    
	    boolean[][] pillars, beams; // 기둥, 보
	    
	    public int[][] solution(int n, int[][] build_frame) {
	        int structureCount = 0;
	        
	        pillars = new boolean[n + 3][n + 3];
	        beams = new boolean[n + 3][n + 3];
	        
	        for(int[] frame : build_frame){
	            int x = frame[0] + 1;
	            int y = frame[1] + 1;
	            int structureType = frame[2];
	            int commandType = frame[3];
	            
	            if(commandType == CONSTRUCT){
	                if(structureType == PILLAR && canConstructPillar(x, y)){
	                    pillars[x][y] = true;
	                    structureCount++;
	                }
	                if(structureType == BEAM && canConstructBeam(x, y)){
	                    beams[x][y] = true;
	                    structureCount++;
	                }
	            } else if(commandType == DESTRUCT){
	                if(structureType == PILLAR){
	                    pillars[x][y] = false;
	                } else if(structureType == BEAM){
	                    beams[x][y] = false;
	                }
	 
	                if(canDestruct(x, y, structureType, n)){
	                    structureCount--;
	                    continue;
	                }
	                
	                if(structureType == PILLAR){
	                    pillars[x][y] = true;
	                } else if(structureType == BEAM){
	                    beams[x][y] = true;
	                }
	            }
	        }
	            
	            int index = 0;
	            int[][] answer = new int[structureCount][3];
	            
	            for(int i = 1 ; i <= n + 1 ; ++i){
	                for(int j = 1 ; j <= n + 1 ; ++j){
	                    if(pillars[i][j]) answer[index++] = new int[]{i - 1, j - 1, PILLAR};
	                    if(beams[i][j]) answer[index++] = new int[]{i - 1, j - 1, BEAM};
	                }
	            }
	            return answer;
	    }
	    
	    private boolean canConstructPillar(int x, int y){
	        return y == 1 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y];
	    }
	    
	    private boolean canConstructBeam(int x, int y){
	        return pillars[x][y - 1] || pillars[x + 1][y - 1] || (beams[x - 1][y] && beams[x + 1][y]);
	    }
	    
	    private boolean canDestruct(int x, int y, int structureType, int n){       
	        for(int i = 1 ; i <= n + 1 ; ++i){
	            for(int j = 1 ; j <= n + 1 ; ++j){
	                if(pillars[i][j] && !canConstructPillar(i, j)){
	                    return false;
	                }
	                if(beams[i][j] && !canConstructBeam(i, j)){
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }
	}

	public static void main(String[] args) {
		int n = 5;
		int build_frame[][] = { 
				{ 1, 0, 0, 1 }, 
				{ 1, 1, 1, 1 }, 
				{ 2, 1, 0, 1 }, 
				{ 2, 2, 1, 1 }, 
				{ 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, 
				{ 4, 2, 1, 1 }, 
				{ 3, 2, 1, 1 },

				/*
				 {0,0,0,1}, 
				 {2,0,0,1}, 
				 {4,0,0,1}, 
				 {0,1,1,1}, 
				 {1,1,1,1}, 
				 {2,1,1,1}, 
				 {3,1,1,1},
				 {2,0,0,0},
				 {1,1,1,0},
				 {2,2,0,1}
				 */
		};

		System.out.println(new Solution().solution(n, build_frame));
	}
}
