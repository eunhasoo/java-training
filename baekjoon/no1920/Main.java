import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        Set<Integer> nums = new HashSet<>();
        StringBuilder result = new StringBuilder();

        n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (nums.contains(num)) {
                result.append("1\n");
            } else {
                result.append("0\n");
            }
        }

        System.out.print(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
