import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        // A의 출전순서가 정해진 것은 B의 출전순서를 고르는 데에 의미없는 정보이므로 정렬하여 비교한다.
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int selectedIdx = A.length - 1;
        for (int round = A.length - 1; round >= 0; round--) {
            if (A[round] < B[selectedIdx]) {
                ++answer;
                --selectedIdx;
            }
        }

        return answer;
    }
}