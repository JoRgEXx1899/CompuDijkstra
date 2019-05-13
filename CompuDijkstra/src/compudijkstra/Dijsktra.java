/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compudijkstra;

import java.util.Stack;

/**
 *
 * @author usuario
 */
public class Dijsktra {

    AdyRandom grafo_aleatorio = new AdyRandom();

    public Dijsktra() {
        int[][] grafo = {{0, 5, -1, -1, 1},
        {5, 0, 2, 1, -1},
        {-1, 2, 0, 6, -1},
        {-1, 1, 6, 0, 10},
        {1, -1, -1, 10, 0}};
        int nodo_origen = 1; //Nodo origen: v1
        for (int k = 0; k < 5; k++) {
            System.out.println((char)27 + "[31;47m\t\t\t\t\tPAQUETE "+(k+1)+"\n");
            
            Nodo[] resultado = resolver(grafo, nodo_origen - 1);
            //Mostrar solución por pantalla:
            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Desde v" + nodo_origen + " hasta v" + (i + 1) + ": " + resultado[i].distancia);
                System.out.print("Camino: ");
                for (int j = 0; j < resultado[i].camino.size() - 1; j++) {
                    System.out.print("v" + (resultado[i].camino.get(j).intValue() + 1) + " -> ");
                }
                System.out.println("v" + (resultado[i].camino.get(resultado[i].camino.size() - 1).intValue() + 1) + "\n");
            }
        }
    }

    private Nodo[] resolver(int[][] grafo, int nodo_origen) {
        int n = grafo.length;
        boolean[] visitados = new boolean[n]; // Se inicializan a false

        Nodo[] retorno = new Nodo[n]; //Array de nodos solución
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = new Nodo(nodo_origen, 0);
        }

        Stack<Nodo> soluciones = new Stack<Nodo>(); //Se van apilando las soluciones parciales en esta lista.
        soluciones.push(new Nodo(nodo_origen, 0));

        while (!soluciones.isEmpty()) {
            // Se coje la menor distancia de entre las soluciones parciales:
            Nodo origen = soluciones.pop();
            for (int i = 1; i < soluciones.size(); i++) {
                if (origen.distancia > soluciones.get(i).distancia) {
                    origen = soluciones.get(i);
                }
            }
            soluciones.remove(origen);

            visitados[origen.nodo] = true;
            for (int i = 0; i < n; i++) {
                if (visitados[i] || grafo[origen.nodo][i] < 0) {
                    continue; // Si no se puede acceder del origen al destino, se pasa
                }
                if ((grafo[origen.nodo][i] + origen.distancia) < retorno[i].distancia || retorno[i].distancia == 0) {
                    //Se sobreescribe la distancia si es menor que la que ya se tenía, o si no se tenía ninguna:
                    retorno[i] = new Nodo(i, (grafo[origen.nodo][i] + origen.distancia), origen);
                    //Se añade el nodo destino a las soluciones parciales:
                    soluciones.push(new Nodo(i, retorno[i].distancia, origen));
                }
            }
            grafo = grafo_aleatorio.generar_grafo(grafo);
            grafo_aleatorio.imprimir();
            System.out.println("\n");
        }
        return retorno;
    }
}
