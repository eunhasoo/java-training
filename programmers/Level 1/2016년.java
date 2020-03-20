class Solution {
	public String solution(int a, int b) {
		int totalDay = 0;

		while (--a > 0) { // (a-1)월 b일까지의 전체 일수 구하기
			switch (a) {
			case 2:
				totalDay += 29;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				totalDay += 30;
				break;
			default:
				totalDay += 31;
				break;
			}
		}
		totalDay += b; // 구하고자 하는 달의 일수 더하기

		String answer = "";
		switch (totalDay % 7) {
		case 0:
			answer = "THU";
			break;
		case 1:
			answer = "FRI";
			break;
		case 2:
			answer = "SAT";
			break;
		case 3:
			answer = "SUN";
			break;
		case 4:
			answer = "MON";
			break;
		case 5:
			answer = "TUE";
			break;
		case 6:
			answer = "WED";
			break;
		}

		return answer;
	}
}