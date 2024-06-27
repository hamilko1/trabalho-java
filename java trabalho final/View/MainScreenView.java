package View;

import Controller.MainScreenController;
import Model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenView extends JFrame {
    private MainScreenController controller;

    public MainScreenView(MainScreenController controller) {
        this.controller = controller;

        setTitle("Main Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JButton btnOperacoesCliente = new JButton("Operações do Cliente");
        btnOperacoesCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.abrirOperacoesCliente();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnOperacoesCliente, constraints);

        getContentPane().add(panel);
        pack();
    }
}
