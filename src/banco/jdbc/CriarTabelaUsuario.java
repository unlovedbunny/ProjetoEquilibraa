package banco.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarTabelaUsuario {
    public static void main(String[] args) throws SQLException {
        
        Connection conexao = Conexao.getConexao();

            String sql = "CREATE TABLE IF NOT EXISTS usuario ("
            + "idUsuario INT AUTO_INCREMENT PRIMARY KEY, "
            + "nome VARCHAR(80) NOT NULL, "
            + "telefone VARCHAR(20) NOT NULL, "
            + "endereco VARCHAR(80) NOT NULL, "
            + "numero VARCHAR(10) NOT NULL, "
            + "cidade VARCHAR(20) NOT NULL, "
            + "estado VARCHAR(15) NOT NULL, "
            + "genero VARCHAR(15) NOT NULL " 
            + ")";

            Statement stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela criada com sucesso");

            conexao.close();
        }
    }

