package baekjoon.no2675;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st;
		while(N-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int count = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for(char c : s.toCharArray()) {
				for(int i=0; i<count; i++)
					System.out.printf("%c", c);
			}
			System.out.println();
		}
	}
}
