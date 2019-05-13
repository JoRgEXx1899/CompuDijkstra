package compudijkstra;

/**
 *
 * @author Jorge Daniel Gomez Vanegas
 */
public class AdyRandom {

    /**
     * @param args the command line arguments
     */
    int[][] grafo;

    public int[][] generar_grafo(int[][] graph) {
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

    public void imprimir() {
        String temp="";
        for (int i = 0; i < this.grafo.length; i++) {           
            for (int j = 0; j < this.grafo[0].length; j++) {
                temp=temp+grafo[i][j]+"\t";
            }
            System.out.println(temp);
            temp="";
        }
    }
}
