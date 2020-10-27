package baekjoon.no10867;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public void run_v1() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> checker = new HashSet<>();
		List<Integer> numbers = new ArrayList<>();
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (checker.add(number)) numbers.add(number);
		}
		Collections.sort(numbers);
		numbers.stream().forEach((num) -> System.out.print(num + " "));
	}

	public void run_v2() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int[] numbers = new int[2001];
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			numbers[number + 1000]++;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0) writer.write(i - 1000 + " ");
		}
		writer.flush();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		new Main().run_v1();
		new Main().run_v2();
	}

}
