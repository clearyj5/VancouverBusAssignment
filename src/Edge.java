public class Edge {
    public int fromVertex;
    public int endVertex;
    public double weight;

    public Edge(int fromVertex, int endVertex, double weight) {
        this.fromVertex = fromVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}