package banco.jdbc.tabelas;

import banco.jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovoNutricionista {

    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Scanner entrada = new Scanner(System.in);

        // Coletando dados do usuário
        System.out.println("Informe o ID do usuário:");
        int idUsuario = entrada.nextInt();
        entrada.nextLine(); // Limpar a linha

        System.out.println("CNPJ do nutricionista:");
        String cnpj = entrada.nextLine().trim();

        System.out.println("CRN do nutricionista:");
        String CRN = entrada.nextLine().trim();

        // Inserindo dados do nutricionista na tabela
        String sql = "INSERT INTO nutricionista (idUsuario, cnpj, CRN) VALUES (?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setString(2, cnpj);
        stmt.setString(3, CRN);

        try {
            stmt.execute();
            System.out.println("Nutricionista cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar nutricionista: " + e.getMessage());
        } finally {
            entrada.close();
            conexao.close();
        }
    }
}
