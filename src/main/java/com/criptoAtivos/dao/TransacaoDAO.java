package com.criptoAtivos.dao;

import com.criptoAtivos.entities.Transacao;
import com.criptoAtivos.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransacaoDAO {

    public void insert(Transacao transacao) {
        String sql = "INSERT INTO tb_transacao (idtransacao, usuario, criptoativo, tipo, quantidade, data, taxa, carteira) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, transacao.getIdTransacao());
            stmt.setString(2, transacao.getUsuario().getIdUsuario());
            stmt.setString(3, transacao.getCriptoativo().getIdCripto());
            stmt.setString(4, transacao.getTipo());
            stmt.setDouble(5, transacao.getQuantidade());
            stmt.setTimestamp(6, new java.sql.Timestamp(transacao.getData().getTime()));
            stmt.setDouble(7, transacao.getTaxa());
            stmt.setString(8, transacao.getCarteira().getIdCarteira());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
