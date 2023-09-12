import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pesetas extends JFrame{

    private JButton boton1 = new JButton("A euros");
    private JButton boton2 = new JButton("A pesetas");
    private JTextField cantidad = new JTextField(10);

    public Pesetas(){
        super("Conversor Euros-Pesetas");
        setLayout(new FlowLayout());
        JLabel etiqueta = new JLabel("Valor del cambio ");
        cantidad.setText("0");
        add(etiqueta); add(cantidad);
        add(boton1); add(boton2);
        boton1.addActionListener(new OyenteBoton());
        boton2.addActionListener(new OyenteBoton());
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class OyenteBoton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Float valor = Float.parseFloat(cantidad.getText());
            String s = e.getActionCommand();
            if(s.equals("A euros")){
                valor = (float) (valor/166.386);
            }
            else if(s.equals("A pesetas")){
                valor = (float) (valor * 166.386);
            }
            cantidad.setText(Float.toString(valor));
        }
    }

    public static void main(String[] args) {
        Pesetas aplicacion = new Pesetas();
    }
}
