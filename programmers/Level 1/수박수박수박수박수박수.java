class Solution {
  public String solution(int n) {
      StringBuilder sb = new StringBuilder();
      boolean flag = false;
      for(int i=0; i<n; i++) {
          if (flag == false) {
              sb.append("수");
              flag = true;
          } else {
              sb.append("박");
              flag = false;
          }
      }
      return sb.toString();
  }
}