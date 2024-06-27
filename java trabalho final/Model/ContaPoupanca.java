package Model;

public class ContaPoupanca extends Conta {
    private int numero;
    private String tipo;
    private double taxaRendimento; // Taxa de rendimento da poupança

    public ContaPoupanca(int numero, double saldo, double taxaRendimento) {
        super(saldo, 0.0); // Limite da poupança geralmente é zero
        this.numero = numero;
        this.tipo = "Poupança";
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void render() {
        // Implementação específica para rendimento da poupança
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
