package Controller;

import Model.Conta;

public class OperacoesController {

    // Método para realizar um depósito em uma conta.
    public boolean depositar(Conta conta, double valor) {
        // Verifica se o valor do depósito é positivo.
        if (valor <= 0) {
            return false; // Retorna false se o valor for inválido.
        }
        // Chama o método depositar da classe Conta para adicionar o valor ao saldo da conta.
        conta.depositar(valor);
        return true; // Retorna true indicando que o depósito foi bem-sucedido.
    }

    // Método para realizar um saque de uma conta.
    public boolean sacar(Conta conta, double valor) {
        // Verifica se o valor do saque é positivo e se não excede o saldo disponível mais o limite.
        if (valor <= 0 || valor > conta.getSaldo() + conta.getLimite()) {
            return false; // Retorna false se o valor for inválido ou exceder o saldo disponível.
        }
        // Chama o método sacar da classe Conta para subtrair o valor do saldo da conta.
        return conta.sacar(valor); // Retorna o resultado do método sacar.
    }

    // Método para obter o saldo de uma conta.
    public double getSaldo(Conta conta) {
        // Retorna o saldo atual da conta.
        return conta.getSaldo();
    }
}
