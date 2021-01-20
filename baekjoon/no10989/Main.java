package baekjoon.no10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MAXVALUE = 10000;
	
	public void countingSort(int[] arr) {
		int[] count = new int[MAXVALUE + 1];
		
		for (int i = 0; i < arr.length; i++) {
			++count[arr[i]];
		}
		
		int idx = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[idx++] = i;
			}
		}
	}
	
	public void print(int[] arr) {
		StringBuilder builder = new StringBuilder();
		for (int number : arr)
			builder.append(number).append("\n");
		System.out.print(builder);
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		
		countingSort(arr);
		
		print(arr);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
