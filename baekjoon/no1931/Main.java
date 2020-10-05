package baekjoon.no1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	class Conference implements Comparable<Conference> {
		int startTime, endTime;

		public Conference(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Conference c) {
			int e = this.endTime - c.endTime;
			return (e == 0) ? this.startTime - c.startTime : e;
		}
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		List<Conference> conferences = new ArrayList<>();
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			conferences.add(new Conference(startTime, endTime));
		}
		
		Collections.sort(conferences);
		
		int count = 0, lastEndTime = 0;
		for (int i = 0; i < conferences.size(); i++) {
			Conference conference = conferences.get(i);
			if (conference.startTime >= lastEndTime) {
				++count;
				lastEndTime = conference.endTime;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}
}
