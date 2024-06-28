package Controller;

import Model.Banco;
import Model.Funcionario;
import Model.Cliente;

public class LoginController {
    // Declaração do atributo privado banco, que será usado para autenticar funcionários e obter informações do banco de dados.
    private Banco banco;

    // Construtor da classe LoginController que inicializa o atributo banco.
    public LoginController(Banco banco) {
        this.banco = banco;
    }

    // Método para autenticar um funcionário com base em sua matrícula e senha.
    public Funcionario login(String matricula, String senha) {
        // Chama o método de autenticação do banco para verificar as credenciais do funcionário.
        return banco.autenticarFuncionario(matricula, senha);
    }

    // Método fictício para verificar se um funcionário é um gerente.
    public boolean isGerente(Funcionario funcionario) {
        // Implementação de exemplo que verifica se a matrícula do funcionário é igual a um valor específico.
        return funcionario.getMatricula().equals("12345"); // Exemplo: matrícula de gerente
    }

    // Método fictício para obter o cliente associado a um funcionário.
    public Cliente getCliente(Funcionario funcionario) {
        // Supondo que o banco tenha um método para obter um cliente a partir da matrícula do funcionário.
        return banco.getCliente(funcionario.getMatricula());
    }

    // Método para obter o banco associado a este controlador.
    public Banco getBanco() {
        return banco;
    }
}
