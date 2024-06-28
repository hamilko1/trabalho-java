package Model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    protected String nome;       // Nome da pessoa
    protected String endereco;   // Endereço da pessoa
    protected String rg;         // RG da pessoa
    protected String cpf;        // CPF da pessoa
    protected String telefone;   // Telefone da pessoa

    // Construtor para inicializar os atributos nome, endereco, rg, cpf e telefone
    public Pessoa(String nome, String endereco, String rg, String cpf, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Getters e Setters para acessar e modificar os atributos da classe

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
