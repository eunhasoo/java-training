import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		for (String c[] : clothes) {
			String key = c[1]; // 옷의 이름 c[0]은 무시해도 된다
//			if (map.containsKey(key)) {
//				map.put(key, map.get(key) + 1);
//				continue;
//			}
//			map.put(key, 1);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int answer = 1;
		Set<String> keys = map.keySet();
		for (String key : keys) {
			answer = answer * (map.get(key) + 1); // 해당 종류마다 입지 않는 경우를 +1씩 추가
		}
		return (answer - 1); // 아무것도 입지 않는 경우 제외 -1
	}
}