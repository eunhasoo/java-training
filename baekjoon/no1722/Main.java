import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    long[] factorial = new long[21];
    boolean[] selected = new boolean[21];

    public void makeFactorial() {
        factorial[0] = 1;
        for (int i = 1; i < 21; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public void findKthSequence(long k) {
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (selected[j]) continue;

                if (factorial[N - i - 1] < k) {
                    k -= factorial[N - i - 1];
                } else {
                    sequence[i] = j;
                    selected[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", sequence[i]);
        }
    }

    public void findNumberK(int[] sequence) {
        long k = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < sequence[i]; j++) {
                if (selected[j]) continue;

                k += factorial[N - i - 1];
            }
            selected[sequence[i]] = true;
        }
        System.out.println(k);
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());

        makeFactorial();

        st = new StringTokenizer(reader.readLine());
        int subProblemNo = Integer.parseInt(st.nextToken());
        if (subProblemNo == 1) {
            // k번째 수열 구하기
            long k = Long.parseLong(st.nextToken());
            findKthSequence(k);
        } else {
            // 주어진 수열이 몇 번째 수열인지 구하기
            int[] sequence = new int[N];
            for (int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }
            findNumberK(sequence);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
