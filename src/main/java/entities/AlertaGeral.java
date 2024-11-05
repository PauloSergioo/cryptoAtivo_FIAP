package entities;

import java.util.Date;

public class AlertaGeral extends Alerta {
    private String categoria;

    public AlertaGeral(String idAlerta, String tipo, String mensagem, Usuario usuario, CryptoAtivo criptoativo, Date data, String categoria) {
        super(idAlerta, tipo, mensagem, usuario, criptoativo, data);
        this.categoria = categoria;
    }

    public void enviarNotificacaoGeral() {
        System.out.println("Notificação geral enviada: " + getMensagem());
    }
}
