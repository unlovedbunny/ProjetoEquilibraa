package banco.jdbc.tabelas;

import banco.jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NovoUsuario {

    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();
        Scanner entrada = new Scanner(System.in);

        try {
            String nome = obterNome(entrada);
            String telefone = obterTelefone(entrada);
            String endereco = obterEndereco(entrada);
            String numero = obterNumero(entrada);
            String cidade = obterCidade(entrada);
            String estado = obterEstado(entrada);
            String genero = obterGenero(entrada);

            inserirUsuario(conexao, nome, telefone, endereco, numero, cidade, estado, genero);


        } finally {
            entrada.close();
            conexao.close();
        }
    }

    private static String obterNome(Scanner entrada) {
        System.out.print("Usuario: ");
        String nome = entrada.nextLine().trim();
        while (nome.isEmpty() || nome.length() > 80) {
            System.out.println("Nome inválido! Informe novamente (não pode ser vazio e no máximo 80 caracteres): ");
            nome = entrada.nextLine().trim();
        }
        return nome;
    }

    private static String obterTelefone(Scanner entrada) {
        System.out.println("Informe telefone do usuario (ex.: (21) 98765-4321): ");
        String telefone = entrada.nextLine().trim();
        while (telefone.length() < 10) {
            System.out.println("Telefone inválido! Informe no formato correto (ex.: (21) 98765-4321): ");
            telefone = entrada.nextLine().trim();
        }
        return telefone;
    }

    private static String obterEndereco(Scanner entrada) {
        System.out.println("Informe o endereço: ");
        return entrada.nextLine().trim();
    }
    
    private static String obterNumero(Scanner entrada) {
        System.out.println("Número (Se não houver número, digite S/N): ");
        String numero = entrada.nextLine().trim();
        if (numero.isEmpty()) {
            return "S/N";
        }
        while (!numero.matches("\\d{1,10}") && !numero.equalsIgnoreCase("S/N")) {
            System.out.println("Número inválido! Informe um número com até 10 dígitos ou 'S/N': ");
            numero = entrada.nextLine().trim();
        }
        return numero;
    }

    private static String obterCidade(Scanner entrada) {
        System.out.println("Cidade: ");
        String cidade = entrada.nextLine().trim();
        while (cidade.length() > 20) {
            System.out.println("Cidade inválida! Informe um nome de cidade com no mínimo 3 caracteres: ");
            cidade = entrada.nextLine().trim();
        }
        return cidade;
    }

    private static String obterEstado(Scanner entrada) {
        System.out.println("Estado (sigla ou nome completo): ");
        String estado = entrada.nextLine().toUpperCase();
        List<String> estadosValidos = Arrays.asList(
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
                "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        );
        List<String> nomesEstadosValidos = Arrays.asList(
                "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
                "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul",
                "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí",
                "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia",
                "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
        );
        while (!estadosValidos.contains(estado) && !nomesEstadosValidos.contains(estado)) {
            System.out.println("Estado inválido! Informe novamente (sigla ou nome completo válido): ");
            estado = entrada.nextLine().toUpperCase();
        }
        return estado;
    }

    private static String obterGenero(Scanner entrada) {
        System.out.println("Gênero (Masculino/Feminino/Outro): ");
        String genero = entrada.nextLine().trim();
        while (!genero.equalsIgnoreCase("Masculino") &&
                !genero.equalsIgnoreCase("Feminino") &&
                !genero.equalsIgnoreCase("Outro") || genero.length() > 15) {
            System.out.println("Gênero inválido! Informe novamente (Masculino, Feminino ou Outro): ");
            genero = entrada.nextLine().trim();
        }
        return genero;
    }

    private static void inserirUsuario(Connection conexao, String nome, String telefone, String endereco, String numero, String cidade, String estado, String genero) throws SQLException {
        String sql = "INSERT INTO usuario (nome, telefone, endereco, numero, cidade, estado, genero) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, telefone);
        stmt.setString(3, endereco);
        stmt.setString(4, numero);
        stmt.setString(5, cidade);
        stmt.setString(6, estado);
        stmt.setString(7, genero);

        try {
            stmt.execute();
            System.out.println("Usuário incluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao incluir usuário: " + e.getMessage());
        }


    }
}
