package com.criptoAtivos.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plataforma {
    private String idPlataforma;
    private final List<Carteira> carteiras;
    private final List<Usuario> usuarios;
    private final List<Transacao> transacoes;
    private final List<Alerta> alertas;
    private final List<Educacao> educacao;
    private final List<InstituicaoFinanceira> instituicoes;

    public Plataforma(String idPlataforma) {
        this.idPlataforma = idPlataforma;
        this.carteiras = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.transacoes = new ArrayList<>();
        this.alertas = new ArrayList<>();
        this.educacao = new ArrayList<>();
        this.instituicoes = new ArrayList<>();
    }

    public String getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(String idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public List<Carteira> getCarteiras() {
        return Collections.unmodifiableList(carteiras);
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public List<Transacao> getTransacoes() {
        return Collections.unmodifiableList(transacoes);
    }

    public List<Alerta> getAlertas() {
        return Collections.unmodifiableList(alertas);
    }

    public List<Educacao> getEducacao() {
        return Collections.unmodifiableList(educacao);
    }

    public List<InstituicaoFinanceira> getInstituicoes() {
        return Collections.unmodifiableList(instituicoes);
    }

    public void adicionarCarteira(Carteira carteira) {
        if (carteira != null && !carteiras.contains(carteira)) {
            carteiras.add(carteira);
        }
    }

    public void removerCarteira(Carteira carteira) {
        carteiras.remove(carteira);
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void adicionarTransacao(Transacao transacao) {
        if (transacao != null) {
            transacoes.add(transacao);
        }
    }

    public void removerTransacao(Transacao transacao) {
        transacoes.remove(transacao);
    }

    public void adicionarAlerta(Alerta alerta) {
        if (alerta != null) {
            alertas.add(alerta);
        }
    }

    public void removerAlerta(Alerta alerta) {
        alertas.remove(alerta);
    }

    public void adicionarEducacao(Educacao material) {
        if (material != null && !educacao.contains(material)) {
            educacao.add(material);
        }
    }

    public void removerEducacao(Educacao material) {
        educacao.remove(material);
    }

    public void adicionarInstituicao(InstituicaoFinanceira instituicao) {
        if (instituicao != null && !instituicoes.contains(instituicao)) {
            instituicoes.add(instituicao);
        }
    }

    public void removerInstituicao(InstituicaoFinanceira instituicao) {
        instituicoes.remove(instituicao);
    }

    public void realizarTransacao(Transacao transacao) {
        if (transacao == null) throw new IllegalArgumentException("Transação inválida.");
        Carteira carteira = transacao.getCarteira();

        switch (transacao.getTipo().toLowerCase()) {
            case "compra":
                carteira.depositar(transacao.getQuantidade());
                break;
            case "venda":
                carteira.retirar(transacao.getQuantidade());
                break;
            default:
                throw new IllegalArgumentException("Tipo de transação desconhecido.");
        }

        adicionarTransacao(transacao);
    }

    public Usuario buscarUsuarioPorId(String idUsuario) {
        return usuarios.stream().filter(u -> u.getIdUsuario().equals(idUsuario)).findFirst().orElse(null);
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        return usuarios.stream().filter(u -> u.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    public Carteira buscarCarteiraPorId(String idCarteira) {
        return carteiras.stream().filter(c -> c.getIdCarteira().equals(idCarteira)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Plataforma ID: " + idPlataforma + ", Usuários cadastrados: " + usuarios.size();
    }
}
