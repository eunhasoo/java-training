import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    boolean[] visited;
    int[] output;
    StringBuilder builder = new StringBuilder();

    public void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                builder.append(output[i]).append(' ');
            }
            builder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        output = new int[N];
        visited = new boolean[N + 1];

        dfs(0);

        System.out.print(builder);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}