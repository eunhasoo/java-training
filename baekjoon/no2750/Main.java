package baekjoon.no2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> numbers = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		int N = Integer.valueOf(reader.readLine());
		while(N-- > 0) {
			int number = Integer.valueOf(reader.readLine());
			if (!numbers.contains(number))
				numbers.add(number);
		}
		Collections.sort(numbers);
		for(int i=0; i<numbers.size(); i++)
			builder.append(numbers.get(i)+"\n");
		System.out.print(builder);
	}

}
