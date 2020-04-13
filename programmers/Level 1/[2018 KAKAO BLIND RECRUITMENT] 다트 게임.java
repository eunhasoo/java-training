class Solution {
	public int solution(String dartResult) {
		int[] scores = new int[3];
		int time = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			System.out.println(i);
			char c1 = dartResult.charAt(i);
			switch (c1) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				if (c1 == '1' && dartResult.charAt(i + 1) == '0') {
					scores[time] = 10;
					i += 1;
				} else {
					scores[time] = c1 - '0';
				}
				break;
			case 'S':
				scores[time] = (int) Math.pow(scores[time], 1);
				time++;
				break;
			case 'D':
				scores[time] = (int) Math.pow(scores[time], 2);
				time++;
				break;
			case 'T':
				scores[time] = (int) Math.pow(scores[time], 3);
				time++;
				break;
			case '*':
				if (time >= 2) {
					scores[time - 2] = scores[time - 2] * 2;
				}
				scores[time - 1] = scores[time - 1] * 2;
				break;
			case '#':
				scores[time - 1] = scores[time - 1] * (-1);
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < scores.length; i++)
			sum += scores[i];
		System.out.println(sum);
		return sum;
	}
}