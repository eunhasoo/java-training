package baekjoon.no1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		List<Integer> list = new ArrayList<>();
		int index = 0;
		for(int i=1; i<=N; i++)
			list.add(i);
		sb.append("<");
		while(list.size() > 0) {
			index = (index + (K-1)) % list.size();
			sb.append(list.remove(index));
			if (list.size() == 0)
				sb.append(">");
			else sb.append(", ");
		}
		System.out.println(sb);
	}

}
