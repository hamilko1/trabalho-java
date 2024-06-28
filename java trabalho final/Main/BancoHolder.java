package Main;

import Model.Banco;

public class BancoHolder {
    // Declaração do atributo privado banco, que armazena uma instância da classe Banco.
    private Banco banco;

    // Método getter para obter o objeto Banco armazenado.
    public Banco getBanco() {
        return banco;
    }

    // Método setter para definir o objeto Banco a ser armazenado.
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
