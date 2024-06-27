package Model;

public class Funcionario {
    private String nome;
    private String endereco;
    private String cpf;
    private String rg;
    private String telefone;
    private String matricula;
    private String senha;
    private Cliente cliente; // Adicionado para armazenar cliente associado (opcional)

    public Funcionario(String nome, String endereco, String cpf, String rg, String telefone, String matricula, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }

    // Exemplo de método para verificar se é gerente
    public boolean isGerente() {
        return matricula.equals("12345"); // Implemente sua lógica adequada aqui
    }

    // Exemplo de método para obter o cliente associado
    public Cliente getCliente() {
        return cliente; // Implemente conforme a lógica de associação cliente-funcionário
    }

    // Método para associar um cliente ao funcionário (opcional)
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
