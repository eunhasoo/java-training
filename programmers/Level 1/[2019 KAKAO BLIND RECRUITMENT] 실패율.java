import java.util.ArrayList;
import java.util.List;

class Solution {

	class Stage {
		int number;
		float failureRate;

		public Stage(int number, float failureRate) {
			this.number = number;
			this.failureRate = failureRate;
		}
	}

	public int[] solution(int N/* 스테이지 갯수 */, int[] stages/* 사용자의 현재 스테이지 */) {
		List<Stage> stgs = new ArrayList<>();
		for (int stageNo = 1; stageNo <= N; stageNo++) {
			int done = 0; // 현재 도전중 + 이미 도달한 플레이어 수
			int yet = 0;  // 현재 도전중인 플레이어
			for (int index = 0; index < stages.length; index++) {
				if (stages[index] >= stageNo)
					++done;
				if (stages[index] == stageNo)
					++yet;
			}
			if (done == 0) { // 0으로는 나눌 수 없으므로 따로 작업 필요
				stgs.add(new Stage(stageNo, 0));
				continue;
			}
			stgs.add(new Stage(stageNo, (float) yet / done));
		}
		stgs.sort((s1, s2) -> {
			int r = Float.compare(s2.failureRate, s1.failureRate); // float값 비교 (내림차순)
			if (r == 0) // 실패율이 같으면 스테이지 넘버가 작은 것부터
				return s1.number - s2.number;
			return r;
		});
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = stgs.get(i).number;
		}
		return answer;
	}

}