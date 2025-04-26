package com.criptoAtivos.dao;

import com.criptoAtivos.entities.Venda;
import com.criptoAtivos.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {

    public void insert(Venda venda) {
        String sql = "INSERT INTO tb_venda (IDTRANSACAO, VALORVENDA) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, venda.getIdTransacao());
            stmt.setDouble(2, venda.getValorVenda());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
