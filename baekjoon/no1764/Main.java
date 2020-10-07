package baekjoon.no1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> neverHeard = new HashSet<>();
		for (int i = 0; i < N; i++) {
			neverHeard.add(reader.readLine());
		}

		List<String> neverSeenAndHeard = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = reader.readLine();
			if (neverHeard.contains(name)) {
				neverSeenAndHeard.add(name);
			}
		}
		Collections.sort(neverSeenAndHeard);
		
		System.out.println(neverSeenAndHeard.size());
		for (int i = 0; i < neverSeenAndHeard.size(); i++)
			System.out.println(neverSeenAndHeard.get(i));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
