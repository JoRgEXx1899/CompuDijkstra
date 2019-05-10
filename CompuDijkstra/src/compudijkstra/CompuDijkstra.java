package compudijkstra;

/**
 *
 * @author Jorge Daniel Gomez Vanegas 
 */
public class CompuDijkstra {

    /**
     * @param args the command line arguments
     */
    int[][] grafo;

    public static void main(String[] args) {
        int[][] ady = {{0, 5, -1, -1, 1},
                    {5, 0, 2, 1, -1},
                    {-1, 2, 0, 6, -1},
                    {-1, 1, 6, 0, 10},
                    {1, -1, -1, 10, 0}};
        
        int[][] g =generar_grafo(ady);
        

    }

    public  int[][] generar_grafo(int[][] graph) {
        this.grafo = graph;
        for (int i = 0; i < this.grafo.length; i++) {
            for (int j = 0; j < this.grafo[0].length; j++) {
                if (grafo[i][j] > 0) {
                    grafo[i][j] = (int) (Math.random() * 50) + 1;
                }
            }

        }
        return grafo;
    }

}
