package entities;

import java.util.Date;

public class HistoricoPreco {
    private String idHistoricoPreco;
    private Date data;
    private double preco;
    private CryptoAtivo criptoativo;

    public HistoricoPreco(String idHistoricoPreco, Date data, double preco, CryptoAtivo criptoativo) {
        this.idHistoricoPreco = idHistoricoPreco;
        this.data = data;
        this.preco = preco;
        this.criptoativo = criptoativo;
    }

    public String getIdHistoricoPreco() {
        return idHistoricoPreco;
    }

    public void setIdHistoricoPreco(String idHistoricoPreco) {
        this.idHistoricoPreco = idHistoricoPreco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CryptoAtivo getCriptoativo() {
        return criptoativo;
    }

    public void setCriptoativo(CryptoAtivo criptoativo) {
        this.criptoativo = criptoativo;
    }
}
