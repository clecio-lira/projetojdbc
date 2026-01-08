package com.projetojdbc;
import java.sql.*;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cursojdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conectado ao MySQL com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao MySQL");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
