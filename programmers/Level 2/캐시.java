import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
	
    public int solution(int cacheSize, String[] cities) {
    	if (cacheSize == 0) {
    		return cities.length * 5;
    	}
    	Set<String> cache = new LinkedHashSet<>();
    	int runningTime = 0;
    	for (String city : cities) {
    		city = city.toUpperCase();
    		if (cache.contains(city)) {
    			runningTime += 1;
    			cache.remove(city);
    		} else {
    			if (cache.size() == cacheSize) {
    				cache.remove(cache.iterator().next());
    			}
    			runningTime += 5;
    		}
    		cache.add(city);
    	}
        return runningTime;
    }
}