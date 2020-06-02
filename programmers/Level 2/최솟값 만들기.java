import java.util.Arrays;

class Solution {

	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		int bStart = B.length - 1;
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[bStart - i];
		}
		return sum;
	}

}