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
public class CLI_Flag_validator {
	static class Solution {
	    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
	        // 각 규칙 저장
	    	HashMap<String, String> rule = new HashMap<String, String>();
	    	
	    	// 정해진 규칙을 해시로 저장
	    	makeRule(rule, flag_rules);
	    	
	        // 성공 여부 판단
	        List<Boolean> success = new ArrayList<Boolean>();
	        
	        // 전체 명령어 순차 수행
	        process_all_commands(program, rule, commands, success);
	        
	        // 값을 옮겨준다
	        boolean[] answer = new boolean[success.size()];
	        int idx = 0;
	        for(boolean res: success) {
	        	answer[idx++] = res;
	        }
	        // 리턴
	        return answer;
	    }

		/** @param rule*/
		private void process_all_commands(String program, HashMap<String, String> rule, String[] commands, List<Boolean> success) {
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
	        	int command_idx = 1;
	        	while(command_idx < command.length) {
	        		String key = command[command_idx]; // 명령어
	        		
	        		// 없는 명령어가 들어 온 경우 다음 명령어로
	        		can_process = check_rule(rule, key);
	        		if(!can_process) {
	        			success.add(false);
	        			break;
	        		}
	        		
	        		// NULL 명령어가 들어오면 뒤에 아무것도 오면 안된다
	        		if(key.equals("-e")) {
	        			// 명령어가 끝난경우
	        			if(command_idx+1 == command.length) {
	        				break;
	        			} else { // 명령어가 남아 있는 경우
	        				String value = command[command_idx+1];
	        				// 값이 아니라 명령어가 들어온 경우
	        				if(rule.containsKey(value)) {
	        					// 다음 명령어가 유효한지 확인
	        					command_idx++;
	    	        			continue;
	    	        		} else {
	    	        			// 다른 명령어지만 없거나, 어쩌면 값이들어왔다면
	    	        			command_idx++;
	    	        			success.add(false);
	    	        			break;
	    	        		}
	        			}
	        		} // NULL 확인 끝
	        		
	        		// 여러 값의 갯수 확인
	        		String value;
	        		int value_cnt = 0;
	        		for(int i = command_idx+1; i < command.length; i++) {
	        			value = command[i];
	        			value_cnt++;
	        			if(rule.containsKey(value)) {
	        				break;
	        			}

		        		// 현재 명령어의 타입을 알아낸다
		        		String type = rule.get(key);
		        		if(type.equals("NUMBER") || type.equals("STRING")) {
		        			if(value_cnt > 1) {
		        				can_process = false;
		        				success.add(false);
		        				break;
		        			}
		        		}
		        		// 값이 유효한지 확인
		        		can_process = check_value(type, value, success);
		        		if(!can_process) break;
	        		} // 여러 명령어 값 유효 확인
	        		
	        		if(!can_process) break;
	        		else {
	        			command_idx += value_cnt;
	        		}
	        	} // 명령어 확인 끝
	        	if(can_process) success.add(true);
		    } // 전체 명령어 끝
			
		}
		
		/** 값의 유효성 확인 */
		private boolean check_value(String type, String value, List<Boolean> success) {
			// 명령어의 값이 유효한지 확인
    		for(int j = 0; j < value.length(); j++) {
    			char input_char = value.charAt(j);
    			boolean check = false;
    			switch(type) {
    				case "STRINGS":
    				case "STRING":
    					// 소문자 a~z, 대문자 A~Z 사이의 문자인지 확인
    					if('a' <= input_char && input_char <= 'z'||
						   'A' <= input_char && input_char <= 'Z') {
    						check = true;
    					} else {
    						check = false;
    					}
    					break;
    				case "NUMBERS":
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
    				success.add(false);
    				return false;
    			}
    		} // 명령어 값 유효 확인 끝
    		return true;
		}

		/** 규칙 체크, 있으면 true 리턴, 없으면 false 리턴 */
		private boolean check_rule(HashMap<String, String> rule, String key) {
			return rule.containsKey(key);
		}

		/** 규칙을 만든다 */
		private void makeRule(HashMap<String, String> rule, String[] flag_rules) {
			for(int i = 0; i < flag_rules.length; i++) {
	        	String[] rules = flag_rules[i].split(" ");
	        	String key = rules[0];
	        	String value = rules[1];
        		rule.put(key, value);
	        }
		}
	}
	public static void main(String[] args) {
		String program = "trip";
		String[] flag_rules = {
				"-days NUMBERS", "-dest STRING"
		};
		String[] commands = {
				"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"
		};
		System.out.println(new Solution().solution(program, flag_rules, commands));
	}
}
