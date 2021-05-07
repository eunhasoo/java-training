public class Solution {

    public int solution(int money[]) {
        int[] dp1 = new int[money.length]; // 첫번째 집부터 선택 (연결된 마지막 집 제외)
        int[] dp2 = new int[money.length]; // 두번째 집부터 선택

        dp1[0] = dp1[1] = money[0];
        dp2[1] = money[1];

        int n = money.length - 1;
        for (int i = 2; i < n; i++) { // 마지막 집 전까지 반복
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }
        dp1[n] = Math.max(dp1[n - 1], dp1[n - 2]); // 마지막 집 무시하고 비교
        dp2[n] = Math.max(dp2[n - 1], dp2[n - 2] + money[n]); // 마지막 집 값까지 추가해서 비교

        return Math.max(dp1[n], dp2[n]);
    }
}
