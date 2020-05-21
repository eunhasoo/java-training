import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> crossing = new LinkedList<>();
        
        // 트럭 입력이 하나뿐인 경우 걸리는 시간은 다리 길이 + 1
        if (truck_weights.length == 1)
        	return bridge_length + 1;
        
        for (int w : truck_weights)
        	waiting.add(w);
        
        int time = 0, weightsOnBridge = 0;
        while (!waiting.isEmpty()) {
        	if (crossing.size() == bridge_length) {
        		weightsOnBridge -= crossing.remove();
        	}
        	
        	if (waiting.peek() + weightsOnBridge <= weight) {
        		weightsOnBridge += waiting.peek();
        		crossing.add(waiting.remove());
        	} else {
        		crossing.add(0);
        	}
        	
        	++time;
        }
        time += bridge_length; // 마지막 트럭이 다리를 나오는데 걸린 시간 추가
        
        return time;
    }

}