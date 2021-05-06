public class Solution {

    //         U - D - R - L
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    boolean[][][][] visited = new boolean[11][11][11][11];
    int curRow, curCol, firstSteppedCount;

    public void move(int order) {
        int rowTo = curRow + dr[order];
        int colTo = curCol + dc[order];

        if (rowTo < 0 || rowTo > 10 || colTo < 0 || colTo > 10) return;

        if (!visited[curRow][curCol][rowTo][colTo]) {
            visited[curRow][curCol][rowTo][colTo] = true;
            visited[rowTo][colTo][curRow][curCol] = true;
            ++firstSteppedCount;
        }

        curRow = rowTo;
        curCol = colTo;
    }

    public int solution(String dirs) {
        // 초기값 설정
        curRow = curCol = 5;
	firstSteppedCount = 0;

        int order;
        for (char dir : dirs.toCharArray()) {
            if (dir == 'U') order = 0;
            else if (dir == 'D') order = 1;
            else if (dir == 'R') order = 2;
            else order = 3;
            move(order);
        }

        return firstSteppedCount;
    }
}
