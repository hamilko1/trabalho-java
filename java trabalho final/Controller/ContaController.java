package Controller;

import Model.Banco;
import Model.Cliente;
import Model.Conta;

public class ContaController {
    // Declaração do atributo privado banco, que será usado para manipular as contas dos clientes no banco de dados.
    private Banco banco;

    // Construtor da classe ContaController que inicializa o atributo banco.
    public ContaController(Banco banco) {
        this.banco = banco;
    }

    // Método para adicionar uma conta a um cliente específico identificado pelo seu CPF.
    public void adicionarConta(String cpf, Conta conta) {
        // Obtém o cliente a partir do CPF.
        Cliente cliente = banco.getCliente(cpf);
        // Se o cliente for encontrado, adiciona a nova conta a ele.
        if (cliente != null) {
            cliente.adicionarConta(conta);
        }
    }

    // Método para obter uma conta de um cliente específico identificado pelo seu CPF e índice da conta.
    public Conta getConta(String cpf, int indice) {
        // Obtém o cliente a partir do CPF.
        Cliente cliente = banco.getCliente(cpf);
        // Se o cliente for encontrado e o índice for válido, retorna a conta no índice especificado.
        if (cliente != null && indice >= 0 && indice < cliente.getContas().size()) {
            return cliente.getContas().get(indice);
        }
        // Retorna null se o cliente não for encontrado ou o índice for inválido.
        return null;
    }

    // Método para remover uma conta de um cliente específico identificado pelo seu CPF e índice da conta.
    public void removerConta(String cpf, int indice) {
        // Obtém o cliente a partir do CPF.
        Cliente cliente = banco.getCliente(cpf);
        // Se o cliente for encontrado e o índice for válido, remove a conta no índice especificado.
        if (cliente != null && indice >= 0 && indice < cliente.getContas().size()) {
            cliente.getContas().remove(indice);
        }
    }

    // Método para atualizar uma conta de um cliente específico identificado pelo seu CPF e índice da conta.
    public void atualizarConta(String cpf, int indice, Conta contaAtualizada) {
        // Obtém o cliente a partir do CPF.
        Cliente cliente = banco.getCliente(cpf);
        // Se o cliente for encontrado e o índice for válido, atualiza a conta no índice especificado com os novos dados.
        if (cliente != null && indice >= 0 && indice < cliente.getContas().size()) {
            cliente.getContas().set(indice, contaAtualizada);
        }
    }
}
