import java.util.ArrayList;
import java.util.List;

class Solution {

	class Path {
		int from;
		int to;
		
		public Path(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	List<Path> paths;	

	public void hanoi(int N, int start, int to, int via) {
		if (N == 1) {
			paths.add(new Path(start, to));
		} else {
			hanoi(N-1, start, via, to);
			paths.add(new Path(start, to));
			hanoi(N-1, via, to, start);
		}
	}
	
    	public int[][] solution(int N) {
    		paths = new ArrayList<>();
    		hanoi(N, 1, 3, 2);
        	int[][] answer = new int[paths.size()][2];
        	for (int i = 0; i < paths.size(); i++) {
        		Path path = paths.get(i);
        		answer[i][0] = path.from;
        		answer[i][1] = path.to;
        	}
        	return answer;
	}
}