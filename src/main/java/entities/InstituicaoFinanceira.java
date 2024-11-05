package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstituicaoFinanceira {
    private final String idInstituicao;
    private final String nome;
    private final String tipo;
    private final List<Usuario> usuarios;
    private final List<Transacao> transacoes;

    public InstituicaoFinanceira(String idInstituicao, String nome, String tipo) {
        this.idInstituicao = idInstituicao;
        this.nome = nome;
        this.tipo = tipo;
        this.usuarios = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    public String getIdInstituicao() {
        return idInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public List<Transacao> getTransacoes() {
        return Collections.unmodifiableList(transacoes);
    }

    public void adicionarTransacao(Transacao transacao) {
        if (transacao != null && !transacoes.contains(transacao)) {
            transacoes.add(transacao);
        }
    }
}
