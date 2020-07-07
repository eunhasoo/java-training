class Solution {
	
	// (영향받는 블록의 반복되는 패턴의 개수) == (최대공약수 개수) 
	// 예) 12 x 8일 때 패턴이 4번 반복
	public long getGcd(long a, long b) {
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		
		while (min != 0) {
			long r = max % min;
			max = min;
			min = r;
		}
		
		return max;
	}
	
	public long solution(int w, int h) {
		if (w < 2 || h < 2) return 0;
		long total = (long) w * (long) h;
		long unusable = (long) w + (long) h - getGcd(w, h); // (w/gcd + h/gcd - 1) * gcd
		return total - unusable;
	}

}