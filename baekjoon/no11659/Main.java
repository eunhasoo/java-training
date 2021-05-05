import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inputSum = new int[N + 1];

        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            inputSum[i] += Integer.parseInt(st.nextToken()) + inputSum[i - 1];
        }

        StringBuilder builder = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(reader.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            builder.append(inputSum[j] - inputSum[i - 1]).append("\n");
        }
        System.out.println(builder);
    }


    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
