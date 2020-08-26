import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    class Process {
        int requestTime;  // 요청 시점
        int requiredTime; // 소요 시간

        public Process(int requestTime, int requiredTime) {
            this.requestTime = requestTime;
            this.requiredTime = requiredTime;
        }
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Process> queue = new PriorityQueue<>((p1, p2) -> p1.requiredTime - p2.requiredTime); // 소요 시간 기준
        List<Process> processes = new ArrayList<>(); 
        for (int i = 0; i < jobs.length; i++) {
            processes.add(new Process(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(processes, (p1, p2) -> p1.requestTime - p2.requestTime); // 요청 시점 기준

        int sum, time, idx, count = jobs.length;
        sum = time = idx = 0;
        while (count > 0) {
            while (idx < jobs.length && processes.get(idx).requestTime <= time) {
                queue.add(processes.get(idx));
                ++idx;
            }

            if (!queue.isEmpty()) { // 작업 수행중에 들어오는 요청
                Process process = queue.poll();
		// 한 작업의 요청에서 종료까지 걸린 시간 = (이전 작업 소요시간 + 현재 작업 소요시간 - 요청 시점)
		int processTime = time + process.requiredTime - process.requestTime;
                sum += processTime;
                time += process.requiredTime; // 이전 작업 소요 시간 갱신 
                count--;
            } else { // 작업 수행중이 아닐 때 들어오는 요청
                time = processes.get(idx).requestTime;
            }
        }

        return (sum / jobs.length);
    }
}