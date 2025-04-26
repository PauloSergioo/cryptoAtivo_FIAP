package com.criptoAtivos.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

        private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        private static final String USUARIO = "rm553012";
        private static final String SENHA = "110304";

        public static Connection getConnection() throws SQLException {
                try {
                        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
                        logger.info("Conexão com o banco de dados estabelecida com sucesso!");
                        return conn;
                } catch (SQLException e) {
                        logger.error("Erro ao conectar ao banco de dados: {}", e.getMessage());
                        throw e;
                }
        }
}
