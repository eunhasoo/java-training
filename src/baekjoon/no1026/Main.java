// 백준 1026

package baekjoon.no1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		List<Integer> A = new ArrayList<>(N);
		List<Integer> B = new ArrayList<>(N);
		for(int i=0; i<N; i++)
			A.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++)
			B.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(A);
		Collections.sort(B, (n1, n2) -> n2 - n1);
		
		int result = 0;
		for(int i=0; i<N; i++)
			result += A.get(i) * B.get(i);
		System.out.println(result);
	}

}
