package banco;
import java.sql.Connection; //preciso conectar no BD
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL{
    private static final String url = "jdbc:mysql://localhost:3306/equilibrabd"; //lembrar de inserir o endereço do bd
    private static final String username = "root";

    private static final String password = "010422";

    private static Connection conexao;

    public ConexaoMySQL(){

    }

    public static Connection getConexao(){
        String driverName = "com.mysql.jdbc.Driver";
        try{
            Class.forName(driverName);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            if(conexao == null){
                System.out.println("Status da Conexão: Conectado com sucesso :) ");
                conexao = DriverManager.getConnection(url, username, password);
                return conexao;
            }else{
                return conexao;
            }
        } 
        
        catch(SQLException e){
            System.out.println("Não foi possível conectar ao Banco de dados");
            e.printStackTrace();
            return null;
        }

        


    }

}

/* public class ConexaoMySQL {
    public static String status = "Não conectou :( ";

    public ConexaoMySQL(){
        //construtor 
    }

    public static java.sql.Connection getConexaoMySQL(){
        Connection connection = null;

    try{
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);

        String serverName = "localhost";

        String mydatabase = "equilibra";

        String url = "jdbc:mysql://localhost:3306/equilibrabd"; //lembrar de inserir o endereço do bd

        String username = "root";

        String password = "010422";

        connection = DriverManager.getConnection(url, username, password);

        //testar conexão

        if(connection != null){
            status = ("Status da Conexão: Conectado com sucesso :) ");
        } else{
            status = ("Status da Conexão: Não foi possível estabelecer uma conexão :( ");
        }
        return connection;
    } 
    catch(ClassNotFoundException e){
        System.out.println("O driver especificado não pôde ser encontrado.");
        return null;
    } catch(SQLException e){
        System.out.println("Não foi possível conectar ao BAnco de dados");
        return null;
    }
    }

    public static String statusConexao(){
        return status;
    } public static boolean FecharConexao(){
        try{
            ConexaoMySQL.getConexaoMySQL().close();
            return true;
        } catch(SQLException e){
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao(){
        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();
    }
}
*/