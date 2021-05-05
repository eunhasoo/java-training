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

        int[][] inputSum = new int[N + 1][N + 1];

	// [1,1]부터 [i,j]까지의 구간합 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                int input = Integer.parseInt(st.nextToken());
		// ex. [2,2] 구간합 = [1,2] 구간합 + [2,1] 구간합 - 중복(=[1,1]) 구간합 + 인풋값
                inputSum[i][j] = inputSum[i][j - 1] + inputSum[i - 1][j] - inputSum[i - 1][j - 1] + input;
            }
        }

        StringBuilder builder = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(reader.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

	    // ex. (2,3)~(3,4) 구간합 = [3,4] 구간합 - ([1,4] 구간합 + [3,2] 구간합)) + [1,2] 구간합
            int whole = inputSum[r2][c2];
            int rest = inputSum[r1 - 1][c2] + inputSum[r2][c1 - 1];
            int calcTwice = inputSum[r1 - 1][c1 - 1];
            int result = whole - rest + calcTwice;
            builder.append(result).append("\n");
        }
        System.out.print(builder);
    }


    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
