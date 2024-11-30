package banco.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao() {
        try {
            final String url = "jdbc:mysql://localhost:3306";
            final String usuario = "root";
            final String senha = "010422";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
}
