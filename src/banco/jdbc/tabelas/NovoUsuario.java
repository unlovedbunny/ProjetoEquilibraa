package banco.jdbc.tabelas;
import banco.jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovoUsuario {
    public static void main(String[] args) throws SQLException {
        
        Connection conexao = Conexao.getConexao();

        Scanner entrada = new Scanner(System.in);

        System.out.print("Usuario: ");
        String nome = entrada.nextLine();
        System.out.println("Informe telefone do usuario " + nome + ": ");
        String telefone = entrada.nextLine();
        System.out.println("Informe o endereço: ");
        String endereco = entrada.nextLine();
        System.out.println("numero: ");
        String numero = entrada.nextLine();
        System.out.println("Cidade: ");
        String cidade = entrada.nextLine();
        System.out.println("estado: ");
        String estado = entrada.nextLine();
        System.out.println("Gênero: ");
        String genero = entrada.nextLine();

        String sql = "INSERT INTO usuario (nome, telefone, endereco, numero, cidade, estado, genero) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, telefone);
        stmt.setString(3, endereco);
        stmt.setString(4, numero);
        stmt.setString(5, cidade);
        stmt.setString(6, estado);
        stmt.setString(7, genero);
       
        stmt.execute();

        System.out.println(sql);
        System.out.println("Usuario incluido com sucesso!");
        entrada.close();
    }
    
}
