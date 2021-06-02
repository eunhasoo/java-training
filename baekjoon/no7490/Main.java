import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    StringBuilder builder;

    public void calc(int sign, int sum, int temp, int seqNum, String exp) {
        if (seqNum == N) {
            if (sum + (temp * sign) == 0) {
                builder.append(exp).append("\n");
            }
            return;
        }

        // 수 이어붙이기 연산
        calc(sign, sum, (temp * 10) + (seqNum + 1), seqNum + 1, exp + ' ' + (seqNum + 1));

        // 더하기 연산
        calc(1, sum + (temp * sign), seqNum + 1, seqNum + 1, exp + '+' + (seqNum + 1));

        // 빼기 연산
        calc(-1, sum + (temp * sign), seqNum + 1, seqNum + 1, exp + '-' + (seqNum + 1));
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(reader.readLine());
        while (TC-- > 0) {
            N = Integer.parseInt(reader.readLine());
            builder = new StringBuilder();

            calc(1, 0, 1, 1, "1"); // 수식이 빈값이 아닌 "1"부터 시작해야함

            System.out.println(builder);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
