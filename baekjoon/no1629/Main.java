import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(calc(A, B, C));
    }

    // A^n * A^n = A^2n을 이용한다
    public long calc(int A, int B, int C) {
        if (B == 1) return A % C;

        long val = calc(A, B / 2, C);
        val = (val * val) % C;

        return (B % 2 == 0) ? val : (val * A) % C;
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
