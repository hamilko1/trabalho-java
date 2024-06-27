package Controller;

import Model.Conta;

public class OperacoesController {
    
    public boolean depositar(Conta conta, double valor) {
        if (valor <= 0) {
            return false;
        }
        conta.depositar(valor);
        return true;
    }
    
    public boolean sacar(Conta conta, double valor) {
        if (valor <= 0 || valor > conta.getSaldo() + conta.getLimite()) {
            return false;
        }
        return conta.sacar(valor);
    }
    
    public double getSaldo(Conta conta) {
        return conta.getSaldo();
    }
}
