import java.util.ArrayDeque;

class Solution {
	
	class Word {
		String word;
		int convertedCount;
		
		public Word(String word, int convertedCount) {
			this.word = word;
			this.convertedCount = convertedCount;
		}
	}
	
	public int solution(String begin, String target, String[] words) {
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (isDifferentOneLetter(words[i], begin)) {
				int count = BFS(i, target, words);
				answer = (count == 0) ? answer : Math.min(count, answer);
			}
		}
		if (answer == Integer.MAX_VALUE) // 변환 실패
			return 0; 
		return answer;
	}
	
	public int BFS(int start, String target, String[] words) {
		ArrayDeque<Word> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[words.length];
		queue.add(new Word(words[start], 1)); // 첫번째 변환부터 시작
		visited[start] = true;
		while (!queue.isEmpty()) {
			Word current = queue.remove();
			if (current.word.equals(target)) {
				return current.convertedCount;
			}
			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && isDifferentOneLetter(current.word, words[i])) {
					queue.add(new Word(words[i], current.convertedCount + 1));
					visited[i] = true;
				}
			}
		}
		return 0;
	}
	
	public boolean isDifferentOneLetter(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
					count++;
			}
		}
		return count == 1;
	}
	
}