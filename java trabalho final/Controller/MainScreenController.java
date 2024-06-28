package Controller;

import Model.Funcionario;

public class MainScreenController {
    // Declaração do atributo privado funcionario, que representa o funcionário logado no sistema.
    private Funcionario funcionario;

    // Construtor da classe MainScreenController que inicializa o atributo funcionario.
    public MainScreenController(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    // Método para realizar o logout do funcionário.
    public void logout() {
        // Implementação do logout, se necessário.
        // Esta implementação pode ser expandida para limpar sessões ou outros dados relacionados ao logout.
    }

    // Método para abrir a tela de operações do cliente.
    public void abrirOperacoesCliente() {
        // Lógica para abrir a tela de operações do cliente.
        // Exemplo simplificado: imprime no console o nome do funcionário que está acessando as operações do cliente.
        System.out.println("Abrindo operações do cliente para o funcionário: " + funcionario.getNome());
    }

    // Outros métodos de operações conforme necessidade.
    // Este espaço pode ser usado para adicionar mais funcionalidades relacionadas à tela principal do sistema.
}
