package entities;

import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private final String idCarteira;
    private double saldo;
    private final Usuario usuario;
    private final List<Transacao> transacoes;

    public Carteira(String idCarteira, double saldo, Usuario usuario) {
        this.idCarteira = idCarteira;
        this.saldo = saldo;
        this.usuario = usuario;
        this.transacoes = new ArrayList<>();
    }

    public String getIdCarteira() {
        return idCarteira;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Valor de retirada inválido.");
        }
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    @Override
    public String toString() {
        return "ID: " + idCarteira + ", Saldo: " + saldo + ", Usuário: " + usuario.getNome();
    }

}
