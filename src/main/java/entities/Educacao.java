package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Educacao {
    private final String idEducacao;
    private final String conteudo;
    private final String nivel;
    private final List<Usuario> usuarios;

    public Educacao(String idEducacao, String conteudo, String nivel) {
        this.idEducacao = idEducacao;
        this.conteudo = conteudo;
        this.nivel = nivel;
        this.usuarios = new ArrayList<>();
    }

    public String getIdEducacao() {
        return idEducacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getNivel() {
        return nivel;
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }
}
