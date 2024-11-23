package banco.entidades;

public class Nutri extends Usuario{
    private String cnpj;
    private String CRN;
    
    public Nutri(String idUsuario,String nome, String telefone, String endereco, String numero, String cidade, String estado, String genero, String cnpj, String CRN) {
        super(idUsuario, nome, telefone, endereco, numero, cidade, estado, genero);
        this.cnpj = cnpj;
        this.CRN = CRN;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getCRN() {
        return CRN;
    }
    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

}