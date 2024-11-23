import java.sql.PreparedStatement;
import java.sql.SQLException;
import banco.ConexaoMySQL;
import banco.entidades.*;

//ainda trabalhando nisso

public class UsuarioDAO{
    public void cadastrarUsuario(Usuario Usuario){

        
        String sql = "INSERT INTO USUARIO (IDUSUARIO, NOME, TELEFONE, ENDERECO, NUMERO, CIDADE, ESTADO, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        /*idUsuario; 
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.genero = genero; */

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setString( 1, Usuario.getIdUsuario());
            ps.setString(2, Usuario.getNome());
            ps.setString(3, Usuario.getTelefone());
            ps.setString(4, Usuario.getEndereco());
            ps.setString(5, Usuario.getNumero());
            ps.setString(6, Usuario.getCidade());
            ps.setString(7, Usuario.getEstado());
            ps.setString(8, Usuario.getGenero());

            ps.execute();
            ps.close();
            /*ps.setString(parameterIndex: 1, Usuario.getIdUsuario());*/

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //fzd a inserção + conexao dos dados 
            e.printStackTrace();
        }
        
    }
}