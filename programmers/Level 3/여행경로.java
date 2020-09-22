import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution { 
	
	String route = "";
	List<String> paths = new ArrayList<>();
	
	public void dfs(String[][] tickets, String end, int depth, boolean[] visited) {
		route += end + ",";
		
		if (depth == tickets.length) {
			paths.add(route);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			String depart = tickets[i][0];
			String dest = tickets[i][1];
			
			if (end.equals(depart) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, dest, depth + 1, visited);
				visited[i] = false;
				route = route.substring(0, route.length() - 4);
			}
		}
	}
	
    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
        	if (tickets[i][0].equals("ICN")) {
        		boolean[] visited = new boolean[tickets.length];
        		visited[i] = true;
        		route = tickets[i][0] + ",";
        		dfs(tickets, tickets[i][1], 1, visited);
        	}
        }
        
        Collections.sort(paths);

        return paths.get(0).split(",");
    }

}