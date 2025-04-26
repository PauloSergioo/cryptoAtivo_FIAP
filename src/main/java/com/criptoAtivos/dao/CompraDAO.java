package com.criptoAtivos.dao;

import com.criptoAtivos.entities.Compra;
import com.criptoAtivos.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraDAO {

    public void insert(Compra compra) {
        String sql = "INSERT INTO tb_compra (IDTRANSACAO, VALORCOMPRA) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compra.getIdTransacao());
            stmt.setDouble(2, compra.getValorCompra());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
