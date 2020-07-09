import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	
    public String[] solution(String[] record) {
        List<String> messages = new ArrayList<>(); // 유저ID와 메시지(Enter, Leave만) 저장
        Map<String, String> userStates = new HashMap<>(); // 유저ID와 닉네임 저장
        String[] answer;
        
        userStates.put("Enter", "님이 들어왔습니다.");
        userStates.put("Leave", "님이 나갔습니다.");
        
        for (int i = 0; i < record.length; i++) {
        	String[] state = record[i].split(" ");
        	if (!state[0].equals("Change"))
        		messages.add(state[1] + " " + state[0]); // "유저ID 상태메시지"
        	if (state[0].equals("Leave"))
        		continue;
        	userStates.put(state[1], state[2]); // 유저ID, 닉네임
        }
        
        answer = new String[messages.size()];
        for (int i = 0; i < answer.length; i++) {
        	String[] user = messages.get(i).split(" ");
        	answer[i] = userStates.get(user[0]) + userStates.get(user[1]);
        }
        
        return answer;
    }
}