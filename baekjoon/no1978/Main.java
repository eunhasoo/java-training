package baekjoon.no1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int primeNumCount(int[] inputNums) {
		// 0부터 inputNums의 마지막 인덱스에 들어있는 값까지의 소수를 구한다.
		int index = inputNums[inputNums.length - 1] + 1; 
		boolean isPrime[] = new boolean[index];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; (i * i) < isPrime.length; i++) {
			if (isPrime[i])
				for (int j = i * 2; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
		}
		
		int count = 0;
		for (int i = 0; i < inputNums.length; i++)
			if (isPrime[inputNums[i]]) ++count;
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(reader.readLine());
		int[] inputNums = new int[N];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < inputNums.length; i++)
			inputNums[i] = Integer.valueOf(st.nextToken());
		Arrays.sort(inputNums);
		System.out.println(primeNumCount(inputNums));
	}

}
