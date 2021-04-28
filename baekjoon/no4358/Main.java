import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> species = new TreeMap<>();
        int total = 0;
        while (true) {
            String treeName = reader.readLine();
            if (treeName == null || treeName.length() == 0) break;
            species.put(treeName, species.getOrDefault(treeName, 0) + 1);
            ++total;
        }

        print(species, total);
    }

    public void print(Map<String, Integer> species, int total) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> element : species.entrySet()) {
            String treeName = element.getKey();
            int count = element.getValue();
            float rate = (float) count * 100 / total;
            builder.append(treeName).append(' ').append(String.format("%.4f", rate)).append("\n");
        }

        System.out.print(builder);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
