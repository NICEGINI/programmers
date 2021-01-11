/**
 * 
 */
package level2;

/**
 * @author YSM
 *
 */
public class 방금그곡 {
	static class Solution {
	    public String solution(String m, String[] musicinfos) {
	    	m = replaceSharpCord(m);
	    	String answer = "";
	    	int maxLength = 0;
	    	for(int i = 0; i < musicinfos.length; i++) {
	    		String musicinfo[] = musicinfos[i].split(","); // 전체 음악 정보

	    		// -- 음원 이름 반복 음원 -- //
	    		String title = musicinfo[2];
	    		String music = replaceSharpCord(musicinfo[3]);
	    		StringBuilder loopedMusic = new StringBuilder();
	    				
	    		// -- 플레이 타임 계산 -- //
	    		int hDiff = Integer.parseInt(musicinfo[1].split(":")[0]) - Integer.parseInt(musicinfo[0].split(":")[0]);
	    		int mDiff = Integer.parseInt(musicinfo[1].split(":")[1]) - Integer.parseInt(musicinfo[0].split(":")[1]);
	    		
	    		int totalPlayTime = hDiff*60 + mDiff;
	    		
	    		// -- 시간만큼 반복 된 음원 확보 -- # 다시 생각해서 만들기 //
	    		for(int j = 0; j < totalPlayTime; j++) {
	    			loopedMusic.append(music.charAt(j%music.length()));
	    		}
	    		
	    		music = loopedMusic.toString();
	    		
	    		int musicLength = music.length();
	    		
    			if(music.contains(m)) {
    				if(maxLength < musicLength) {
    					answer = title;
    					maxLength = musicLength;
    				}
    			}
    		}
	    	if(answer == "") answer = "(None)";
	        return answer;
	    }
	    
	    private static String replaceSharpCord(String m) {
	        return m.replace("C#", "c")
	                .replace("D#", "d")
	                .replace("E#", "e")
	                .replace("F#", "f")
	                .replace("G#", "g")
	                .replace("A#", "a");
	    }
	}
	
	public static void main(String[] args) {
		String m = "ABC";
		String musicinfos[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(new Solution().solution(m, musicinfos));
	}
}
