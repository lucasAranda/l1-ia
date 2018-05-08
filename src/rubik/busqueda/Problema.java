package rubik.busqueda;

import java.util.Vector;

/**
 * Clase gen�rica (indepeniente de estados y algoritmos concretos) que representa 
 * un problema de b�squeda en espacio de estados.
 * Est� caracterizado por un Estado inicial y un m�todo de Busqueda
 * IA 2011
 */
public class Problema {
    /** Estado inicial del problema*/
    private Estado inicial;
    /** M�todo de busqueda e utilizar en la resoluci�n del problema */
    private Busqueda buscador;

    public Problema(Estado inicial, Busqueda buscador) {
        this.inicial = inicial;
        this.buscador = buscador;
    }

    public void setBuscador(Busqueda buscador) {
        this.buscador = buscador;
    }

    public void setInicial(Estado inicial) {
        this.inicial = inicial;
    }
    
    public Busqueda getBuscador (){
        return buscador;
    }
    
    /**
     * Aplica el m�todo de Busqueda de este Problema concreto para resolverlo. 
     * Devuelve la lista de Operadores que permiten alcanzar un Estado final desde
     * el Estado inicial del Problema
     * @return null o Vector de Operadores
     */
    public Vector<Operador> obtenerSolucion() {
        return(buscador.buscarSolucion(inicial));
    }
    
    
    
}
