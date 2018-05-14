package rubik.busqueda;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class BusquedaAEstrella extends BusquedaHeuristica implements Busqueda {

    TrazaGenerica traza;

    @Override
    public Vector<Operador> buscarSolucion(Estado inicial) {
        reporteInicioBusqueda();
        listaCerrada = new HashMap<Estado, NodoBusqueda>();
        listaAbierta = new LinkedList<NodoBusqueda>();
        Boolean solucionEncontrada = false;
        NodoBusqueda nodoSolucion = null;
        NodoBusqueda nodoActual = new NodoBusqueda(inicial, null, null);
        nodoActual.setProfundidad(0);
        nodoActual.setCosto(0);
        nodoActual.setHeuristica(h.obtenerHeuristica(nodoActual));
        traza = new TrazaGenerica(nodoActual);
        while (!solucionEncontrada) {
            if (listaAbierta.isEmpty()) {
                break;
            } else {
                traza.imprimirInicioIteracion(listaAbierta);
                nodoActual = listaAbierta.pollFirst();
                reporteNodosExplorados();
                if (!listaCerrada.containsKey(nodoActual.getEstado())) {
                    if (nodoActual.getEstado().esFinal()) {
                        solucionEncontrada = true;
                        nodoSolucion = nodoActual;
                    } else {
                        listaCerrada.put(nodoActual.getEstado(), nodoActual);
                        listaAbierta.addAll(expandirNodo(nodoActual));
                        ordenarListaMenorFcEvaluacion();
                    }
                }
            }
        }
        reporteNodosSobrantes(listaAbierta.size());
        reporteFinBusqueda();
        if (nodoSolucion == null) {
            return new Vector<Operador>();
        } else {
            return encontrarCamino(nodoSolucion);
        }
    }
    
    /**
     * 1. Un elemento * es comparado con el anterior, hasta que se encuentra un 
     * elemento más * pequeño.
     * 2. Si un elemento contiene un valor menor que todos * los elementos * 
     * anteriores
     *  2.1.Compara ese elemento con todos los elementos * anteriores antes * de
     *  continuar con la siguiente comparación.
     */
    private void ordenarListaMenorFcEvaluacion() {
        LinkedList<NodoBusqueda> lista = listaAbierta;
        int i, j;
        int N = lista.size();
        for (i = 1; i < N; i++) {
            NodoBusqueda tmp = lista.get(i);
            for (j = i; (j > 0 && (tmp.getFuncionEv() < lista.get(j - 1).getFuncionEv())); j--) {
                lista.set(j, lista.get(j - 1));
            }
            lista.set(j, tmp);
        }
        listaAbierta = lista;
    }
}
