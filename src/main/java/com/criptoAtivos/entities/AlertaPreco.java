package com.criptoAtivos.entities;

import java.util.Date;

public class AlertaPreco extends Alerta {
    private final double limitePreco;

    public AlertaPreco(String idAlerta, String tipo, String mensagem, Usuario usuario, CryptoAtivo criptoativo, Date data, double limitePreco) {
        super(idAlerta, tipo, mensagem, usuario, criptoativo, data);
        this.limitePreco = limitePreco;
    }

    public boolean verificarLimite(double precoAtual) {
        return precoAtual >= limitePreco;
    }
}