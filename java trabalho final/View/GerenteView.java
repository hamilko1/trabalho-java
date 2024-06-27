package View;

import Controller.GerenteController;
import Model.Funcionario;
import Model.Cliente;
import Model.Conta;
import Model.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GerenteView extends JFrame {
    private GerenteController gerenteController;
    private JComboBox<Cliente> cbClientes;
    private JButton btnVerificarConta;

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

        JLabel lbClientes = new JLabel("Selecione o Cliente:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbClientes, constraints);

        List<Cliente> clientes = gerenteController.listarClientes();
        cbClientes = new JComboBox<>(clientes.toArray(new Cliente[0]));
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(cbClientes, constraints);

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

        getContentPane().add(panel);
        pack();
    }

    private void abrirDetalhesConta(Cliente cliente) {
        // Lógica para abrir detalhes da conta do cliente selecionado
        List<Conta> contas = gerenteController.listarContasCliente(cliente);
        StringBuilder sb = new StringBuilder();
        sb.append("Contas de ").append(cliente.getNome()).append(":\n");
        for (Conta conta : contas) {
            sb.append("- ").append(conta.getTipo()).append(": ").append(conta.getSaldo()).append("\n"); // Aqui usamos getTipo()
        }
        JOptionPane.showMessageDialog(GerenteView.this, sb.toString());
    }
}
