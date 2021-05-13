import java.util.*;

public class Solution {
    Map<Integer, Map<String, Integer>> ordersByCount = new HashMap<>();

    public String[] solution(String[] orders, int[] counts) {
        // 코스 요리 수를 key로 갖는 주문 조합과 개수 저장용 Map 생성
        for (int count : counts) {
            ordersByCount.put(count, new HashMap<>());
        }

        // 주문마다 조합의 개수를 Map에 저장
        for (String order : orders) {
            char[] currentOrder = order.toCharArray();
            Arrays.sort(currentOrder);
            perm(0, currentOrder, "");
        }

        // Map을 돌면서 최소 2개 이상의 최대 주문 수를 가진 조합을 찾아 저장
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Map<String, Integer>> current : ordersByCount.entrySet()) {
            List<Map.Entry<String, Integer>> courses = new ArrayList<>(current.getValue().entrySet());
            if (courses.size() == 0) continue;

            courses.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            int maxOrderedCount = courses.get(0).getValue();
            if (maxOrderedCount < 2) continue;

            for (Map.Entry<String, Integer> course : courses) {
                if (course.getValue() < maxOrderedCount) break;
                result.add(course.getKey());
            }
        }

        Collections.sort(result);

        String[] answer = new String[result.size()];
        return result.toArray(answer);
    }

    public void perm(int idx, char[] order, String res) {
        if (ordersByCount.containsKey(res.length())) {
            int count = ordersByCount.get(res.length()).getOrDefault(res, 0);
            ordersByCount.get(res.length()).put(res, count + 1);
        }

        for (int i = idx; i < order.length; i++) {
            perm(i + 1, order, res + order[i]);
        }
    }
}