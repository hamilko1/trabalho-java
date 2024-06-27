package Controller;

import Model.Banco;
import Model.Cliente;

public class ClienteController {
    private Banco banco;

    public ClienteController(Banco banco) {
        this.banco = banco;
    }

    public void adicionarCliente(Cliente cliente) {
        banco.adicionarCliente(cliente);
    }

    public Cliente getCliente(String cpf) {
        return banco.getCliente(cpf);
    }

    public void removerCliente(String cpf) {
        banco.getClientes().remove(cpf);
    }

    public void atualizarCliente(Cliente cliente) {
        banco.getClientes().put(cliente.getCpf(), cliente);
    }
}
