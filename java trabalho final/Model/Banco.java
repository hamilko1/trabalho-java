package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Banco implements Serializable {
    private Map<String, Cliente> clientes;
    private Map<String, Funcionario> funcionarios;

    public Banco() {
        clientes = new HashMap<>();
        funcionarios = new HashMap<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    public Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getMatricula(), funcionario);
    }

    public Funcionario getFuncionario(String matricula) {
        return funcionarios.get(matricula);
    }

    public Map<String, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    // Métodos para autenticar funcionário e cliente
    public Funcionario autenticarFuncionario(String matricula, String senha) {
        Funcionario funcionario = funcionarios.get(matricula);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario;
        }
        return null; // Funcionário não encontrado ou senha incorreta
    }

    public Cliente autenticarCliente(String cpf, String senha) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente;
        }
        return null; // Cliente não encontrado ou senha incorreta
    }

    // Métodos para operações bancárias
    public boolean depositar(String cpf, double valor, int numeroConta) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            return cliente.depositar(valor, numeroConta);
        }
        return false; // Cliente não encontrado
    }

    public boolean sacar(String cpf, double valor, int numeroConta) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            return cliente.sacar(valor, numeroConta);
        }
        return false; // Cliente não encontrado
    }

    public boolean transferir(String cpfOrigem, String cpfDestino, int numeroContaOrigem, int numeroContaDestino, double valor) {
        Cliente clienteOrigem = clientes.get(cpfOrigem);
        Cliente clienteDestino = clientes.get(cpfDestino);
        
        if (clienteOrigem != null && clienteDestino != null) {
            return clienteOrigem.transferir(numeroContaOrigem, numeroContaDestino, valor);
        }
        return false; // Cliente de origem ou destino não encontrado
    }

    // Método para adicionar contas a clientes
    public void adicionarContaCliente(String cpf, Conta conta) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            cliente.adicionarConta(conta);
        }
    }

    
    // Outros métodos conforme necessário
}
