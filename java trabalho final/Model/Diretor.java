package Model;

public class Diretor extends Funcionario {

    // Construtor que inicializa um Diretor com nome, endereço, RG, CPF, telefone, matrícula e senha
    public Diretor(String nome, String endereco, String rg, String cpf, String telefone, String matricula, String senha) {
        super(nome, endereco, rg, cpf, telefone, matricula, senha); // Chama o construtor da superclasse Funcionario
    }

    // Métodos específicos para cadastrar ou deletar gerentes podem ser adicionados aqui
    // Exemplo de método para cadastrar um gerente
    public void cadastrarGerente(Gerente gerente) {
        // Lógica para cadastrar um gerente
    }

    // Exemplo de método para deletar um gerente
    public void deletarGerente(Gerente gerente) {
        // Lógica para deletar um gerente
    }
}
