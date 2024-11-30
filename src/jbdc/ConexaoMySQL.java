package jbdc;

import java.sql.Connection; //preciso conectar no BD
import java.sql.DriverManager;
import java.sql.SQLException;
//utilizando o JDBC (Java Database Connectivity) mysql connector

public class ConexaoMySQL {
    public static void main(String[] args) {
        //throws SQLException: se acontecer alguma excessão, ele sai do metodo main e a gnt vê o resultado no console

        final String url = "jdbc:mysql://localhost:3306/equilibrabd?verifyServerCertificate=false&false&useSSL=true"; //se utilizar outra conexão com mysql, retirar o trecho ":3306/equilibrabd"
        final String usuario = "root";
        final String senha = "010422";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha); //posso tratar a excessão com try/catch oou posso usar o throws SQLException (pq se acontecer uma excessão, ele simplesmente sai do método main para simplificar)
            System.out.println("Conexão efetuada :)");
            
        } catch(SQLException e){

        }
    }
}   