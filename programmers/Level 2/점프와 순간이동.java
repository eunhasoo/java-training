public class Solution {
    public int solution(int n) {
        int count = 0;
        while (n > 0) {
            count += (n % 2); // 점프
            n /= 2; // 순간이동
        }
        return count;
    }
}
