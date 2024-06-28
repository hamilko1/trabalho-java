package View;

import Controller.LoginController;
import Model.Funcionario;
import Model.Cliente;
import Model.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField tfMatricula;
    private JPasswordField pfSenha;
    private JButton btnLogin;
    private LoginController loginController;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;

        setTitle("Login - Sistema Bancário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Label e campo de texto para matrícula
        JLabel lbMatricula = new JLabel("Matrícula:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lbMatricula, constraints);

        tfMatricula = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(tfMatricula, constraints);

        // Label e campo de senha
        JLabel lbSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lbSenha, constraints);

        pfSenha = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(pfSenha, constraints);

        // Botão de login
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = tfMatricula.getText();
                String senha = String.valueOf(pfSenha.getPassword());
                realizarLogin(matricula, senha);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnLogin, constraints);

        getContentPane().add(panel);
        pack();
    }

    // Método para realizar o login
    private void realizarLogin(String matricula, String senha) {
        Funcionario funcionario = loginController.login(matricula, senha);
        if (funcionario != null) {
            JOptionPane.showMessageDialog(LoginView.this, "Login bem-sucedido!");

            // Verifica se o funcionário é um gerente ou cliente e abre a tela apropriada
            if (funcionario.isGerente()) {
                abrirTelaGerente();
            } else {
                abrirTelaCliente(funcionario.getCliente());
            }
        } else {
            JOptionPane.showMessageDialog(LoginView.this, "Matrícula ou senha incorretas!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para abrir a tela do cliente
    private void abrirTelaCliente(Cliente cliente) {
        OperacoesClienteView operacoesView = new OperacoesClienteView(cliente);
        operacoesView.setVisible(true);
        setVisible(false);
    }

    // Método para abrir a tela do gerente
    private void abrirTelaGerente() {
        GerenteView gerenteView = new GerenteView(loginController.getBanco());
        gerenteView.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Criação do banco e do controlador de login
                Banco banco = new Banco();
                LoginController loginController = new LoginController(banco);
                
                // Criação da janela de login
                LoginView loginView = new LoginView(loginController);
                loginView.setVisible(true);

                // Simulação de adição de funcionários (para testes)
                banco.adicionarFuncionario(new Funcionario("João Silva", "Rua A, 123", "123456789", "123.456.789-00", "(11) 98765-4321", "12345", "senha123"));
                banco.adicionarFuncionario(new Funcionario("Maria Oliveira", "Rua B, 456", "987654321", "987.654.321-00", "(11) 98765-4321", "67890", "outraSenha"));
            }
        });
    }
}
