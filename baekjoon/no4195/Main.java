import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Union-Find
public class Main {

    int[] parent;
    int[] number;

    // 어떤 집합에 포함되어 있는지 찾기
    public int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 집합 합치기
    public int union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            parent[y] = x;
            number[x] += number[y];
        }

        return number[x];
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(reader.readLine());
        while (tc-- > 0) {
            Map<String, Integer> network = new HashMap<>();
            StringBuilder builder = new StringBuilder();

            int f = Integer.parseInt(reader.readLine());

            parent = new int[f * 2];
            number = new int[f * 2];

            for (int i = 0; i < 2 * f; i++) {
                parent[i] = i;
                number[i] = 1;
            }

            int idx = 0;
            for (int i = 0; i < f; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!network.containsKey(a)) network.put(a, idx++);
                if (!network.containsKey(b)) network.put(b, idx++);

                builder.append(union(network.get(a), network.get(b))).append("\n");
            }

            System.out.print(builder);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
