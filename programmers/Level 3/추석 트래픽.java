class Solution {
	
	public void saveTimeToSec(String time/* "HH:mm:ss.SSS" */, String pTime/* "ss.SSS" */, 
					int i, double[][] startEndTime) {
		double hours = Double.parseDouble(time.substring(0, 2)); // HH
		double mins = Double.parseDouble(time.substring(3, 5)); // mm
		double secs = Double.parseDouble(time.substring(6, time.length())); // ss.SSS
		
		double end = hours * 3600 + mins * 60 + secs; // 응답 완료 시간 (요청 종료)
		double start = end - Double.parseDouble(pTime) + 0.001; // 요청 시작시간 = 응답 완료시간 - 처리시간 + 0.001초
		startEndTime[i][0] = start;
		startEndTime[i][1] = end;
	}
	
	public int getMaxCount(double[][] startEndTime) {
		int max = 0;
		for (int i = 0; i < startEndTime.length; i++) {
			int count = 0;
			for (int j = i; j < startEndTime.length; j++) {
				if (startEndTime[i][1] + 1.0 > startEndTime[j][0])
					++count;
			}
			
			if (max < count) max = count;
		}
		return max;
	}
	
    public int solution(String[] lines) {
        double[][] startEndTime = new double[lines.length][2]; // 시작, 종료 시간 보관
        for (int i = 0; i < lines.length; i++) {
        	String[] input = lines[i].split(" "); // 날짜 input[0]은 무시한다
        	saveTimeToSec(input[1], input[2].substring(0, input[2].length() - 1), i, startEndTime);
        }
        return getMaxCount(startEndTime);
    }
}