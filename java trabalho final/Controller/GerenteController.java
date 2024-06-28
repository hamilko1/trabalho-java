package Controller;

import Model.Banco;
import Model.Cliente;
import Model.Gerente;
import Model.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GerenteController {
    // Declaração do atributo privado banco, que será usado para manipular os clientes e contas no banco de dados.
    private Banco banco;

    // Construtor da classe GerenteController que inicializa o atributo banco.
    public GerenteController(Banco banco) {
        this.banco = banco;
    }

    // Método para cadastrar um novo cliente, realizado por um gerente.
    public void cadastrarCliente(Gerente gerente, Cliente cliente) {
        // Adiciona o cliente à lista de clientes do gerente.
        gerente.adicionarCliente(cliente);
        // Adiciona o cliente à lista de clientes do banco.
        banco.adicionarCliente(cliente);
    }

    // Método para cadastrar uma nova conta para um cliente específico.
    public void cadastrarConta(Cliente cliente, Conta conta) {
        // Adiciona a nova conta ao cliente.
        cliente.adicionarConta(conta);
    }

    // Método para listar todos os clientes do banco.
    public List<Cliente> listarClientes() {
        // Converte o mapa de clientes do banco para uma lista e retorna.
        Map<String, Cliente> clientesMap = banco.getClientes();
        return new ArrayList<>(clientesMap.values());
    }

    // Método para listar todas as contas de um cliente específico.
    public List<Conta> listarContasCliente(Cliente cliente) {
        // Retorna a lista de contas do cliente.
        return cliente.getContas();
    }

    // Método para obter o banco associado a este controlador.
    public Banco getBanco() {
        return banco;
    }
}
