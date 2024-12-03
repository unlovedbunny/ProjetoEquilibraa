package banco.jdbc.tabelas;

import banco.jdbc.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NovoCliente {
    
    public NovoCliente() {
    }

    public static void main(String[] var0) throws SQLException {
        // Estabelecendo conexão com o banco de dados
        Connection conexao = Conexao.getConexao();
        Scanner entrada = new Scanner(System.in);
        
        // Obtendo o idUsuario do último usuário cadastrado
        int idUsuario = obterIdUsuario(conexao); // Atribuindo o retorno para a variável idUsuario

        // Solicita informações do cliente
        System.out.println("Informe a data de nascimento do cliente (formato YYYYMMDD):");
        int dataNascimento = entrada.nextInt();
        
        System.out.println("Informe o peso do cliente:");
        float peso = entrada.nextFloat();
        
        System.out.println("Informe a altura do cliente:");
        float altura = entrada.nextFloat();
    
        System.out.println("Informe o tipo de assinatura (Gratuita - 1 ou Paga - 2):");
        String tipoAssinatura = null;
        while (tipoAssinatura == null || (!tipoAssinatura.equals("1") && !tipoAssinatura.equals("2"))) {
            tipoAssinatura = entrada.nextLine().trim();
            
            if (!tipoAssinatura.equals("1") && !tipoAssinatura.equals("2")) {
                System.out.println("Opção inválida! Informe novamente (1 para Gratuita ou 2 para Paga): ");
            }
        }
        
        System.out.println("Informe seu CPF (formato XXX.XXX.XXX-XX):");
        String cpf = entrada.nextLine().trim();

        // SQL para inserir os dados na tabela cliente
        String sql = "INSERT INTO cliente (idUsuario, dataNascimento, peso, altura, tipoAssinatura, cpf) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, idUsuario); // ID do usuário q foi obtido automaticamente
        stmt.setInt(2, dataNascimento);
        stmt.setFloat(3, peso);
        stmt.setFloat(4, altura);
        stmt.setString(5, tipoAssinatura);
        stmt.setString(6, cpf);

        try {
            stmt.execute();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        } 
    }

    // Método para obter o id do usuário mais recente inserido
    private static int obterIdUsuario(Connection conexao) throws SQLException {
        // Consulta para obter o último idUsuario inserido
        String sql = "SELECT MAX(idUsuario) AS id FROM usuario";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return rs.getInt("id") + 1; // Incrementa o ID para o próximo usuário
        } else {
            return 1; // Se não houver nenhum usuário, inicia com o id 1
        }
    }
}
