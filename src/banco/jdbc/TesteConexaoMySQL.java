package banco.jdbc;
import java.sql.Connection; //preciso conectar no BD
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexaoMySQL {
    public static void main(String[] args) throws SQLException{
        final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        final String usuario = "root";
        final String senha = "010422";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        System.out.println("Conexão efetuada");
        conexao.close();
    }
}
