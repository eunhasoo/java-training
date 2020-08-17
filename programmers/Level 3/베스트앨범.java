import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

	class Music implements Comparable<Music> {
		int no;
		String genre;
		int playCount;

		public Music(int no, String genre, int playCount) {
			this.no = no;
			this.genre = genre;
			this.playCount = playCount;
		}

		@Override
		public int compareTo(Music m) {
			int d1 = this.playCount - m.playCount; // 더 많은 재생 횟수
			if (d1 == 0) { // 재생 횟수가 같으면
				return m.no - this.no; // 더 낮은 번호 선호
			}
			return d1;
		}
	}
	
	Map<String, Integer> genreMap;
	
	public int[] solution(String[] genres, int[] plays) {
		genreMap = new HashMap<>(); // 장르별 재생횟수 저장
		List<Music> musicList = new ArrayList<>(); // 비교와 정렬을 위한 리스트
		
		for (int i = 0; i < genres.length; i++) {
			genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
			musicList.add(new Music(i, genres[i], plays[i]));
		}
		
		Collections.sort(musicList, new Comparator<Music>() {
			public int compare(Music m1, Music m2) {
				if (m1.genre.equals(m2.genre)) { // 장르가 같으면 구현한 Comparable으로만 비교
					return m2.compareTo(m1);
				}
				// 장르가 다른 경우 더 많이 재생된 장르를 우선
				return -(genreMap.get(m1.genre) - genreMap.get(m2.genre));
			}
		});

		// 재생 횟수를 기준으로 장르 목록을 정렬 (DESC)
		genreMap = genreMap.entrySet().stream()
		        	   .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		        	   .collect(Collectors.toMap(
		        	    	Map.Entry::getKey, 
		        	    	Map.Entry::getValue, 
		        	    	(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		List<Integer> numbers = new ArrayList<>(); // no를 저장해둘 리스트
		Map<String, Integer> forCount = new HashMap<>(); // 장르별 2개 저장 규칙을 체크하기 위한 맵
		for (Music music : musicList) {
			if (!forCount.containsKey(music.genre)) {
				forCount.put(music.genre, 1);
				numbers.add(music.no);
				continue;
			}
			int count = forCount.get(music.genre);
			if (count == 2) continue;
			forCount.put(music.genre, count + 1);
			numbers.add(music.no);
		}

		int[] answer = new int[numbers.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = numbers.get(i);
		return answer;
	}
}