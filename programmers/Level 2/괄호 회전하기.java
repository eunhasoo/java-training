import java.util.ArrayDeque;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        int index = 1;
        while (index <= s.length()) {
            String str = s.substring(index) + s.substring(0, index);
            if (isValid(str)) {
                ++answer;
            }

            ++index;
        }

        return answer;
    }

    boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) return false;

            if (c == '}' && stack.pop() != '{') return false;
            if (c == ']' && stack.pop() != '[') return false;
            if (c == ')' && stack.pop() != '(') return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new Solution().solution("[");
    }
}
