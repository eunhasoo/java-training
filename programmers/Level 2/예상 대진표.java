public class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;
        while (true) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);

            if (a == b) break;
            ++round;
        }

        return round;
    }

    public static void main(String[] args) {
        int r = new Solution().solution(8, 4, 7);
        System.out.println(r);
    }
}