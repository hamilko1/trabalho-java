package Controller;

import Model.Banco;
import Model.Funcionario;
import Model.Cliente;

public class LoginController {
    private Banco banco;

    public LoginController(Banco banco) {
        this.banco = banco;
    }

    public Funcionario login(String matricula, String senha) {
        return banco.autenticarFuncionario(matricula, senha);
    }

    public boolean isGerente(Funcionario funcionario) {
        // Implementação fictícia para verificar se o funcionário é um gerente
        return funcionario.getMatricula().equals("12345"); // Exemplo: matrícula de gerente
    }

    public Cliente getCliente(Funcionario funcionario) {
        // Implementação fictícia para obter o cliente associado ao funcionário
        return banco.getCliente(funcionario.getMatricula()); // Supondo que o banco tenha método para isso
    }

    public Banco getBanco() {
        return banco;
    }
}
