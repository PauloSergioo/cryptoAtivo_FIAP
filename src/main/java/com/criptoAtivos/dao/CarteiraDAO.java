package com.criptoAtivos.dao;

import com.criptoAtivos.entities.Carteira;
import com.criptoAtivos.entities.Usuario;
import com.criptoAtivos.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarteiraDAO {

    public Carteira getByIdUsuario(String idUsuario) {
        String sql = "SELECT * FROM tb_carteira WHERE usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("usuario"));

                return new Carteira(
                        rs.getString("IDCARTEIRA"),
                        rs.getDouble("saldo"),
                        usuario
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Carteira carteira) {
        String sql = "INSERT INTO tb_carteira (IDCARTEIRA, usuario, saldo) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carteira.getIdCarteira());
            stmt.setString(2, carteira.getUsuario().getIdUsuario());
            stmt.setDouble(3, carteira.getSaldo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Carteira carteira) {
        String sql = "UPDATE tb_carteira SET saldo = ? WHERE IDCARTEIRA = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, carteira.getSaldo());
            stmt.setString(2, carteira.getIdCarteira());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
