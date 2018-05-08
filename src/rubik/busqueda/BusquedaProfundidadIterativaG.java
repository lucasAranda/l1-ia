package rubik.busqueda;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/* Estrategia de Busqueda en grafo en Profundidad Interactiva, 
 * Implementacion de la interfaz Busqueda
 * Hereda de la clase abstracta BusquedaGrafo (generica independiente de la estrategia)
 * Implementa el m�todo buscarSolucion() y devuelve un vector de operadores (soluci�n)
 */

public class BusquedaProfundidadIterativaG extends BusquedaGrafo implements Busqueda {

  BusquedaProfundidadLimitadaG busquedapl = new BusquedaProfundidadLimitadaG();
  int profundidadActual = 0;

    @Override
public Vector<Operador> buscarSolucion(Estado inicial){
    reporteInicioBusqueda();  //Antes de comenzar la b�squeda se contabiliza tiempo
    Vector<Operador> caminoSolucion = null;
    boolean solucionEncontrada = false;
    while(!solucionEncontrada) {
      busquedapl.setProfundidadLimite(profundidadActual);
      caminoSolucion = busquedapl.buscarSolucion(inicial);
      reporteNodosExplorados(busquedapl.getNroNodosExplorados()); //Antes de evaluar si el nodo es soluci�n contabilizo nodos explorados
      if(caminoSolucion.size() > 0) {
        solucionEncontrada = true;
      }
      else {
        profundidadActual++;
      }
      reporteNodosSobrantes(busquedapl.getNroNodosSobrantes()); // al terminar contabilizo nodos sobrantes
    }
    
    reporteFinBusqueda(); // Contabilizo tiempo al finalizar busqueda
    return caminoSolucion;
	}

}
