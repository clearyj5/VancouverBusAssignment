public class ShortestRoutes {

    public double distanceTo[][];
    public int edgeTo[][];
    public int edge;
    public int infinity = Integer.MAX_VALUE;
    private double shortestDistance;

    public void dijkstraShortestPath(int k) {

        boolean[] checkIfPathIsShortest = new boolean[distanceTo.length];

        checkIfPathIsShortest[k] = true;

        while (true) {

            int x = -1;

            for (int i = 0; i < distanceTo.length; i++) {

                if ((!checkIfPathIsShortest[i]) && distanceTo[k][i] != infinity) {

                    x = i;
                    break;
                }
            }

            if (x == -1) {

                return;
            }

            checkIfPathIsShortest[x] = true;

            for (int i = 0; i < distanceTo.length; i++) {

                if (distanceTo[k][x] + distanceTo[x][i] < distanceTo[k][i]) {

                    distanceTo[k][i] = distanceTo[k][x] + distanceTo[x][i];

                    checkIfPathIsShortest[i] = false;
                    edgeTo[k][i] = x;

                }
            }
        }
    }

    public void findShortestRoute (String stop1, String stop2) {
         
        //TODO Edit sizes below
        distanceTo = new double[amountOfStops][amountOfStops];
        edgeTo = new int[amountOfEdges][amountOfEdges];

        int s1 = -1; //Stop 1 Number
        int s2 = -1; //Stop 2 Number

        //Initializes 2D arrays setting all distances to infinity
        for (int j = 0; j < distanceTo.length; j++) {
            for (int k = 0; k < distanceTo[j].length; k++) {

                distanceTo[j][k] = infinity;
                if (j == k) {
                    distanceTo[j][k] = 0;
                }
            }
        }

        dijkstraShortestPath(s1);

        shortestDistance = distanceTo[s1][s2];
        

    }
}