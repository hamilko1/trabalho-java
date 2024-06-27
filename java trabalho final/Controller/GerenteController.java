package Controller;

import Model.Banco;
import Model.Cliente;
import Model.Gerente;
import Model.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GerenteController {
    private Banco banco;

    public GerenteController(Banco banco) {
        this.banco = banco;
    }

    public void cadastrarCliente(Gerente gerente, Cliente cliente) {
        gerente.adicionarCliente(cliente);
        banco.adicionarCliente(cliente);
    }

    public void cadastrarConta(Cliente cliente, Conta conta) {
        cliente.adicionarConta(conta);
    }

    public List<Cliente> listarClientes() {
        // Converte o mapa de clientes para uma lista
        Map<String, Cliente> clientesMap = banco.getClientes();
        return new ArrayList<>(clientesMap.values());
    }

    public List<Conta> listarContasCliente(Cliente cliente) {
        return cliente.getContas(); // Supondo que Cliente tem um método para obter as contas
    }

    public Banco getBanco() {
        return banco;
    }
}
