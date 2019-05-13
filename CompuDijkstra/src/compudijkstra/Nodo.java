/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compudijkstra;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
class Nodo {
        //Clase auxiliar que representa un nodo,
        //la distancia acumulada hasta llegar a él,
        //y el camino seguido.
        int nodo;
        int distancia;
        LinkedList<Integer> camino;
        Nodo(int nodo, int distancia, Nodo anterior) {
            this.nodo = nodo;
            this.distancia = distancia;
            camino = (LinkedList<Integer>) anterior.camino.clone();
            camino.add(new Integer(nodo));
        }
        Nodo(int nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
            camino = new LinkedList<Integer>();
            camino.add(new Integer(nodo));
        }
    }


