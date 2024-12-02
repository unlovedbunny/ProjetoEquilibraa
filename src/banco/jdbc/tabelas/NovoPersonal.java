package banco.jdbc.tabelas;

import banco.jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovoPersonal {

    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Scanner entrada = new Scanner(System.in);

        // Coletando dados do usuário
        System.out.println("Informe o ID do usuário:");
        int idUsuario = entrada.nextInt();
        entrada.nextLine(); // Limpar a linha

        System.out.println("CNPJ do personal:");
        String cnpj = entrada.nextLine().trim();

        System.out.println("Especialidade do personal:");
        String especialidade = entrada.nextLine().trim();

        System.out.println("CREF do personal:");
        String CREF = entrada.nextLine().trim();

        // Inserindo dados do personal na tabela
        String sql = "INSERT INTO personal (idUsuario, cnpj, especialidade, CREF) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setString(2, cnpj);
        stmt.setString(3, especialidade);
        stmt.setString(4, CREF);

        try {
            stmt.execute();
            System.out.println("Personal cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar personal: " + e.getMessage());
        } finally {
            entrada.close();
            conexao.close();
        }
    }
}
