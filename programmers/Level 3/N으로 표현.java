public class Solution {
    int N, number, answer;

    public void dfs(int current, int count) {
        if (count > 8) return;
        if (current == number) {
            answer = Math.min(count, answer);
            return;
        }

        int c = 0;
        for (int i = 0; i < 5; i++) {
            c = c * 10 + N;

            dfs(current + c, count + 1 + i);
            dfs(current - c, count + 1 + i);
            dfs(current / c, count + 1 + i);
            dfs(current * c, count + 1 + i);
        }
    }

    public int solution(int n, int num) {
        N = n;
        number = num;
        answer = 9;

        dfs(0, 0);

        return (answer == 9) ? -1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(
            new Solution().solution(5, 12)
        );
    }
}
