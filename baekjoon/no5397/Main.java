import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public String getPassword(String s) {
        List<Character> result = new LinkedList<>();
        ListIterator<Character> iterator = result.listIterator();

        for (char cmd : s.toCharArray()) {
            if (cmd == '<') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
                continue;
            }

            if (cmd == '>') {
                if (iterator.hasNext()) {
                    iterator.next();
                }
                continue;
            }

            if (cmd == '-') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
                continue;
            }

            iterator.add(cmd);
        }

        StringBuilder builder = new StringBuilder();
        result.forEach(builder::append);
        return builder.toString();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (tc -- > 0) {
            String input = reader.readLine();
            builder.append(getPassword(input)).append("\n");
        }
        System.out.print(builder.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
