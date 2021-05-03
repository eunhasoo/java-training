import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int round = 1;
        while (true) {
            kim = (kim + 1) / 2;
            lim = (lim + 1) / 2;

            if (kim == lim) break;

            ++round;
        }

        // 서로 대결하지 않는 경우는 존재하지 않으므로 무시해도 되는 조건이다
        System.out.println(round);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
