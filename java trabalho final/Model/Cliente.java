package Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Conta> contas; // Lista de contas associadas ao cliente
    private String senha; // Senha do cliente para autenticação
    private Gerente gerente; // Referência ao gerente que gerencia este cliente

    // Construtor que inicializa um cliente com nome, endereço, RG, CPF, telefone e senha
    public Cliente(String nome, String endereco, String rg, String cpf, String telefone, String senha) {
        super(nome, endereco, rg, cpf, telefone); // Chama o construtor da superclasse Pessoa
        this.senha = senha;
        this.contas = new ArrayList<>(); // Inicializa a lista de contas vazia
    }

    // Construtor adicionado para incluir o gerente que gerencia o cliente
    public Cliente(String nome, String endereco, String rg, String cpf, String telefone, String senha, Gerente gerente) {
        super(nome, endereco, rg, cpf, telefone); // Chama o construtor da superclasse Pessoa
        this.senha = senha;
        this.gerente = gerente;
        this.contas = new ArrayList<>(); // Inicializa a lista de contas vazia
    }

    // Método para adicionar uma conta à lista de contas do cliente
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    // Método para realizar um depósito em uma conta específica do cliente
    public boolean depositar(double valor, int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        }
        return false; // Conta não encontrada
    }

    // Método para realizar um saque de uma conta específica do cliente
    public boolean sacar(double valor, int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false; // Conta não encontrada
    }

    // Método para realizar uma transferência entre duas contas do cliente
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = encontrarConta(numeroContaOrigem);
        Conta contaDestino = encontrarConta(numeroContaDestino);
        if (contaOrigem != null && contaDestino != null) {
            return contaOrigem.transferir(contaDestino, valor);
        }
        return false; // Conta de origem ou destino não encontrada
    }

    // Método privado para encontrar uma conta pelo número
    private Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null; // Conta não encontrada
    }

    // Métodos getter e setter para senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos getter e setter para gerente
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    // Método getter para obter a lista de contas do cliente
    public List<Conta> getContas() {
        return contas;
    }
}
