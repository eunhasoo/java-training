class Solution {

    public int solution(int n) {
    	int[] fibonacci = new int[n+1];
    	fibonacci[0] = 0;
    	fibonacci[1] = fibonacci[2] = 1;
    	for (int i = 3; i < fibonacci.length; i++) {
    		fibonacci[i] = (fibonacci[i-2] % 1234567) + (fibonacci[i-1] % 1234567);
    	}
        return fibonacci[n] % 1234567;
    }

}