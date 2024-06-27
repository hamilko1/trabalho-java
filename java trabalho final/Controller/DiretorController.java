package Controller;

import Model.Banco;
import Model.Diretor;
import Model.Gerente;

public class DiretorController {
    private Banco banco;

    public DiretorController(Banco banco) {
        this.banco = banco;
    }

    public void cadastrarGerente(Diretor diretor, Gerente gerente) {
        banco.adicionarFuncionario(gerente);
    }

    public void deletarGerente(Diretor diretor, Gerente gerente) {
        banco.getFuncionarios().remove(gerente.getMatricula());
    }
}
