package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	int n, k;
	int[] cards;
	boolean[] isPicked;
	Set<String> numbers = new HashSet<>();
	
	void makeNumber(String number, int count) {
		if (count == k) {
			numbers.add(number);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isPicked[i]) continue;
			
			isPicked[i] = true;
			makeNumber(number + cards[i], count + 1);
			isPicked[i] = false;
		}
	}

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		k = Integer.parseInt(reader.readLine());
		
		cards = new int[n];
		isPicked = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(reader.readLine());
		}
		
		makeNumber("", 0);
		
		System.out.println(numbers.size());
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
