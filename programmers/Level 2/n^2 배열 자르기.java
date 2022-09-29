public class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        long pos = left;
        for (int idx = 0; idx < answer.length; idx++) {
            // (i x j) = max(i, j) => (4 x 3) = max(4, 3)
            long i = (pos / n) + 1;
            long j = (pos % n) + 1;

            answer[idx] = (int) Math.max(i, j);
            ++pos;
        }

        return answer;
    }
}
