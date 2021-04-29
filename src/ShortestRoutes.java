import java.util.*;
import java.io.*;

public class ShortestRoutes {
    public double[] distTo;
    public Edge[] lastVisited;
    public boolean[] visited;
    public String shortestRoute;

    public ShortestRoutes(Graph graph, int source, int destination) {
        this.distTo = new double[graph.numberOfStops];
        this.lastVisited = new Edge[graph.numberOfStops];
        this.visited = new boolean[graph.numberOfStops];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            visited[i] = false;
        }
        distTo[source] = 0;
        for (int i = 0; i < graph.numberOfStops - 1; i++) {
            int vertex = minimumDistance(distTo, visited);
            if (vertex < 0) {
                continue;
            }
            visited[vertex] = true;
            for (Edge edge : graph.adjEdges.get(vertex))
                relax(edge);
        }

        this.shortestRoute = findShortestRoute(source, destination);
    }

    public int minimumDistance(double[] distTo, boolean[] visited) {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && distTo[i] <= min) {
                min = distTo[i];
                index = i;
            }
        }
        return index;
    }

    public void relax(Edge edge) {
        int fromVertex = edge.fromVertex;
        int endVertex = edge.endVertex;
        if (distTo[endVertex] > (distTo[fromVertex] + edge.weight)) {
            distTo[endVertex] = distTo[fromVertex] + edge.weight;
            lastVisited[endVertex] = edge;
        }
    }

    public String findShortestRoute(int stop1, int stop2) {
        Stack<Integer> stops = new Stack<Integer>();
        stops.push(stop2);

        while (true){
            int temp = lastVisited[stop2].fromVertex;
            stops.push(temp);
            if (temp == stop1) {
                break;
            }
        }
        shortestRoute = ("The shortest route from " + stop1 + " to " + stop2 + " is: ");
        while (!stops.isEmpty()){
            shortestRoute += (stops.pop() + ",\n");
        }

        return shortestRoute;
    }

    public static void main(String args[]){
        String file1 = "stops.txt";
        String file2 = "stop_times.txt";
        String file3 = "transfers.txt";

        int stop1 = 1885;
        int stop2 = 1866;
        
        Graph graph = new Graph(file1, file2, file3);

        ShortestRoutes s = new ShortestRoutes(graph, stop1, stop2);

        System.out.println(s.shortestRoute);
        System.out.println(s.distTo);        
    }
}