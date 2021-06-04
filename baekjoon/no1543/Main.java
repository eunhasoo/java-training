import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String doc = reader.readLine();
        String word = reader.readLine();

        int index = 0;
        int count = 0;

        while (doc.length() - index >= word.length()) {
            if (doc.substring(index, index + word.length()).equals(word)) {
                index += word.length();
                ++count;
            } else {
                index += 1;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
