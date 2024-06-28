package Model;

public abstract class Conta {
    protected double saldo; // Saldo da conta
    protected double limite; // Limite de crédito da conta

    // Construtor para inicializar saldo e limite da conta
    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }

    // Método abstrato para renderização de rendimentos (deve ser implementado nas subclasses)
    public abstract void render();

    // Método para realizar um depósito na conta
    public void depositar(double valor) {
        saldo += valor;
    }

    // Método para realizar um saque da conta
    public boolean sacar(double valor) {
        if (valor <= saldo + limite) { // Verifica se há saldo disponível mais o limite
            saldo -= valor;
            return true; // Saque realizado com sucesso
        }
        return false; // Saldo insuficiente
    }

    // Método para realizar uma transferência desta conta para outra conta de destino
    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) { // Tenta sacar o valor da conta atual
            destino.depositar(valor); // Deposita o valor na conta de destino
            return true; // Transferência realizada com sucesso
        }
        return false; // Transferência não realizada devido a saldo insuficiente
    }

    // Métodos getters e setters para saldo e limite
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    // Método abstrato para obter o número da conta (deve ser implementado nas subclasses)
    public abstract int getNumero();

    // Método fictício para exemplificar obtenção do tipo da conta (deve ser implementado nas subclasses)
    public abstract String getTipo();
}
