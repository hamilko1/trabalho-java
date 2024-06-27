package Controller;

import Model.Funcionario;

public class MainScreenController {
    private Funcionario funcionario;

    public MainScreenController(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void logout() {
        // Implementação do logout, se necessário
    }

    public void abrirOperacoesCliente() {
        // Lógica para abrir tela de operações do cliente
        // Exemplo simplificado:
        System.out.println("Abrindo operações do cliente para o funcionário: " + funcionario.getNome());
    }

    // Outras operações conforme necessidade
}
