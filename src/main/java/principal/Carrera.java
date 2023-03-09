package principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Carrera extends Thread {

    private JLabel caballoA;
    private JLabel caballoB;
    private JLabel ganador;
    private JButton iniciar;
    int posicion = 0;

    public Carrera(JLabel caballoA, JLabel caballoB, JLabel ganador, JButton iniciar) {
        this.caballoA = caballoA;
        this.caballoB = caballoB;
        this.ganador = ganador;
        this.iniciar = iniciar;
    }

    @Override
    public void run() {
        try {
            while ((caballoA.getLocation().x) < 505 && (caballoB.getLocation().x) < 505) {
                if ((caballoA.getLocation().x) < 505) {
                    posicion = (int) (Math.random() * 10 + 1);
                    caballoA.setLocation(caballoA.getLocation().x += posicion, caballoA.getLocation().y);
                    //caballo.repaint();
                    Thread.sleep(150);
                }
            }
            if ((caballoA.getLocation().x >= 505) && (caballoA.getLocation().x > caballoB.getLocation().x)) {
                ganador.setText("Ganador: " + caballoA.getText());

                //caballoA.setLocation(20,caballoA.getLocation().y);               
            }

            //System.out.println(caballoA.getText() + ": " + caballoA.getLocation().x + "m recorridos.");
            iniciar.setEnabled(true);

        } catch (InterruptedException ex) {
            System.out.println(ex);

        }

    }

}
