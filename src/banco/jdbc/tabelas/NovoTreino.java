package banco.jdbc.tabelas;

import banco.jdbc.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;

public class NovoTreino {

    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Scanner entrada = new Scanner(System.in);

        // Solicita o ID do personal
        System.out.println("Informe o ID do personal responsável:");
        int idPersonal = entrada.nextInt();
        entrada.nextLine(); // Limpar o buffer

        // Solicita a descrição do treino
        System.out.println("Informe a descrição do treino:");
        String descricao = entrada.nextLine().trim();

        // Data de criação (automática)
        LocalDate dataCriacao = LocalDate.now();

        // Solicita a duração do treino
        System.out.println("Informe a duração do treino (em minutos):");
        int duracao = entrada.nextInt();

        // Solicita a intensidade do treino
        System.out.println("Informe a intensidade do treino (1- Baixa, 2- Moderada, 3- Alta):");
        int intensidade = 0;
        while (intensidade < 1 || intensidade > 3) {
            intensidade = entrada.nextInt();
            if (intensidade < 1 || intensidade > 3) {
                System.out.println("Opção inválida! Informe novamente (1 para Baixa, 2 para Moderada, 3 para Alta):");
            }
        }

        entrada.nextLine(); // Limpar o buffer

        // Solicita os equipamentos necessários
        System.out.println("Informe os equipamentos necessários para o treino (separados por vírgula):");
        String equipamentos = entrada.nextLine().trim();

        // SQL para inserir os dados na tabela treino
        String sql = "INSERT INTO treino (idPersonal, descricao, dataCriacao, duracao, intensidade, equipamentos) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idPersonal);
        stmt.setString(2, descricao);
        stmt.setDate(3, java.sql.Date.valueOf(dataCriacao));
        stmt.setInt(4, duracao);
        stmt.setInt(5, intensidade);
        stmt.setString(6, equipamentos);

        try {
            stmt.execute();
            System.out.println("Treino cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar treino: " + e.getMessage());
        } finally {
            entrada.close();
            conexao.close();
        }
    }
}
