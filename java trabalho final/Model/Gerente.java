package Model;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Funcionario {
    private List<Cliente> clientes;

    public Gerente(String nome, String endereco, String rg, String cpf, String telefone, String matricula, String senha) {
        super(nome, endereco, rg, cpf, telefone, matricula, senha);
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Métodos para cadastrar clientes e contas
    // Getters and Setters
}
