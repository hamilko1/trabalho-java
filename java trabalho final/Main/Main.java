package Main;

import Model.Banco;
import Model.Cliente;
import Model.ContaCorrente;
import Model.ContaPoupanca;
import Model.Funcionario;
import Controller.LoginController;
import View.LoginView;
import Persistence.Persistencia;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BancoHolder bancoHolder = new BancoHolder(); // Instancia um BancoHolder para armazenar o banco carregado

        try {
            // Tenta carregar o banco a partir do arquivo "banco.dat"
            Banco banco = Persistencia.carregarBanco("banco.dat");
            bancoHolder.setBanco(banco); // Define o banco carregado no BancoHolder
        } catch (IOException | ClassNotFoundException e) {
            // Se ocorrer uma exceção ao carregar o banco (arquivo não encontrado ou formato inválido), cria um novo banco

            Banco banco = new Banco(); // Cria um novo objeto Banco
            bancoHolder.setBanco(banco); // Define o banco recém-criado no BancoHolder

            // Adiciona alguns clientes e suas contas para fins de teste
            Cliente cliente1 = new Cliente("Maria Souza", "Rua X, 456", "987654321", "987.654.321-00", "(11) 98765-4321", "senha123");
            ContaCorrente contaMaria1 = new ContaCorrente(1, 1000.0, 0.0); // Cria uma conta corrente para Maria
            ContaPoupanca contaMaria2 = new ContaPoupanca(2, 500.0, 0.05); // Cria uma conta poupança para Maria
            cliente1.adicionarConta(contaMaria1); // Adiciona a conta corrente de Maria ao cliente
            cliente1.adicionarConta(contaMaria2); // Adiciona a conta poupança de Maria ao cliente
            banco.adicionarCliente(cliente1); // Adiciona Maria como cliente no banco

            Cliente cliente2 = new Cliente("Pedro Almeida", "Av. Y, 789", "654321987", "654.321.987-00", "(11) 98765-4321", "outraSenha");
            ContaCorrente contaPedro1 = new ContaCorrente(3, 1500.0, 0.0); // Cria uma conta corrente para Pedro
            cliente2.adicionarConta(contaPedro1); // Adiciona a conta corrente de Pedro ao cliente
            banco.adicionarCliente(cliente2); // Adiciona Pedro como cliente no banco

            // Adiciona um funcionário (gerente) ao banco
            Funcionario gerente = new Funcionario("João Silva", "Rua A, 123", "123456789", "123.456.789-00", "(11) 98765-4321", "12345", "senha123");
            banco.adicionarFuncionario(gerente); // Adiciona o gerente ao banco

            // Adiciona as contas dos clientes ao banco (não necessariamente precisa ser repetido, dependendo da lógica do sistema)
            banco.adicionarContaCliente(cliente1.getCpf(), contaMaria1);
            banco.adicionarContaCliente(cliente1.getCpf(), contaMaria2);
            banco.adicionarContaCliente(cliente2.getCpf(), contaPedro1);
        }

        Banco banco = bancoHolder.getBanco(); // Obtém o banco do BancoHolder

        // Interface gráfica: cria um controlador de login e uma visualização de login
        LoginController loginController = new LoginController(banco);
        LoginView loginView = new LoginView(loginController);
        loginView.setVisible(true); // Torna a janela de login visível

        // Adicionar controladores e listeners para interações

        // Hook de encerramento para salvar o banco quando o programa é encerrado
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Persistencia.salvarBanco(bancoHolder.getBanco(), "banco.dat"); // Salva o banco no arquivo "banco.dat"
            } catch (IOException e) {
                e.printStackTrace(); // Trata exceção se houver erro ao salvar o banco
            }
        }));
    }
}
