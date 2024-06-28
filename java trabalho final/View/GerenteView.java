package View;

import Controller.GerenteController;
import Model.Banco;
import Model.Cliente;
import Model.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GerenteView extends JFrame {
    private GerenteController gerenteController;
    private JComboBox<Cliente> cbClientes;
    private JButton btnVerificarConta;
    private JButton btnDepositar;
    private JButton btnSacar;
    private JButton btnTransferir;

    public GerenteView(Banco banco) {
        // Inicializa GerenteController com o banco fornecido
        this.gerenteController = new GerenteController(banco);

        setTitle("Gerente - Verificar Contas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Label e ComboBox para selecionar o cliente
        JLabel lbClientes = new JLabel("Selecione o Cliente:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbClientes, constraints);

        List<Cliente> clientes = gerenteController.listarClientes();
        cbClientes = new JComboBox<>(clientes.toArray(new Cliente[0]));
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(cbClientes, constraints);

        // Botão para verificar conta do cliente selecionado
        btnVerificarConta = new JButton("Verificar Conta");
        btnVerificarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteSelecionado = (Cliente) cbClientes.getSelectedItem();
                if (clienteSelecionado != null) {
                    abrirDetalhesConta(clienteSelecionado);
                } else {
                    JOptionPane.showMessageDialog(GerenteView.this, "Selecione um cliente primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnVerificarConta, constraints);

        // Botão para realizar depósito em conta
        btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(btnDepositar, constraints);

        // Botão para realizar saque de conta
        btnSacar = new JButton("Sacar");
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSaque();
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(btnSacar, constraints);

        // Botão para realizar transferência entre contas
        btnTransferir = new JButton("Transferir");
        btnTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarTransferencia();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(btnTransferir, constraints);

        getContentPane().add(panel);
        pack();
    }

    // Método para abrir detalhes das contas do cliente selecionado
    private void abrirDetalhesConta(Cliente cliente) {
        List<Conta> contas = gerenteController.listarContasCliente(cliente);
        StringBuilder sb = new StringBuilder();
        sb.append("Contas de ").append(cliente.getNome()).append(":\n");
        for (Conta conta : contas) {
            sb.append("- ").append(conta.getTipo()).append(": ").append(conta.getSaldo()).append("\n"); // Aqui usamos getTipo()
        }
        JOptionPane.showMessageDialog(GerenteView.this, sb.toString());
    }

    // Método para realizar depósito em conta do cliente selecionado
    private void realizarDeposito() {
        Cliente clienteSelecionado = (Cliente) cbClientes.getSelectedItem();
        if (clienteSelecionado != null) {
            String numeroContaStr = JOptionPane.showInputDialog("Número da conta:");
            String valorStr = JOptionPane.showInputDialog("Valor do depósito:");
            try {
                int numeroConta = Integer.parseInt(numeroContaStr);
                double valor = Double.parseDouble(valorStr);
                boolean sucesso = gerenteController.getBanco().depositar(clienteSelecionado.getCpf(), valor, numeroConta);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Depósito falhou. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número da conta ou valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para realizar saque da conta do cliente selecionado
    private void realizarSaque() {
        Cliente clienteSelecionado = (Cliente) cbClientes.getSelectedItem();
        if (clienteSelecionado != null) {
            String numeroContaStr = JOptionPane.showInputDialog("Número da conta:");
            String valorStr = JOptionPane.showInputDialog("Valor do saque:");
            try {
                int numeroConta = Integer.parseInt(numeroContaStr);
                double valor = Double.parseDouble(valorStr);
                boolean sucesso = gerenteController.getBanco().sacar(clienteSelecionado.getCpf(), valor, numeroConta);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Saque realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Saque falhou. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número da conta ou valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para realizar transferência entre contas
    private void realizarTransferencia() {
        Cliente clienteSelecionado = (Cliente) cbClientes.getSelectedItem();
        if (clienteSelecionado != null) {
            String numeroContaOrigemStr = JOptionPane.showInputDialog("Número da conta de origem:");
            String numeroContaDestinoStr = JOptionPane.showInputDialog("Número da conta de destino:");
            String valorStr = JOptionPane.showInputDialog("Valor da transferência:");
            try {
                int numeroContaOrigem = Integer.parseInt(numeroContaOrigemStr);
                int numeroContaDestino = Integer.parseInt(numeroContaDestinoStr);
                double valor = Double.parseDouble(valorStr);
                String cpfDestino = JOptionPane.showInputDialog("CPF do cliente de destino:");
                boolean sucesso = gerenteController.getBanco().transferir(clienteSelecionado.getCpf(), cpfDestino, numeroContaOrigem, numeroContaDestino, valor);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Transferência realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Transferência falhou. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número da conta ou valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
