package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private final String idTransacao;
    private final String tipo;
    private final double quantidade;
    private final Date data;
    private final Usuario usuario;
    private final CryptoAtivo criptoativo;
    private final double taxa;
    private final Carteira carteira;

    public Transacao(String idTransacao, String tipo, double quantidade, Date data, Usuario usuario, CryptoAtivo criptoativo, double taxa, Carteira carteira) {
        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.usuario = usuario;
        this.criptoativo = criptoativo;
        this.taxa = taxa;
        this.carteira = carteira;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getQuantidade() {
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

    public double getTaxa() {
        return taxa;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public String exibirTransacao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        double valorTotal = quantidade * criptoativo.getValorAtual();
        double valorComTaxa = valorTotal + taxa;

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
