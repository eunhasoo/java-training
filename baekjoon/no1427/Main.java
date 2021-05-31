import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Counting sort
public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        int[] numbers = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            numbers[n]++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (numbers[i] == 0) continue;

            for (int j = 0; j < numbers[i]; j++) {
                builder.append(i);
            }
        }
        System.out.println(builder);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
