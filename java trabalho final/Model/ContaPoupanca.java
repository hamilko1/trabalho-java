package Model;

public class ContaPoupanca extends Conta {
    private int numero; // Número da conta poupança
    private String tipo; // Tipo de conta ("Poupança" neste caso)
    private double taxaRendimento; // Taxa de rendimento da poupança

    // Construtor que inicializa uma conta poupança com número, saldo inicial e taxa de rendimento
    public ContaPoupanca(int numero, double saldo, double taxaRendimento) {
        super(saldo, 0.0); // Chama o construtor da superclasse Conta, define limite como zero
        this.numero = numero;
        this.tipo = "Poupança"; // Define o tipo como "Poupança"
        this.taxaRendimento = taxaRendimento; // Define a taxa de rendimento da poupança
    }

    // Implementação do método abstrato render() para conta poupança
    @Override
    public void render() {
        // Calcula o rendimento da poupança com base na taxa de rendimento
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento; // Adiciona o rendimento ao saldo da conta
    }

    // Método para obter o número da conta
    @Override
    public int getNumero() {
        return numero;
    }

    // Método para obter o tipo da conta
    @Override
    public String getTipo() {
        return tipo;
    }
}
