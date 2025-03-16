package com.criptoAtivos.entities;

import java.util.Date;

public class Compra extends Transacao {
    private double valorCompra;

    public Compra(String idTransacao, String tipo, double quantidade, Date data, Usuario usuario, CryptoAtivo criptoativo, double taxa, Carteira carteira, double valorCompra) {
        super(idTransacao, tipo, quantidade, data, usuario, criptoativo, taxa, carteira);
        this.valorCompra = valorCompra;
    }

    public double calcularTaxaCompra() {
        return getQuantidade() * 0.02;
    }
}