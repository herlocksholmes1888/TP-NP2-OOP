package media.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaAritmetica extends JFrame {
	private static final long serialVersionUID = 1L;
	
    private JTextField nota1Field, nota2Field, nota3Field;
    private JButton calcularButton;
    private JTextArea resultadoArea;

    public MediaAritmetica() {
        setTitle("Calculadora de Média");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nota1Label = new JLabel("Nota 1:");
        nota1Label.setBounds(20, 20, 80, 25);
        add(nota1Label);

        nota1Field = new JTextField();
        nota1Field.setBounds(100, 20, 150, 25);
        add(nota1Field);

        JLabel nota2Label = new JLabel("Nota 2:");
        nota2Label.setBounds(20, 50, 80, 25);
        add(nota2Label);

        nota2Field = new JTextField();
        nota2Field.setBounds(100, 50, 150, 25);
        add(nota2Field);

        JLabel nota3Label = new JLabel("Nota 3:");
        nota3Label.setBounds(20, 80, 80, 25);
        add(nota3Label);

        nota3Field = new JTextField();
        nota3Field.setBounds(100, 80, 150, 25);
        add(nota3Field);

        calcularButton = new JButton("Calcular Média");
        calcularButton.setBounds(80, 120, 140, 25);
        add(calcularButton);

        resultadoArea = new JTextArea();
        resultadoArea.setBounds(20, 150, 250, 50);
        resultadoArea.setEditable(false);
        add(resultadoArea);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void calcularMedia() {
        try {
            double nota1 = Double.parseDouble(nota1Field.getText());
            double nota2 = Double.parseDouble(nota2Field.getText());
            double nota3 = Double.parseDouble(nota3Field.getText());

            double media = (nota1 + nota2 + nota3) / 3;

            resultadoArea.setText("Média: " + media);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira apenas números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MediaAritmetica().setVisible(true);
            }
        });
    }
}