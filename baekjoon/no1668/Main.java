import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] trophies = new int[N];
        for (int i = 0; i < N; i++) {
            trophies[i] = Integer.parseInt(reader.readLine());
        }

        int temp, left, right;
        left = right = 0;

        temp = 0;
        for (int i = 0; i < N; i++) {
            if (temp < trophies[i]) ++left;
            temp = Math.max(temp, trophies[i]);
        }

        temp = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (temp < trophies[i]) ++right;
            temp = Math.max(temp, trophies[i]);
        }

        System.out.println(left);
        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
