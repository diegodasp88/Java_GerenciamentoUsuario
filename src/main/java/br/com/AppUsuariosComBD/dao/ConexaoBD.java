package br.com.AppUsuariosComBD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/estudos_java";
    private static final String USER = "diego";
    private static final String PASSWORD = "kanary";

    public static Connection conectarBD() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
