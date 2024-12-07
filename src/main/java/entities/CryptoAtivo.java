package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CryptoAtivo {
    private final String idCripto;
    private final String nome;
    private final double valorAtual;
    private double quantidade;
    private final List<Transacao> transacoes;
    private final List<HistoricoPreco> historicoPrecos;
    private final List<Alerta> alertas;
    private final List<Educacao> educacao;

    public CryptoAtivo(String idCripto, String nome, double valorAtual, double quantidade,
                       List<Transacao> transacoes, List<HistoricoPreco> historicoPrecos,
                       List<Alerta> alertas, List<Educacao> educacao) {
        this.idCripto = idCripto;
        this.nome = nome;
        this.valorAtual = valorAtual;
        this.quantidade = quantidade;
        this.transacoes = transacoes;
        this.historicoPrecos = historicoPrecos;
        this.alertas = alertas;
        this.educacao = educacao;
    }

    public String getIdCripto() {
        return idCripto;
    }

    public String getNome() {
        return nome;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public List<HistoricoPreco> getHistoricoPrecos() {
        return historicoPrecos;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public List<Educacao> getEducacao() {
        return educacao;
    }

    public void adicionarQuantidade(double quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        } else {
            throw new IllegalArgumentException("A quantidade a ser adicionada deve ser positiva.");
        }
    }

    public void retirarQuantidade(double quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade inválida para retirada.");
        }
    }

    public void adicionarHistoricoPreco(HistoricoPreco preco) {
        historicoPrecos.add(preco);
    }

    public void adicionarAlerta(Alerta alerta) {
        alertas.add(alerta);
    }

    public void adicionarEducacao(Educacao material) {
        educacao.add(material);
    }

    @Override
    public String toString() {
        return "ID: " + idCripto + ", Nome: " + nome + ", Valor Atual: " + valorAtual + ", Quantidade Disponível: " + quantidade;
    }

}
