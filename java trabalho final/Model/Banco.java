package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Banco implements Serializable {
    private Map<String, Cliente> clientes; // Mapa para armazenar clientes com CPF como chave
    private Map<String, Funcionario> funcionarios; // Mapa para armazenar funcionários com matrícula como chave

    // Construtor padrão que inicializa os mapas de clientes e funcionários
    public Banco() {
        clientes = new HashMap<>();
        funcionarios = new HashMap<>();
    }

    // Método para adicionar um cliente ao banco
    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    // Método para obter um cliente pelo CPF
    public Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    // Método para obter todos os clientes do banco
    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    // Método para adicionar um funcionário ao banco
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getMatricula(), funcionario);
    }

    // Método para obter um funcionário pela matrícula
    public Funcionario getFuncionario(String matricula) {
        return funcionarios.get(matricula);
    }

    // Método para obter todos os funcionários do banco
    public Map<String, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    // Método para autenticar um funcionário com base na matrícula e senha
    public Funcionario autenticarFuncionario(String matricula, String senha) {
        Funcionario funcionario = funcionarios.get(matricula);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario;
        }
        return null; // Funcionário não encontrado ou senha incorreta
    }

    // Método para autenticar um cliente com base no CPF e senha
    public Cliente autenticarCliente(String cpf, String senha) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente;
        }
        return null; // Cliente não encontrado ou senha incorreta
    }

    // Método para realizar um depósito em uma conta específica de um cliente
    public boolean depositar(String cpf, double valor, int numeroConta) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            return cliente.depositar(valor, numeroConta);
        }
        return false; // Cliente não encontrado
    }

    // Método para realizar um saque de uma conta específica de um cliente
    public boolean sacar(String cpf, double valor, int numeroConta) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            return cliente.sacar(valor, numeroConta);
        }
        return false; // Cliente não encontrado
    }

    // Método para realizar uma transferência entre contas de dois clientes diferentes
    public boolean transferir(String cpfOrigem, String cpfDestino, int numeroContaOrigem, int numeroContaDestino, double valor) {
        Cliente clienteOrigem = clientes.get(cpfOrigem);
        Cliente clienteDestino = clientes.get(cpfDestino);
        
        if (clienteOrigem != null && clienteDestino != null) {
            return clienteOrigem.transferir(numeroContaOrigem, numeroContaDestino, valor);
        }
        return false; // Cliente de origem ou destino não encontrado
    }

    // Método para adicionar uma conta a um cliente
    public void adicionarContaCliente(String cpf, Conta conta) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            cliente.adicionarConta(conta);
        }
    }

    // Outros métodos conforme necessário

}
