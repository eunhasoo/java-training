// 백준 1302

package baekjoon.no1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		int N = Integer.parseInt(reader.readLine());
		while (N-- > 0) {
			String s = reader.readLine();
			if (map.containsKey(s)) {
				int value = map.get(s);
				map.replace(s, value, value + 1);
				continue;
			}
			map.put(s, 1);
		}
		int maxValueInMap = (Collections.max(map.values()));
		for (Entry<String, Integer> entry : map.entrySet())
			if (entry.getValue() == maxValueInMap) {
				System.out.println(entry.getKey());
				break;
			}
	}

}
