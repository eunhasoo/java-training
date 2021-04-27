import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    class Jewelry {
        int weight;
        int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Jewelry> jewelries = new ArrayList<>(n);
        List<Integer> backpacks = new ArrayList<>(k);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewelries.add(new Jewelry(weight, value));
        }

        for (int i = 0; i < k; i++) {
            backpacks.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(jewelries, Comparator.comparingInt(j -> j.weight));
        Collections.sort(backpacks);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        long valueSum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            for (int j = idx; j < n; j++) {
                if (backpacks.get(i) >= jewelries.get(j).weight) {
                    queue.add(jewelries.get(j).value);
                    ++idx;
                } else {
                    break;
                }
            }

            if (!queue.isEmpty()) {
                valueSum += queue.remove();
            }
        }

        System.out.println(valueSum);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}