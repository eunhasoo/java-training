import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String S, T;

    public void operation(String temp) {
        if (temp.equals(S)) { // 탐색 성공 및 프로그램 종료
            System.out.println(1);
            System.exit(0);
        }
        // 길이가 S보다 적은 경우 중단
        if (temp.length() < S.length()) return;
        // 1)이나 2)를 작업할 수 없는 경우 중단
        if (temp.charAt(0) == 'A' && temp.charAt(temp.length() - 1) == 'B') return;

        int last = temp.length() - 1;
        if (temp.charAt(last) == 'A') { // 1) A를 뺀다
            operation(temp.substring(0, last));
        }
        if (temp.charAt(0) == 'B') { // 2)  뒤집은 뒤 B를 뺀다
            String reversed = new StringBuilder(temp).reverse().toString();
            operation(reversed.substring(0, last));
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        S = reader.readLine();
        T = reader.readLine();

        // S -> T를 만들어가는 것은 시간초과. T -> S 만드는 과정을 찾아야 함
        operation(T);

        System.out.println(0); // 탐색 실패
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
