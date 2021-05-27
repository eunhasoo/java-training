import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // Stack을 활용한 풀이

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            String input = reader.readLine();

            // 커서를 중심으로 left와 right로 나눈다
            ArrayDeque<Character> left = new ArrayDeque<>();
            ArrayDeque<Character> right = new ArrayDeque<>();

            // 문자 입력과 삭제는 left에서만 이루어진다
            for (char c : input.toCharArray()) {
                if (c == '-') {
                    if (left.isEmpty()) continue;
                    left.pop();
                } else if (c == '<') {
                    if (left.isEmpty()) continue;
                    right.push(left.pop());
                } else if (c == '>') {
                    if (right.isEmpty()) continue;
                    left.push(right.pop());
                } else {
                    left.push(c);
                }
            }

            StringBuilder builder = new StringBuilder();
            while (!left.isEmpty()) {
                builder.append(left.removeLast());
            }
            while (!right.isEmpty()) {
                builder.append(right.removeFirst()); // == right.pop()
            }
            result.append(builder).append("\n");
        }

        System.out.print(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
