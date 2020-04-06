class Solution {
	public long solution(long n) {
		long sq = (long) Math.sqrt(n);
		return (Math.pow(sq, 2) == n) ? (long) Math.pow(sq + 1, 2) : -1;
	}
}