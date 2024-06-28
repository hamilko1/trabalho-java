package Model;

public class ContaCorrente extends Conta {
    private int numero; // Número da conta corrente
    private String tipo; // Tipo de conta ("Corrente" neste caso)

    // Construtor que inicializa uma conta corrente com número, saldo e limite
    public ContaCorrente(int numero, double saldo, double limite) {
        super(saldo, limite); // Chama o construtor da superclasse Conta
        this.numero = numero;
        this.tipo = "Corrente"; // Define o tipo como "Corrente"
    }

    // Implementação do método abstrato render() para conta corrente (pode ser vazio se não houver rendimento específico)
    @Override
    public void render() {
        // Implementação específica para rendimento de conta corrente, se houver
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
