package baekjoon.no2577;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] nums = new int[10];
		int sum = 1;
		for(int i=0; i<3; i++)
			sum *= scan.nextInt();
		String s = String.valueOf(sum);
		for(char ch : s.toCharArray()) {
			switch (Character.getNumericValue(ch)) {
			case 0: nums[0]++; break;
			case 1: nums[1]++; break;
			case 2: nums[2]++; break;
			case 3: nums[3]++; break;
			case 4: nums[4]++; break;
			case 5: nums[5]++; break;
			case 6: nums[6]++; break;
			case 7: nums[7]++; break;
			case 8: nums[8]++; break;
			case 9: nums[9]++; break;
			}
		}
		for(int i=0; i<nums.length; i++)
			sb.append(nums[i]+"\n");
		System.out.println(sb);
	}
}
