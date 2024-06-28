package Controller;

import Model.Banco;
import Model.Diretor;
import Model.Gerente;

public class DiretorController {
    // Declaração do atributo privado banco, que será usado para manipular os gerentes no banco de dados.
    private Banco banco;

    // Construtor da classe DiretorController que inicializa o atributo banco.
    public DiretorController(Banco banco) {
        this.banco = banco;
    }

    // Método para cadastrar um novo gerente, realizado por um diretor.
    public void cadastrarGerente(Diretor diretor, Gerente gerente) {
        // Adiciona o gerente à lista de funcionários do banco.
        banco.adicionarFuncionario(gerente);
    }

    // Método para deletar um gerente existente, realizado por um diretor.
    public void deletarGerente(Diretor diretor, Gerente gerente) {
        // Remove o gerente da lista de funcionários do banco usando a matrícula do gerente.
        banco.getFuncionarios().remove(gerente.getMatricula());
    }
}
