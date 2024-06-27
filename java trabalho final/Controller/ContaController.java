package Controller;

import Model.Banco;
import Model.Cliente;
import Model.Conta;

public class ContaController {
    private Banco banco;

    public ContaController(Banco banco) {
        this.banco = banco;
    }

    public void adicionarConta(String cpf, Conta conta) {
        Cliente cliente = banco.getCliente(cpf);
        if (cliente != null) {
            cliente.adicionarConta(conta);
        }
    }

    public Conta getConta(String cpf, int indice) {
        Cliente cliente = banco.getCliente(cpf);
        if (cliente != null && indice >= 0 && indice < cliente.getContas().size()) {
            return cliente.getContas().get(indice);
        }
        return null;
    }

    public void removerConta(String cpf, int indice) {
        Cliente cliente = banco.getCliente(cpf);
        if (cliente != null && indice >= 0 && indice < cliente.getContas().size()) {
            cliente.getContas().remove(indice);
        }
    }

    public void atualizarConta(String cpf, int indice, Conta contaAtualizada) {
        Cliente cliente = banco.getCliente(cpf);
        if (cliente != null && indice >= 0 && indice < cliente.getContas().size()) {
            cliente.getContas().set(indice, contaAtualizada);
        }
    }
}
