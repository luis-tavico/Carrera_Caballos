package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Interfaz extends JFrame {

    private JPanel panel;
    private JPanel panel2;
    private JLabel caballo1;
    private JLabel caballo2;
    private JLabel meta;
    private JLabel numero_1;
    private JLabel numero_2;
    private JLabel ganador;
    private JButton iniciar;

    public Interfaz() {
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("CarreraDeCaballos");
        Image icono = Toolkit.getDefaultToolkit().getImage("src/main/java/Imagenes/ticket.png");
        setIconImage(icono);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        agregarPanel();
        agregarPanel2();
        etiquetaCaballo1();
        etiquetaCaballo2();
        etiquetaMeta();
        botonIniciar();
        numeroCaballo();
        etiquetaGanador();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.green);
        this.getContentPane().add(panel);
    }

    private void agregarPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 210, 600, 105);
        panel2.setBackground(Color.DARK_GRAY);
        panel.add(panel2);
    }

    private void etiquetaCaballo1() {
        ImageIcon caballo_1 = new ImageIcon("src/main/java/Imagenes/caballo1.gif");
        caballo1 = new JLabel();
        caballo1.setBounds(20, 20, 65, 65);
        caballo1.setIcon(new ImageIcon(caballo_1.getImage().getScaledInstance(caballo1.getWidth(), caballo1.getHeight(), Image.SCALE_SMOOTH)));
        caballo1.setText("Caballo No.1");
        panel.add(caballo1);
    }

    private void etiquetaCaballo2() {
        ImageIcon caballo_2 = new ImageIcon("src/main/java/Imagenes/caballo2.gif");
        caballo2 = new JLabel();
        caballo2.setBounds(20, 100, 65, 65);
        caballo2.setIcon(new ImageIcon(caballo_2.getImage().getScaledInstance(caballo2.getWidth(), caballo2.getHeight(), Image.SCALE_SMOOTH)));
        caballo2.setText("Caballo No.2");
        panel.add(caballo2);
    }

    private void etiquetaMeta() {
        ImageIcon linea_meta = new ImageIcon("src/main/java/Imagenes/meta.jpg");
        meta = new JLabel();
        meta.setBounds(560, 20, 10, 170);
        meta.setIcon(new ImageIcon(linea_meta.getImage().getScaledInstance(meta.getWidth(), meta.getHeight(), Image.SCALE_SMOOTH)));
        //meta.setText("Caballo No.2");
        panel.add(meta);
    }

    private void botonIniciar() {
        iniciar = new JButton();
        iniciar.setBounds(80, 30, 100, 50);
        iniciar.setText("Iniciar");
        iniciar.setFont(new Font("arial", Font.PLAIN, 20));
        iniciar.setBackground(Color.white);
        panel2.add(iniciar);
        accionBtnIniciar();
    }

    private void numeroCaballo() {
        numero_1 = new JLabel();
        numero_1.setBounds(10, 15, 15, 15);
        numero_1.setText("1");
        numero_1.setFont(new Font("arial", Font.PLAIN, 15));
        numero_1.setOpaque(true);
        numero_1.setBackground(Color.black);
        numero_1.setForeground(Color.white);
        numero_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(numero_1);

        numero_2 = new JLabel();
        numero_2.setBounds(10, 100, 15, 15);
        numero_2.setOpaque(true);
        numero_2.setBackground(Color.black);
        numero_2.setForeground(Color.white);
        numero_2.setText("2");
        numero_2.setFont(new Font("arial", Font.PLAIN, 15));
        numero_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(numero_2);
    }

    private void etiquetaGanador() {
        ganador = new JLabel();
        ganador.setBounds(220, 30, 300, 50);
        ganador.setFont(new Font("arial", Font.PLAIN, 25));
        ganador.setForeground(Color.white);
        panel2.add(ganador);
    }

    public JButton getBotonIniciar() {
        return iniciar;
    }

    private void accionBtnIniciar() {
        ActionListener oyenteBtnIniciar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciarActionPerformed(e);
            }
        };
        iniciar.addActionListener(oyenteBtnIniciar);
    }

    private void btnIniciarActionPerformed(ActionEvent evt) {
        iniciar.setEnabled(false);
        caballo1.setBounds(20, 20, 65, 65);
        caballo2.setBounds(20, 100, 65, 65);
        ganador.setText("");
        Carrera hilo = new Carrera(caballo1, caballo2, ganador, iniciar);
        //Thread hilo = new Thread(objeto);
        Carrera hilo2 = new Carrera(caballo2, caballo1, ganador, iniciar);
        //System.out.println("Carrera de Caballos (505 Metros)");
        hilo.start();
        hilo2.start();
        //iniciar.setVisible(true);
    }

}
