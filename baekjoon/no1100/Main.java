package baekjoon.no1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int boardSize = 8;
		String[] chessBoard = new String[boardSize];
		for(int i = 0; i < chessBoard.length; i++) {
			chessBoard[i] = reader.readLine();
		}
		
		int count = 0;
		for (int i = 0; i < boardSize; i++) {
			int checkIdx = i % 2;
			
			while (checkIdx < boardSize) {
				if (chessBoard[i].charAt(checkIdx) == 'F') ++count;
				checkIdx += 2;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
