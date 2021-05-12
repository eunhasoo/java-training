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

        int result = 0;
        while (true) {
            if (B == A) break;
            if (B < A) {
                result = -2;
                break;
            }

            if (B % 10 == 1) {
                B = B / 10;
            } else if (B % 2 == 0) {
                B = B / 2;
            } else {
                result = -2;
                break;
            }
            ++result;
        }

        System.out.println(result + 1);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
