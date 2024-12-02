package banco.jdbc.tabelas;

import banco.jdbc.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPersonal {

    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String sql = "CREATE TABLE IF NOT EXISTS personal ("
                + "idPersonal INT AUTO_INCREMENT PRIMARY KEY, "
                + "idUsuario INT NOT NULL, "
                + "cnpj VARCHAR(18) NOT NULL, "
                + "especialidade VARCHAR(100) NOT NULL, "
                + "CREF VARCHAR(20) NOT NULL, "
                + "FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE"
                + ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela personal criada com sucesso");

        conexao.close();
    }
}
