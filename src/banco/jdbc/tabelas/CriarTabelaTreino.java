
package banco.jdbc.tabelas;

import banco.jdbc.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaTreino {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String sql = "CREATE TABLE IF NOT EXISTS treino (" +
                     "idTreino INT AUTO_INCREMENT PRIMARY KEY, " +
                     "idPersonal INT NOT NULL, " +
                     "descricao TEXT NOT NULL, " +
                     "dataCriacao DATE NOT NULL, " +
                     "duracao INT NOT NULL, " +
                     "intensidade TINYINT NOT NULL, " +
                     "equipamentos TEXT, " +
                     "FOREIGN KEY (idPersonal) REFERENCES personal(idPersonal) ON DELETE CASCADE" +
                     ")";

        Statement stmt = conexao.createStatement();
        try {
            stmt.execute(sql);
            System.out.println("Tabela 'treino' criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'treino': " + e.getMessage());
        } finally {
            if (conexao != null) conexao.close();
        }
    }
}
