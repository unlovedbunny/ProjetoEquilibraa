package banco.jdbc.tabelas;

import banco.jdbc.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroOpcao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Connection conexao = null;

        try {
            // Estabelece a conexão com o banco de dados
            conexao = Conexao.getConexao();

            // Cria o usuário
            NovoUsuario.main(args);
            entrada.nextLine(); // Limpar o buffer residual após NovoUsuario.main()

            // Menu de opções
            boolean continuarCadastro = true;
            while (continuarCadastro) {
                // Exibe o menu
                System.out.println("\nEscolha uma opção de cadastro:");
                System.out.println("1 - Cadastrar como Cliente");
                System.out.println("2 - Cadastrar como Profissional");
                System.out.println("3 - Sair");

                try {
                    int opcao = entrada.nextInt();
                    entrada.nextLine(); // Limpar o buffer residual após nextInt()

                    switch (opcao) {
                        case 1 -> {
                            int idUsuario = obterIdUsuario(conexao);
                            NovoCliente.main(new String[]{String.valueOf(idUsuario)});
                        }
                        case 2 -> cadastrarComoProfissional(conexao, entrada);
                        case 3 -> {
                            continuarCadastro = false; // Encerra o loop
                            System.out.println("Saindo do cadastro.");
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número correspondente à opção.");
                    entrada.nextLine(); // Limpar o buffer em caso de entrada inválida
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) entrada.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar os recursos: " + e.getMessage());
            }
        }
    }

    private static int obterIdUsuario(Connection conexao) throws SQLException {
        // Consulta para obter o último idUsuario inserido
        String sql = "SELECT idUsuario FROM usuario ORDER BY idUsuario DESC LIMIT 1";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("idUsuario"); // Retorna o último ID inserido
        } else {
            throw new SQLException("Nenhum usuário encontrado. Verifique se o usuário foi criado corretamente.");
        }
    }

    private static void cadastrarComoProfissional(Connection conexao, Scanner entrada) throws SQLException {
        System.out.println("Cadastro de Profissional:");
        System.out.println("Escolha o tipo de profissional:");
        System.out.println("1 - Personal");
        System.out.println("2 - Nutricionista");

        try {
            int escolha = entrada.nextInt();
            entrada.nextLine(); // Limpar o buffer residual após nextInt()

            switch (escolha) {
                case 1 -> NovoPersonal.main(new String[0]); // Cadastro de Personal
                case 2 -> NovoNutricionista.main(new String[0]); // Cadastro de Nutricionista
                default -> System.out.println("Opção inválida. Cadastro de Profissional não realizado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número correspondente à opção.");
            entrada.nextLine(); // Limpar o buffer em caso de entrada inválida
        }
    }
}
