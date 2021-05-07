import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> skills = new HashMap<>();
        int order = 0;
        for (char sk : skill.toCharArray()) {
            skills.put(sk, order++);
        }

        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            order = 0;

            for (char temp : skill_trees[i].toCharArray()) {
                if (!skills.containsKey(temp)) continue;
                
                // 스킬트리 순서 틀림 --> 반복 종료
                if (order != skills.get(temp)) {
                    order = -1;
                    break;
                }

                // 다음 스킬트리 인덱스로 갱신
                ++order;
            }
            if (order == -1) continue;

            ++answer;
        }

        return answer;
    }
}