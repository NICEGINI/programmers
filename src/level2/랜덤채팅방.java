/**
 * 
 */
package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author YSM
 *
 */
public class 랜덤채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", 
						   "Enter uid4567 Prodo",
						   "Leave uid1234",
						   "Enter uid1234 Prodo",
						   "Change uid4567 Ryan"};
		
		int recordLength = record.length;
		HashMap<String, String> userNameMap = new HashMap<>();
		List<String> userActionList = new ArrayList<>();
        List<String> userIdList = new ArrayList<>();
		
        int resCnt = 0;
        
		StringTokenizer stt;
		for(int i = 0; i < recordLength; i++) {
			stt = new StringTokenizer(record[i], " ");
			String action = stt.nextToken();
			String userId = stt.nextToken();
			
			if(action.equals("Enter")) {
				String userName = stt.nextToken();
				userNameMap.put(userId, userName);
                userActionList.add(action);
			    userIdList.add(userId);
                resCnt++;
			} else if(action.equals("Change")) {
				String userName = stt.nextToken();
				userNameMap.put(userId, userName);
			} else { // Leave인 경우
                userActionList.add(action);
			    userIdList.add(userId);
                resCnt++;
            }
		} // input end
		
        String[] answer = new String[resCnt]; // Enter와 Leave인 경우만
		for(int i = 0; i < resCnt; i++) {
			String action = userActionList.get(i);
			String userId = userIdList.get(i);
			String userName = userNameMap.get(userId);
			
			if(action.equals("Enter")) {
				answer[i] = userName+"님이 들어왔습니다.";
			} else if(action.equals("Leave")){
				answer[i] = userName+"님이 나갔습니다.";
			}
		}
       // return answer;
	}
}
