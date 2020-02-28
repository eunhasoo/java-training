package baekjoon.no11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate> {
	private int x, y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public int compareTo(Coordinate c) {
		int r = this.getX() - c.getX();
		if (r == 0)
			r = this.getY() - c.getY();
		return r;
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y + "\n";
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Coordinate> coordiList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		StringTokenizer st;
		int N = Integer.valueOf(reader.readLine());
		while(N-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			coordiList.add(new Coordinate(x, y));
		}
		Collections.sort(coordiList);
		for(int i=0; i<coordiList.size(); i++)
			builder.append(coordiList.get(i));
		System.out.print(builder);
	}

}
