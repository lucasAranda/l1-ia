package rubik.busqueda;

import rubik.modelo.Cubo;
import rubik.modelo.EstadoRubik;

/**
 *
 * @author LUCAS
 */
public class Heuristica2 implements Heuristica {

    private static int h;
    private static int white, yellow, orange, red, green, blue; //variables para contar la catidad de colores
    private static byte color;

    /**
     * Esta heuristica cuenta la cantidad de colores distintos en cada cara.
     *
     * @return cantidad de colores distinto en las 6 caras del cubo
     */
    @Override
    public int obtenerHeuristica(Nodo nodo) {
        EstadoRubik estado = (EstadoRubik) nodo.getEstado();
        clearColores();
        h = 0;

        Cubo cubox = estado.getCubo();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                color = cubox.caras[i].casillas[j];
                if (color == 0) {
                    white++;
                }
                if (color == 1) {
                    yellow++;
                }
                if (color == 2) {
                    orange++;
                }
                if (color == 3) {
                    red++;
                }
                if (color == 4) {
                    green++;
                }
                if (color == 5) {
                    blue++;
                }
            }
            contarCantColores();
            clearColores();
        }
        return h;
    }

    private void clearColores() {
        white = 0;
        red = 0;
        blue = 0;
        green = 0;
        orange = 0;
        yellow = 0;
    }

    private void contarCantColores() {
        if(white>0) h++;
        if(red>0) h++;
        if(blue>0) h++;
        if(orange>0) h++;
        if(yellow>0) h++;
        if(green>0) h++;
    }

}
