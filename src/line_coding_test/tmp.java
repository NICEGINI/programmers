/**
 * 
 */
package line_coding_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author YSM
 *
 */
public class tmp {
	static class Solution {
	    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
	        // 각 규칙 저장
	    	HashMap<String, String> rule = new HashMap<String, String>();
	    	
	    	// 정해진 규칙을 해시로 저장
	        for(int i = 0; i < flag_rules.length; i++) {
	        	String[] rules = flag_rules[i].split(" ");
	        	String key = rules[0];
	        	String value = rules[1];
        		rule.put(key, value);
	        }
	        
	        // 성공 여부 판단
	        List<Boolean> success = new ArrayList<Boolean>();
	        
	        // 전체 명령어 순차 수행
	        for(int c = 0; c < commands.length; c++) {
	        	// 프로그램 이름, -명령어, 값, -명령어, 값 ....
	        	String[] command = commands[c].split(" ");
	        	
	        	// 진행 가능한지 불가능한지 판단하는 플래그
	        	boolean can_process = true;
	        	
	        	// 이름 같은지 부터 확인. 이름이 다르면 다음 명령어로
	        	if(!program.equals(command[0])) {
	        		success.add(false);
	        		continue;
	        	}
	        	
		        // 각 명령어들 확인. 명령어와 입력 형식이 다르면 다음 명령어로
	        	for(int i = 1; i < command.length; i = i+2) {
	        		String key = command[i]; // 명령어
	        		
	        		// 없는 명령어가 들어 온 경우 다음 명령어로
	        		if(!rule.containsKey(key)) {
	        			can_process = false;
	        			success.add(false);
	        			break;
	        		}
	        		
	        		// 있는 명령어라면
	        		String value;
	        		// NULL 명령어가 들어오면 뒤에 아무것도 오면 안된다
	        		if(key.equals("-e")) {
	        			// 명령어가 끝난경우
	        			if(i+1 == command.length) {
	        				break;
	        			} else { // 명령어가 남아 있는 경우
	        				value = command[i+1];
	        				// 값이 아니라 명령어가 들어온 경우
	        				if(rule.containsKey(value)) {
	        					// 다음 명령어가 유효한지 확인
	    	        			continue;
	    	        		} else {
	    	        			// 다른 명령어지만 없거나, 어쩌면 값이들어왔다면
	    	        			success.add(false);
	    	        			break;
	    	        		}
	        			}
	        		} // NULL 확인 끝
	        		value = command[i+1];
	        		
	        		// 현재 명령어의 타입을 알아낸다
	        		String type = rule.get(key);
	        		
	        		// 명령어의 값이 유효한지 확인
	        		for(int j = 0; j < value.length(); j++) {
	        			char input_char = value.charAt(j);
	        			boolean check = false;
	        			switch(type) {
	        				case "STRING":
	        					// 소문자 a~z, 대문자 A~Z 사이의 문자인지 확인
	        					if('a' <= input_char && input_char <= 'z'||
        						   'A' <= input_char && input_char <= 'Z') {
	        						check = true;
	        					} else {
	        						check = false;
	        					}
	        					break;
	        				case "NUMBER":
	        					if('0' <= input_char && input_char <= '9'){
	        						check = true;
	        					} else {
	        						check = false;
	        					}
	        					break;
	        				default:
	        					break;
	        			}
	        			if(!check) {
	        				can_process = false;
	        				success.add(false);
	        				break;
	        			}
	        		} // 명령어 값 유효 확인 끝
	        		
	        		if(!can_process) break;
	        	} // 명령어 확인 끝
                if(can_process) success.add(true);
		    } // 전체 명령어 끝
	        
	        boolean[] answer = new boolean[success.size()];
	        int idx = 0;
	        for(boolean res: success) {
	        	answer[idx++] = res;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String program = "line";
		String[] flag_rules = {
				"-s STRING", "-n NUMBER", "-e NULL"
		};
		String[] commands = {
				"line -s 123 -n HI", "line fun"
		};
		System.out.println(new Solution().solution(program, flag_rules, commands));
	}
}
