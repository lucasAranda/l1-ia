package rubik.busqueda;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public abstract class BusquedaHeuristica extends RendimientoBusqueda {

    HashMap<Estado, NodoBusqueda> listaCerrada;
    LinkedList<NodoBusqueda> listaAbierta;
    //TrazaGenerica traza;
    Heuristica h = new Heuristica1();

    public void setHeuristica(Heuristica heuristica) {
        this.h = heuristica;
    }
    
    /**
     * Devuelve la lista de nodos a expandir luego de aplcicar los operadores
     * al nodo padre.
     * 
     * @param nodoPadre
     * @return expandidos
     */
    protected LinkedList<NodoBusqueda> expandirNodo(NodoBusqueda nodoPadre) {
        /* 1.Crea la lista de nodos expandidos a obtener.
           2.Por cada operador aplicable del nodo padre
            2.1.Genera un nuevo nodo a partir de aplicar el operador al nodo padre
            2.2.Setea la profundiddad al nodo.
            2.3.Setea costo.
            2.4.Setea la heurisca al nuevo nodo
            2.5.Setea la funciòn de evaluaciòn.
            2.6.Si el estado del nodo no se encuentra en la lista cerrada,
                lo agrega a la lista de nodos expandidos.
           3.Devuelve la lista de nodos expandidos.
        */
        LinkedList<NodoBusqueda> expandidos = new LinkedList<NodoBusqueda>();
        for (Operador oper : nodoPadre.getEstado().operadoresAplicables()) {
            NodoBusqueda n = new NodoBusqueda(nodoPadre.getEstado().aplicarOperador(oper), nodoPadre, oper);
            n.setProfundidad(nodoPadre.getProfundidad() + 1);
            n.setCosto(nodoPadre.getCosto() + 1);
            /*
             * agregar h (heurisitica)
             y f (funcion de evaluacion)que es igual al costo de camino + h
             */

            if (!listaCerrada.containsKey(n.getEstado())) {
                expandidos.add(n);
            }
        }
        //traza.imprimirFinalIteracion(nodoPadre, expandidos);
        return expandidos;
    }
    
    /**
     * Devuelve el vector de operadores a aplicar para llegar a la soluciòn.
     * 
     * @param nodoFinal
     * @return camino
     */
    protected Vector<Operador> encontrarCamino(NodoBusqueda nodoFinal) {
        /*1.Genera el vector de operadores correspondiente al camino.
          2.Establece el nodoFinal como nodoPaso para comenzar a buscar el 
            camino.
          3.Mientras el nodoPaso no sea el nodo inicial
            3.1.Agrega al camino el operador del nodo al inicio de la lista de 
                camino.
            3.2.Establece como nodoPaso al nodoPadre del actual nodoPaso.
          4.Imprime el reporte de la bùsqueda.
          5.Devuelve el vector de operadores.
        */
        Vector<Operador> camino = new Vector<Operador>();
        NodoBusqueda nodoPaso = nodoFinal;
        while (nodoPaso.getPadre() != null) {
            camino.insertElementAt(nodoPaso.getOperador(), 0);
            nodoPaso = (NodoBusqueda) nodoPaso.getPadre();
        }
        //Imprimo Reporte de busqueda antes de retornar el camino para llegar a la solución
        System.out.println("\n REPORTE DE BUSQUEDA");
        System.out.println("---------------------------------------");
        System.out.println(getReporteCompleto());

        return camino;
    }

}
