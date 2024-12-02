package banco.jdbc.tabelas;

import banco.jdbc.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaCliente {
    public static void main(String[] args) throws SQLException {

        // Estabelecendo conexão com o banco de dados
        Connection conexao = Conexao.getConexao();

        // Definindo o comando SQL para criar a tabela cliente
        String sql = "CREATE TABLE IF NOT EXISTS cliente (" +
                "idCliente INT AUTO_INCREMENT PRIMARY KEY, " +
                "idUsuario INT NOT NULL, " +
                "dataNascimento INT NOT NULL, " +
                "peso FLOAT NOT NULL, " +
                "altura FLOAT NOT NULL, " +
                "tipoAssinatura VARCHAR(50) NOT NULL, " +
                "cpf VARCHAR(14) NOT NULL UNIQUE, " +
                "FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE" /* se um usuário for excluído, os registros associados na tabela cliente também serão excluídos */ +
                ")";

    
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela cliente criada com sucesso");

       
        conexao.close();
    }
}
