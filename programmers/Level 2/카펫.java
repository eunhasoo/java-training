class Solution {
	
    public int[] solution(int brown, int yellow) {
    	int width, height;
    	width = height = (brown / 2) - 1;
    	
    	while (true) {
    		if ((width * 2 + height * 2) - 4 == brown) {
    			if (width * height - yellow == brown) {
    				break;
    			} 
    			width--;
    			height++;
    			continue;
    		}
    		height--;
    	}
    	
        int[] answer = new int[2];
        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}