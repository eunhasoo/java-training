import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    int[] sour, bitter;
    int minDiff = 1000000000;

    public void selectMaterial(int idx, int sourSum, int bitterSum) {
        if (idx == N) {
            if (sourSum == 1 && bitterSum == 0) return;
            minDiff = Math.min(minDiff, Math.abs(sourSum - bitterSum));
            return;
        }

        selectMaterial(idx + 1, sourSum * sour[idx], bitterSum + bitter[idx]);
        selectMaterial(idx + 1, sourSum, bitterSum);
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        sour = new int[N]; // 신맛 (곱)
        bitter = new int[N];  // 쓴맛 (합)

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        selectMaterial(0, 1, 0);

        System.out.println(minDiff);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
