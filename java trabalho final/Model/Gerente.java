package Model;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Funcionario {
    private List<Cliente> clientes; // Lista de clientes que o gerente gerencia

    // Construtor que inicializa um Gerente com nome, endereço, RG, CPF, telefone, matrícula e senha
    public Gerente(String nome, String endereco, String rg, String cpf, String telefone, String matricula, String senha) {
        super(nome, endereco, rg, cpf, telefone, matricula, senha); // Chama o construtor da superclasse Funcionario
        this.clientes = new ArrayList<>(); // Inicializa a lista de clientes como um ArrayList vazio
    }

    // Método para adicionar um cliente à lista de clientes que o gerente gerencia
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Getters e Setters para os atributos da classe Gerente

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
