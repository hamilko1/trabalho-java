package Main;

import Model.Banco;
import Model.Cliente;
import Model.Conta;
import Model.ContaCorrente;
import Model.ContaPoupanca;
import Model.Funcionario;
import Controller.LoginController;
import View.LoginView;
import Persistence.Persistencia;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BancoHolder bancoHolder = new BancoHolder();

        try {
            Banco banco = Persistencia.carregarBanco("banco.dat");
            bancoHolder.setBanco(banco);
        } catch (IOException | ClassNotFoundException e) {
            Banco banco = new Banco();
            bancoHolder.setBanco(banco);

            // Adicionando alguns clientes e suas contas para teste
            Cliente cliente1 = new Cliente("Maria Souza", "Rua X, 456", "987654321", "987.654.321-00", "(11) 98765-4321", "senha123");
            ContaCorrente contaMaria1 = new ContaCorrente(1, 1000.0, 0.0); // Exemplo de criação de conta corrente
            ContaPoupanca contaMaria2 = new ContaPoupanca(2, 500.0, 0.05); // Exemplo de criação de conta poupança
            cliente1.adicionarConta(contaMaria1);
            cliente1.adicionarConta(contaMaria2);
            banco.adicionarCliente(cliente1);

            Cliente cliente2 = new Cliente("Pedro Almeida", "Av. Y, 789", "654321987", "654.321.987-00", "(11) 98765-4321","outraSenha");
            ContaCorrente contaPedro1 = new ContaCorrente(3, 1500.0, 0.0); // Exemplo de criação de conta corrente
            cliente2.adicionarConta(contaPedro1);
            banco.adicionarCliente(cliente2);

            // Adicionando funcionários ao banco
            Funcionario gerente = new Funcionario("João Silva", "Rua A, 123", "123456789", "123.456.789-00", "(11) 98765-4321", "12345", "senha123");
            banco.adicionarFuncionario(gerente);


            // Adicionar contas aos clientes no banco
            banco.adicionarContaCliente(cliente1.getCpf(), contaMaria1);
            banco.adicionarContaCliente(cliente1.getCpf(), contaMaria2);
            banco.adicionarContaCliente(cliente2.getCpf(), contaPedro1);
            banco.adicionarFuncionario(gerente);
        }

        Banco banco = bancoHolder.getBanco();

        // Interface gráfica
        LoginController loginController = new LoginController(banco);
        LoginView loginView = new LoginView(loginController);
        loginView.setVisible(true);

        // Adicionar controladores e listeners para interações

        // Hook de encerramento para salvar o banco
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Persistencia.salvarBanco(bancoHolder.getBanco(), "banco.dat");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
