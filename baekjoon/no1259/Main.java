package baekjoon.no1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			String input = reader.readLine();
			
			if (input.equals("0")) break;
			
			String reversed = new StringBuilder(input).reverse().toString();
			
			result.append(input.equals(reversed) ? "yes\n" : "no\n");
		}
		
		System.out.print(result);
	}

}
