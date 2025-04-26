package com.criptoAtivos.entities;

import java.util.Date;

public class Compra extends Transacao {
    private final double valorCompra;

    public Compra(String idTransacao, String tipo, double quantidade, Date data, Usuario usuario, CryptoAtivo criptoativo, double taxa, Carteira carteira, double valorCompra) {
        super(idTransacao, tipo, quantidade, data, usuario, criptoativo, taxa, carteira);
        this.valorCompra = valorCompra;
    }

    public Compra(String idTransacao, double valorCompra) {
        super(idTransacao);
        this.valorCompra = valorCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public double calcularTaxaCompra() {
        return getQuantidade() * 0.02;
    }
}