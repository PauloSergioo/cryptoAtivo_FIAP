package com.criptoAtivos.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private final String idUsuario;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String perfil;
    private Carteira carteira;


    public Usuario(String idUsuario, String cpf, String nome, String email, String senha, String perfil, Carteira carteira) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.carteira = carteira;
    }

    public Usuario(String idUsuario, Carteira carteira) {
        this.idUsuario = idUsuario;
        this.carteira = carteira;
    }

    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String idUsuario, String cpf, String nome, String email, String senha, String perfil) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {

        int tamanhoTabela = 40;
        String linha = "+" + "-".repeat(tamanhoTabela - 2) + "+";

        String dados = String.format(
                "| %-10s: %-25s |\n" +
                        "| %-10s: %-25s |\n" +
                        "| %-10s: %-25s |\n" +
                        "| %-10s: %-25s |",
                "Nome", nome,
                "Email", email,
                "Perfil", perfil,
                "CPF", cpf
        );

        return linha + "\n" +
                "| Dados do Usuário" + " ".repeat(tamanhoTabela - 19) + "|\n" +
                linha + "\n" +
                dados + "\n" +
                linha;
    }

}
