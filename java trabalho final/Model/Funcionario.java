package Model;

public class Funcionario {
    private String nome; // Nome do funcionário
    private String endereco; // Endereço do funcionário
    private String cpf; // CPF do funcionário
    private String rg; // RG do funcionário
    private String telefone; // Telefone do funcionário
    private String matricula; // Matrícula do funcionário
    private String senha; // Senha do funcionário
    private Cliente cliente; // Referência opcional para o cliente associado ao funcionário

    // Construtor que inicializa um Funcionário com nome, endereço, CPF, RG, telefone, matrícula e senha
    public Funcionario(String nome, String endereco, String cpf, String rg, String telefone, String matricula, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.matricula = matricula;
        this.senha = senha;
    }

    // Método para obter o nome do funcionário
    public String getNome() {
        return nome;
    }

    // Método para obter o endereço do funcionário
    public String getEndereco() {
        return endereco;
    }

    // Método para obter o CPF do funcionário
    public String getCpf() {
        return cpf;
    }

    // Método para obter o RG do funcionário
    public String getRg() {
        return rg;
    }

    // Método para obter o telefone do funcionário
    public String getTelefone() {
        return telefone;
    }

    // Método para obter a matrícula do funcionário
    public String getMatricula() {
        return matricula;
    }

    // Método para obter a senha do funcionário
    public String getSenha() {
        return senha;
    }

    // Exemplo de método para verificar se o funcionário é gerente (implemente a lógica conforme necessário)
    public boolean isGerente() {
        return matricula.equals("12345"); // Exemplo simples de lógica para verificar se é gerente
    }

    // Exemplo de método para obter o cliente associado ao funcionário (opcional)
    public Cliente getCliente() {
        return cliente; // Implemente conforme a lógica de associação cliente-funcionário
    }

    // Método para associar um cliente ao funcionário (opcional)
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
