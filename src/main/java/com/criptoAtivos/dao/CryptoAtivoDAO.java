package com.criptoAtivos.dao;

import com.criptoAtivos.entities.*;
import com.criptoAtivos.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CryptoAtivoDAO {

    public CryptoAtivo getById(String idCripto) {
        CryptoAtivo criptoAtivo = null;
        String sql = "SELECT * FROM tb_cryptoativo WHERE idCripto = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idCripto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                double valorAtual = rs.getDouble("valorAtual");
                double quantidade = rs.getDouble("quantidade");

                List<Transacao> transacoes = getTransacoes(idCripto);
                List<HistoricoPreco> historicoPrecos = getHistoricoPrecos(idCripto);
                List<Alerta> alertas = getAlertas(idCripto);
                List<Educacao> educacao = getEducacao(idCripto);

                criptoAtivo = new CryptoAtivo(
                        idCripto, nome, valorAtual, quantidade, transacoes, historicoPrecos, alertas, educacao
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return criptoAtivo;
    }

    private List<Transacao> getTransacoes(String idCripto) {
        return new ArrayList<>();
    }

    private List<HistoricoPreco> getHistoricoPrecos(String idCripto) {
        return new ArrayList<>();
    }

    private List<Alerta> getAlertas(String idCripto) {
        return new ArrayList<>();
    }

    private List<Educacao> getEducacao(String idCripto) {
        return new ArrayList<>();
    }

    public List<CryptoAtivo> getAll() {
        List<CryptoAtivo> criptoAtivos = new ArrayList<>();
        String sql = "SELECT * FROM tb_cryptoativo";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String idCripto = rs.getString("idCripto");
                String nome = rs.getString("nome");
                double valorAtual = rs.getDouble("valorAtual");
                double quantidade = rs.getDouble("quantidade");

                List<Transacao> transacoes = getTransacoes(idCripto);
                List<HistoricoPreco> historicoPrecos = getHistoricoPrecos(idCripto);
                List<Alerta> alertas = getAlertas(idCripto);
                List<Educacao> educacao = getEducacao(idCripto);

                criptoAtivos.add(new CryptoAtivo(
                        idCripto, nome, valorAtual, quantidade, transacoes, historicoPrecos, alertas, educacao
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return criptoAtivos;
    }

    public CryptoAtivo getByNome(String nome) {
        CryptoAtivo criptoAtivo = null;
        String sql = "SELECT * FROM tb_cryptoativo WHERE nome = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String idCripto = rs.getString("idCripto");
                double valorAtual = rs.getDouble("valorAtual");
                double quantidade = rs.getDouble("quantidade");

                List<Transacao> transacoes = getTransacoes(idCripto);
                List<HistoricoPreco> historicoPrecos = getHistoricoPrecos(idCripto);
                List<Alerta> alertas = getAlertas(idCripto);
                List<Educacao> educacao = getEducacao(idCripto);

                criptoAtivo = new CryptoAtivo(
                        idCripto, nome, valorAtual, quantidade, transacoes, historicoPrecos, alertas, educacao
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return criptoAtivo;
    }
}
