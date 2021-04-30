import java.io.*;
import java.util.*;

public class ShortestRoutes {
	
    public final int MAX_STOP_NUMBER = 12479;
	public double busSystem[][] = new double[MAX_STOP_NUMBER][MAX_STOP_NUMBER];

	ShortestRoutes() {
		try {
			buildBusSystem();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void buildBusSystem() throws FileNotFoundException {
		
		for(int i = 0; i < busSystem.length; i++) {
			for(int j = 0; j < busSystem[i].length; j++) {
				if(i == j) {
					busSystem[i][j] = 0;
				}
				else {
					busSystem[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}
		
		File stopTimesFile = new File("stop_times.txt");

		Scanner scanner1 = new Scanner(stopTimesFile);
		scanner1.useDelimiter(",");

		scanner1.nextLine();
		
		int start = 0, destination = 0, lastRoute = 0, currRoute = 0;
        String currentLine;
		double cost = 1;

		
		while(scanner1.hasNextLine()){
			lastRoute = currRoute;
			currRoute = scanner1.nextInt();
			scanner1.next(); 
			scanner1.next();
			start = destination;
			destination = scanner1.nextInt();

			if (lastRoute == currRoute){
				busSystem[start][destination] = cost;
			}
			scanner1.nextLine();
		}
		scanner1.close();
		
		int transferType; 

		double minTime;
		double Divisor = 100;


		File transfersFile = new File("transfers.txt");
		Scanner scanner2 = null;
		scanner1 = new Scanner(transfersFile);
		scanner1.nextLine();
		
		while(scanner1.hasNextLine()) {
			currentLine = scanner1.nextLine();
			scanner2 = new Scanner(currentLine);
			scanner2.useDelimiter(",");
			start = scanner2.nextInt();
			destination = scanner2.nextInt();
			transferType = scanner2.nextInt();
			
			if(transferType == 0) {
				busSystem[start][destination] = 2;
			}

			else if(transferType == 2) {
				minTime = scanner2.nextDouble();
				busSystem[start][destination] = minTime / Divisor;
			}

			scanner2.close();
		}
		scanner1.close();
	}
	
	public ArrayList<String> shortestRoute(int start, int to){
		ArrayList<String> result = new ArrayList<String>();

		if(start == to) {
			result.add("cost: " + Double.toString(busSystem[start][to])); 
			result.add(" via route: "); 
			result.add(Integer.toString(start));
			return  result;
		}
		
		int visited[] = new int[busSystem.length];
    	double distTo[] = new double[busSystem.length];
    	int edgeTo[] = new int[busSystem.length];
    	for(int i = 0; i < distTo.length; i++) {
    		if(i != start)
    		{
    			distTo[i] = Double.POSITIVE_INFINITY;
    		}
    	}
    	
    	visited[start] = 1;
    	distTo[start] = 0; 
    	int currentNode = start;
    	int visitedCounter = 0;
    	while(visitedCounter < distTo.length)
    	{
    		for(int i = 0; i < busSystem[currentNode].length; i ++) {
    			if(!Double.isInfinite(busSystem[currentNode][i]) && visited[i] == 0) {
        			relaxEdge(currentNode, i, distTo, edgeTo);
        		}
    		}
    		visited[currentNode] = 1;
    		
    		double shortestDist = Integer.MAX_VALUE;
    		for(int i = 0; i < distTo.length; i++) {
    			if(visited[i] != 1 && shortestDist > distTo[i]) {
    				currentNode = i;
    				shortestDist = distTo[i];
    			}
    		}
    		visitedCounter++;
    	}
    	
    	if(distTo[to] == Double.POSITIVE_INFINITY) {
			result.add("route does not exist");
    		return result;
    	}
    	
    	int u = start;
    	int v = to;
    	String route = "";
    	while(v != u) {
    		route =  ", " + edgeTo[v] + route;
    		v = edgeTo[v];
    	}
    	route = route + ", " + to;
    	
		result.add("cost: " + Double.toString(distTo[to])); 
		result.add(" via route: "); 
		result.add(route);
    	return result;
    }
	
    private void relaxEdge(int start, int to, double[] distTo, int[] edgeTo) {
    	if(distTo[to] > distTo[start] + busSystem[start][to]) {
    		distTo[to] = distTo[start] + busSystem[start][to];
    		edgeTo[to] = start;
    	}
    }
}