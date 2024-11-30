package banco.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaUsuario {
    public static void main(String[] args) throws SQLException{
        
        Connection conexao = Conexao.getConexao();

            String sql = "CREATE TABLE usuario ("
            + "idUsuario INT AUTO_INCREMENT PRIMARY KEY,"
            + "nome VARCHAR(80) NOT NULL," 
            + ")";

            Statement stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela criada com sucesso");
            conexao.close();
        }
    }

