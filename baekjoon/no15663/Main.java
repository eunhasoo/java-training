import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N, M;
    int[] numbers, selected;
    boolean[] visited;
    Set<String> checker = new LinkedHashSet<>();

    public void dfs(int depth) {
        if (depth == M) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < M; i++) {
                builder.append(selected[i]).append(' ');
            }
            checker.add(builder.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = numbers[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0);

        for (String sequence : checker) {
            System.out.println(sequence);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}