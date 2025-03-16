package com.criptoAtivos.entities;

import java.util.Date;

public class Alerta {
    private final String idAlerta;
    private String tipo;
    private String mensagem;
    private Usuario usuario;
    private CryptoAtivo criptoativo;
    private Date data;

    public Alerta(String idAlerta, String tipo, String mensagem, Usuario usuario, CryptoAtivo criptoativo, Date data) {
        this.idAlerta = idAlerta;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.usuario = usuario;
        this.criptoativo = criptoativo;
        this.data = data;
    }

    public String getIdAlerta() {
        return idAlerta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public CryptoAtivo getCriptoativo() {
        return criptoativo;
    }

    public Date getData() {
        return data;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCriptoativo(CryptoAtivo criptoativo) {
        this.criptoativo = criptoativo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String exibirAlerta() {
        return String.format("Alerta [%s]: %s - %s para o usuário %s sobre o ativo %s na data %s",
                idAlerta, tipo, mensagem, usuario.getNome(), criptoativo.getNome(), data.toString());
    }
}
