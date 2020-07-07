import java.util.Arrays;
import java.util.TreeSet;

class Solution {
	
	public int solution(String numbers) {
		TreeSet<Integer> set = new TreeSet<>();
		permutations("", numbers, set);
		boolean[] primeNums = getPrimeNums(set.last());
		return getPrimeCount(set, primeNums);
	}
	
	public void permutations(String perm, String numbers, TreeSet<Integer> set) {
		if (!perm.equals("")) {
			set.add(Integer.parseInt(perm));
		}
		
		for (int i = 0; i < numbers.length(); i++) {
			permutations(perm + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, numbers.length()), set);
		}
 	}
	
	public boolean[] getPrimeNums(int n) {
		boolean[] primeNums = new boolean[n + 1];
		Arrays.fill(primeNums, true);
		primeNums[0] = primeNums[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (primeNums[i])
				for (int j = i * 2; j <= n; j += i)
					primeNums[j] = false;
		}
		return primeNums;
	}
	
	public int getPrimeCount(TreeSet<Integer> set, boolean[] primeNums) {
		int count = 0;
		while (!set.isEmpty()) {
			if (primeNums[set.pollFirst()])
				++count;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution("1007"));
	}
}