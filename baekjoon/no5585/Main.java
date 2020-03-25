package baekjoon.no5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.valueOf(reader.readLine());
		int charge = 1000 - money;
		int[] yenValues = new int[6];
		yenValues[0] = 500;
		yenValues[1] = 100;
		yenValues[2] = 50;
		yenValues[3] = 10;
		yenValues[4] = 5;
		yenValues[5] = 1;
		int count = 0;
		for (int i = 0; (i < yenValues.length) && (charge >= 0); i++) {
			while(charge / yenValues[i] > 0) {
				count = count + charge / yenValues[i];
				charge %= yenValues[i];
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.run();
	}

}
