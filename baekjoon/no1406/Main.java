package baekjoon.no1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Character> list = new LinkedList<>(); // ArrayList를 사용하면 시간초과에 걸린다!
		StringTokenizer st;

		String s = reader.readLine();
		for (char c : s.toCharArray())
			list.add(c);
		int M = Integer.valueOf(reader.readLine());		
		ListIterator<Character> iterator = list.listIterator(list.size()); 
		// 커서를 문장의 맨 뒤에 위치시키기 위해 iterator 생성자의 파라미터로 시작할 커서의 인덱스를 지정해줘야 한다
		
		while (M-- > 0) {
			st = new StringTokenizer(reader.readLine());
			switch (st.nextToken()) {
			case "P":
				iterator.add(st.nextToken().charAt(0));
				break;
			case "L":
				if (iterator.hasPrevious())
					iterator.previous();
				break;
			case "D":
				if (iterator.hasNext())
					iterator.next();
				break;
			case "B":
				if (iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();
				}
				break;
			}
		}
		
		for(char c : list)
			sb.append(c);
		System.out.println(sb);
	}

}
