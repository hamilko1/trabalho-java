package View;

import Controller.OperacoesController;
import Model.Cliente;
import Model.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacoesClienteView extends JFrame {
    private Cliente cliente;
    private JComboBox<Conta> cbContas;
    private JTextField tfValor;
    private JButton btnDepositar;
    private JButton btnSacar;
    private OperacoesController operacoesController;

    public OperacoesClienteView(Cliente cliente) {
        this.cliente = cliente;
        this.operacoesController = new OperacoesController();

        setTitle("Operações Bancárias - Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel lbConta = new JLabel("Selecione a Conta:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbConta, constraints);

        cbContas = new JComboBox<>(cliente.getContas().toArray(new Conta[0]));
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(cbContas, constraints);

        JLabel lbValor = new JLabel("Valor:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lbValor, constraints);

        tfValor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(tfValor, constraints);

        btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnDepositar, constraints);

        btnSacar = new JButton("Sacar");
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSaque();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(btnSacar, constraints);

        getContentPane().add(panel);
        pack();
    }

    private void realizarDeposito() {
        Conta contaSelecionada = (Conta) cbContas.getSelectedItem();
        double valor = Double.parseDouble(tfValor.getText());

        // Chamar o controller para realizar o depósito
        boolean sucesso = operacoesController.depositar(contaSelecionada, valor);
        if (sucesso) {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Depósito realizado com sucesso!");
            atualizarSaldo();
        } else {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Erro ao realizar depósito!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarSaque() {
        Conta contaSelecionada = (Conta) cbContas.getSelectedItem();
        double valor = Double.parseDouble(tfValor.getText());

        // Chamar o controller para realizar o saque
        boolean sucesso = operacoesController.sacar(contaSelecionada, valor);
        if (sucesso) {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Saque realizado com sucesso!");
            atualizarSaldo();
        } else {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Erro ao realizar saque!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarSaldo() {
        // Atualizar o saldo exibido na interface
        Conta contaSelecionada = (Conta) cbContas.getSelectedItem();
        double saldoAtualizado = operacoesController.getSaldo(contaSelecionada);
        JOptionPane.showMessageDialog(OperacoesClienteView.this, "Saldo atualizado: R$" + saldoAtualizado);
    }
}
