package com.criptoAtivos.entities;

import java.util.List;

public class Administrador extends Usuario {
    private String nivelAcesso;

    public Administrador(String idUsuario, String nome, String email, String senha, String perfil, String nivelAcesso, String cpf) {
        super(idUsuario, nome, email, senha, perfil, cpf);
        this.nivelAcesso = nivelAcesso;
    }

    public void gerenciarAlertas(List<Alerta> alertas) {
        System.out.println("Gerenciamento de alertas em andamento.");
    }

    public void monitorarUsuarios(List<Usuario> usuarios) {
        System.out.println("Monitoramento de usuários em andamento.");
    }
}