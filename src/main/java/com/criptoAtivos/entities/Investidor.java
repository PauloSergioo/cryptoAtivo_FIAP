package com.criptoAtivos.entities;

import java.util.ArrayList;
import java.util.List;

public class Investidor extends Usuario {
    private String nivelInvestidor;

    public Investidor(String idUsuario, String nome, String email, String senha, String perfil, String nivelInvestidor, String cpf) {
        super(idUsuario, nome, email, senha, perfil, cpf);
        this.nivelInvestidor = nivelInvestidor;
    }

    public double consultarSaldo() {
        double saldoTotal = 0;
        for (Carteira carteira : getCarteiras()) {
            saldoTotal += carteira.getSaldo();
        }
        return saldoTotal;
    }

    public List<Transacao> verHistoricoTransacoes() {
        List<Transacao> historico = new ArrayList<>();
        for (Carteira carteira : getCarteiras()) {
            historico.addAll(carteira.getTransacoes());
        }
        return historico;
    }
}