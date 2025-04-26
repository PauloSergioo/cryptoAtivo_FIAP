package com.criptoAtivos.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private String idTransacao;
    private String tipo;
    private Double quantidade;
    private Date data;
    private Usuario usuario;
    private CryptoAtivo criptoativo;
    private Double taxa;
    private Carteira carteira;

    public Transacao(String idTransacao, String tipo, Double quantidade, Date data, Usuario usuario, CryptoAtivo criptoativo, Double taxa, Carteira carteira) {
        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.usuario = usuario;
        this.criptoativo = criptoativo;
        this.taxa = taxa;
        this.carteira = carteira;
    }

    public Transacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Date getData() {
        return data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public CryptoAtivo getCriptoativo() {
        return criptoativo;
    }

    public Double getTaxa() {
        return taxa;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public String exibirTransacao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Double valorTotal = quantidade * criptoativo.getValorAtual();
        Double valorComTaxa = valorTotal + taxa;

        return String.format(
                "ID: %s | Tipo: %s | Criptoativo: %s | Quantidade: %.4f | Valor Total: R$ %.2f | Taxa: R$ %.2f | Valor com Taxa: R$ %.2f | Data: %s",
                idTransacao,
                tipo,
                criptoativo.getNome(),
                quantidade,
                valorTotal,
                taxa,
                valorComTaxa,
                sdf.format(data)
        );
    }
}
