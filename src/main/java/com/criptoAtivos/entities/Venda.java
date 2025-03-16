package com.criptoAtivos.entities;

import java.util.Date;

public class Venda extends Transacao {
    private final double valorVenda;

    public Venda(String idTransacao, String tipo, double quantidade, Date data, Usuario usuario, CryptoAtivo criptoativo, double taxa, Carteira carteira, double valorVenda) {
        super(idTransacao, tipo, quantidade, data, usuario, criptoativo, taxa, carteira);
        this.valorVenda = valorVenda;
    }

    public double calcularLucro() {
        return valorVenda - (getQuantidade() * getCriptoativo().getValorAtual());
    }
}
