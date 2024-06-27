package Model;

public class ContaCorrente extends Conta {
    private int numero;
    private String tipo;

    public ContaCorrente(int numero, double saldo, double limite) {
        super(saldo, limite);
        this.numero = numero;
        this.tipo = "Corrente";
    }

    @Override
    public void render() {
        // Implementação específica para rendimento de conta corrente, se houver
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
