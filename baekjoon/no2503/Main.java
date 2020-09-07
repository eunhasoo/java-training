package baekjoon.no2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public boolean isValidNumber(String num) {
		return ( 
			(num.charAt(0) != num.charAt(1) 
				&& num.charAt(1) != num.charAt(2) 
				&& num.charAt(2) != num.charAt(0))
			&& (num.indexOf("0") == -1)
		);
	}

	public int solution(int[][] baseball) {
		int answer = 0;
		for (int i = 123; i <= 987; i++) {
			String temp = i + "";

			if (!isValidNumber(temp)) { // 0을 포함하지 않고 각 자릿수가 다른 숫자인지 체크
				continue;
			}

			for (int j = 0; j < baseball.length; j++) {
				String qNum = baseball[j][0] + "";
				
				// 스트라이크, 볼 체크
				int ball = 0, strike = 0;
				for (int k = 0; k < baseball[0].length; k++) {
					if (qNum.charAt(k) == temp.charAt(k)) { 
						++strike;
					} else if (qNum.indexOf(temp.charAt(k)) != -1 && qNum.indexOf(temp.charAt(k)) != k) {
						++ball;
					}
				}
				if (strike != baseball[j][1] || ball != baseball[j][2]) { // 결과가 다르면 비교 중단
					break;
				}
				
				if (j == baseball.length - 1) {
					++answer;
				}
			}
		}
		
		return answer;
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] baseball = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			baseball[i][0] = Integer.parseInt(st.nextToken()); // 세 자리 수
			baseball[i][1] = Integer.parseInt(st.nextToken()); // 스트라이크 수
			baseball[i][2] = Integer.parseInt(st.nextToken()); // 볼 수
		}
		System.out.println(solution(baseball));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
