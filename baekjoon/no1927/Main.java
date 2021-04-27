import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            int num = Integer.parseInt(reader.readLine());

            if (num > 0) {
                minHeap.add(num);
                continue;
            }

            builder.append(minHeap.isEmpty() ? 0 : minHeap.remove()).append("\n");
        }

        System.out.print(builder);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}