package rubik;

import rubik.grafico.JFrameRubik;
/**
 * Interfaz gr�fico basado en el Applet de Josef Jelinek (http://software.rubikscube.info/AnimCube/)
* Inteligencia Artificial 2016
 */
public class MainGrafico {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
                 public void run() {
                      new JFrameRubik().setVisible(true); //ventana gr�fica
                 }
         });
    }
}
