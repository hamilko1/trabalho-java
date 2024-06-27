package Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Conta> contas;
    private String senha;
    private Gerente gerente; // Referência ao gerente que gerencia este cliente

    public Cliente(String nome, String endereco, String rg, String cpf, String telefone, String senha) {
        super(nome, endereco, rg, cpf, telefone);
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    // Construtor adicionado para incluir a senha
    public Cliente(String nome, String endereco, String rg, String cpf, String telefone, String senha, Gerente gerente) {
        super(nome, endereco, rg, cpf, telefone);
        this.senha = senha;
        this.gerente = gerente;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public boolean depositar(double valor, int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        }
        return false; // Conta não encontrada
    }

    public boolean sacar(double valor, int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false; // Conta não encontrada
    }

    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = encontrarConta(numeroContaOrigem);
        Conta contaDestino = encontrarConta(numeroContaDestino);
        if (contaOrigem != null && contaDestino != null) {
            return contaOrigem.transferir(contaDestino, valor);
        }
        return false; // Conta de origem ou destino não encontrada
    }

    private Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null; // Conta não encontrada
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
