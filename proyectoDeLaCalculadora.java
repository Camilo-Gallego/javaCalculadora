import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class proyectoDeLaCalculadora extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel panel;
    private JTextField pantalla;

    private double numero1, numero2, resultado;
    private int operacion;

    public proyectoDeLaCalculadora () {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        panel.add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));

        String[] botonesTexto = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        JButton[] botones = new JButton[botonesTexto.length];

        for (int i = 0; i < botonesTexto.length; i++) {
            botones[i] = new JButton(botonesTexto[i]);
            botones[i].addActionListener(this);
            panelBotones.add(botones[i]);
        }

        panel.add(panelBotones, BorderLayout.CENTER);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
            case ".":
                pantalla.setText(pantalla.getText() + comando);
                break;
            case "+":
                numero1 = Double.parseDouble(pantalla.getText());
                operacion = 1;
                pantalla.setText("");
                break;
            case "-":
                numero1 = Double.parseDouble(pantalla.getText());
                operacion = 2;
                pantalla.setText("");
                break;
            case "*":
                numero1 = Double.parseDouble(pantalla.getText());
                operacion = 3;
                pantalla.setText("");
                break;
            case "/":
                numero1 = Double.parseDouble(pantalla.getText());
                operacion = 4;
                pantalla.setText("");
                break;
            case "=":
                numero2 = Double.parseDouble(pantalla.getText());
                switch (operacion) {
                    case 1:
                        resultado = numero1 + numero2;
                        break;
                    case 2:
                        resultado = numero1 - numero2;
                        break;
                    case 3:
                        resultado = numero1 * numero2;
                        break;
                    case 4:
                        if (numero2 != 0)
                            resultado = numero1 / numero2;
                        else
                            pantalla.setText("Error");
                        break;
                }
                pantalla.setText(String.valueOf(resultado));
                break;
            case "C":
                pantalla.setText("");
                break;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
