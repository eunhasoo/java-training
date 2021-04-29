import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int n, answer;
    int[] numbers, selected;
    boolean[] visited;

    public int getResult() {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += Math.abs(selected[i] - selected[i + 1]);
        }
        return result;
    }

    public void dfs(int depth) {
        if (depth == n) {
            answer = Math.max(answer, getResult());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        numbers = new int[n];
        selected = new int[n]; // 순열로 순서가 바뀐 numbers 임시 저장
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers); // 순열을 위해 정렬

        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
