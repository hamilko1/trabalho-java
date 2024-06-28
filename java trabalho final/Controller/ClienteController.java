package Controller;

import Model.Banco;
import Model.Cliente;

public class ClienteController {
    // Declaração do atributo privado banco, que será usado para manipular os clientes no banco de dados.
    private Banco banco;

    // Construtor da classe ClienteController que inicializa o atributo banco.
    public ClienteController(Banco banco) {
        this.banco = banco;
    }

    // Método para adicionar um cliente ao banco de dados.
    public void adicionarCliente(Cliente cliente) {
        banco.adicionarCliente(cliente);
    }

    // Método para obter um cliente a partir do seu CPF.
    public Cliente getCliente(String cpf) {
        return banco.getCliente(cpf);
    }

    // Método para remover um cliente do banco de dados a partir do seu CPF.
    public void removerCliente(String cpf) {
        banco.getClientes().remove(cpf);
    }

    // Método para atualizar as informações de um cliente no banco de dados.
    public void atualizarCliente(Cliente cliente) {
        banco.getClientes().put(cliente.getCpf(), cliente);
    }
}
