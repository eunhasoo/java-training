package baekjoon.no2947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	StringBuilder builder;
	int[] arr = new int[5];
	
	public void print() {
		builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i]).append(' ');
		}
		System.out.println(builder);
	}
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(i, i + 1);
				print();
			}
		}
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				sort();
				return;
			}
		}
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sort();
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
