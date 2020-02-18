class Solution {
  public long solution(int a, int b) {
        int big = (a > b) ? a : b;
        int small = (a < b) ? a : b;
        long sum = 0;
        for(int i = small; i <= big; i++) 
            sum += i;
        return sum;
  }
}