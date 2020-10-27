package baekjoon.no11656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = reader.readLine();
		String[] suffixes = new String[input.length()];
		for (int i = 0; i < input.length(); i++) {
			suffixes[i] = input.substring(i);
		}
		Arrays.sort(suffixes);
		for (String suffix : suffixes) {
			writer.write(suffix + "\n");
		}
		
		writer.flush();
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
