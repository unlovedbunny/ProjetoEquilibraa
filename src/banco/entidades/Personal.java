package banco.entidades;

public class Personal extends Usuario {
    private String cnpj;
    private String especialidade;
    private String CREF;
    
    public Personal(String idUsuario, String nome, String telefone, String endereco, String numero, String cidade, String estado, String genero, String cnpj, String especialidade, String CREF) {
        super(idUsuario, nome, telefone, endereco, numero, cidade, estado, genero);
        this.cnpj = cnpj;
        this.especialidade = especialidade;
        this.CREF = CREF;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getCREF() {
        return CREF;
    }
    public void setCREF(String cREF) {
        CREF = cREF;
    }

}
