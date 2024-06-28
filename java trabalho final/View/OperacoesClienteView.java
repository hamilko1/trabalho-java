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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela ao invés de sair da aplicação
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Label e combobox para selecionar a conta
        JLabel lbConta = new JLabel("Selecione a Conta:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbConta, constraints);

        cbContas = new JComboBox<>(cliente.getContas().toArray(new Conta[0]));
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(cbContas, constraints);

        // Label e campo de texto para inserir o valor da operação
        JLabel lbValor = new JLabel("Valor:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lbValor, constraints);

        tfValor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(tfValor, constraints);

        // Botão para realizar depósito
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

        // Botão para realizar saque
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

        // Adiciona o painel ao content pane da janela
        getContentPane().add(panel);

        // Ajusta o tamanho da janela para se adequar ao conteúdo
        pack();
    }

    // Método para realizar depósito
    private void realizarDeposito() {
        Conta contaSelecionada = (Conta) cbContas.getSelectedItem();
        double valor = Double.parseDouble(tfValor.getText());

        // Chama o controller para realizar o depósito
        boolean sucesso = operacoesController.depositar(contaSelecionada, valor);
        if (sucesso) {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Depósito realizado com sucesso!");
            atualizarSaldo();
        } else {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Erro ao realizar depósito!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para realizar saque
    private void realizarSaque() {
        Conta contaSelecionada = (Conta) cbContas.getSelectedItem();
        double valor = Double.parseDouble(tfValor.getText());

        // Chama o controller para realizar o saque
        boolean sucesso = operacoesController.sacar(contaSelecionada, valor);
        if (sucesso) {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Saque realizado com sucesso!");
            atualizarSaldo();
        } else {
            JOptionPane.showMessageDialog(OperacoesClienteView.this, "Erro ao realizar saque!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para atualizar o saldo exibido na interface após uma operação
    private void atualizarSaldo() {
        Conta contaSelecionada = (Conta) cbContas.getSelectedItem();
        double saldoAtualizado = operacoesController.getSaldo(contaSelecionada);
        JOptionPane.showMessageDialog(OperacoesClienteView.this, "Saldo atualizado: R$" + saldoAtualizado);
    }
}
