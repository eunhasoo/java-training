import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String date = reader.readLine();
			
			int firstTwo = Integer.parseInt(date.substring(0, 2));
			int lastTwo = Integer.parseInt(date.substring(2, 4));
			
			boolean ftCheck = (firstTwo < 13 && firstTwo > 0) ? true : false;
			boolean ltCheck = (lastTwo < 13 && lastTwo > 0) ? true : false;
			
			String result = "";
			if (ftCheck && ltCheck) result = "AMBIGUOUS";
			else if (ftCheck) result = "MMYY";
			else if (ltCheck) result = "YYMM";
			else result = "NA";
			
			System.out.printf("#%d %s\n", test_case, result);
		}
	}

}
