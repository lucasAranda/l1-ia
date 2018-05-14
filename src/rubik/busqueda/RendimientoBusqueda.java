package rubik.busqueda;

/* Clase abstracta que guarda los metodos requeridos para
 * calular las medidas de rendimiento para evaluar los algoritmos de busqueda
 * Inteligencia Artificial 2018
 */

public abstract class RendimientoBusqueda {

  long tiempoBusquedaSeg;  
  long tiempoBusquedaMili; 
  long cantidadNodosExplorados; 
  long cantidadNodosSobrantes;  
  
  /**
   * Retorna un reporte completo de la busqueda: tiempo de busqueda, nodos generados y nodos explorados.
   * 
   */
  // debe llamarse al finalzar la busqueda antes de retornar el camino solucion
  public String getReporteCompleto(){
         return ("Tiempo de busqueda: " + tiempoBusquedaMili + " milisegundos (" + tiempoBusquedaSeg + " segundos)" +
        "\n"+"Nodos Generados: " + (cantidadNodosExplorados + cantidadNodosSobrantes) +
        "\n"+"Nodos Explorados: " + cantidadNodosExplorados) ;
   }
  
  // se toma el tiempo inicial al comienzo de la busqueda
  /**
   * Inicializa las variables antes de comenzar la busqueda. Se toma el tiempo 
   * del sistema al comienzo de la busqueda
   */
  protected void reporteInicioBusqueda() {
    cantidadNodosExplorados = 0;
    cantidadNodosSobrantes = 0;
    tiempoBusquedaMili = System.currentTimeMillis();
    tiempoBusquedaSeg = (System.currentTimeMillis()/ 1000);
  }

  /**
   * Incrementa la cantidad de nodos explorados en uno. Se llama cuando
   * se evalua un nodo extraido de la lista abierta
   */
  protected void reporteNodosExplorados() {
    cantidadNodosExplorados++;
  }
  /**
   * Incrementa la cantidad de nodos explorados segun cantidad
   */
  protected void reporteNodosExplorados(long cantidad) {
    cantidadNodosExplorados += cantidad;
  }
  
  /**
   * Se suma a la cantidad de nodos sobrantes la cantidad ingresada.
   * Se llama cuando se evalua un nodo extraido de la lista abierta  
   * @param cantidad 
   */
  protected void reporteNodosSobrantes(long cantidad) {
    cantidadNodosSobrantes += cantidad;
  }
  
  /**
   * Tiempo que tomo la busqueda.
   * Se toma el tiempo final al finalizar la busqueda.
   * Se calcula diferencia de inicio y final para determinar tiempo en seg y miliseg
   */
  protected void reporteFinBusqueda() {
    tiempoBusquedaMili = System.currentTimeMillis() - tiempoBusquedaMili;
    tiempoBusquedaSeg = (System.currentTimeMillis()/ 1000) - tiempoBusquedaSeg;
  }
  
  public long getNroNodosGenerados() {
    return cantidadNodosExplorados + cantidadNodosSobrantes;
  }
  public long getNroNodosExplorados() {
    return cantidadNodosExplorados;
  }
  public long getNroNodosSobrantes() {
    return cantidadNodosSobrantes;
  }
  public long getTiempoBusquedaMili() {
    return tiempoBusquedaMili;
  }
  public long getTiempoBusquedaMinu() {
    return tiempoBusquedaSeg;
  }
  

}
