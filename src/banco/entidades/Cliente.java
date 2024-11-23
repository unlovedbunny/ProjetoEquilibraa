package banco.entidades;

public class Cliente extends Usuario{
    private int dataNascimento;
    private float peso;
    private float altura;
    private String tipoAssinatura;
    private String cpf; 

    public Cliente(String idUsuario,String nome, String telefone, String endereco, String numero, String cidade, String estado, String genero, int dataNascimento, float peso, float altura, String tipoAssinatura, String cpf) {

        super(idUsuario, nome, telefone, endereco, numero, cidade, estado, genero);
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
        this.tipoAssinatura = tipoAssinatura;
        this.cpf = cpf;
    }
    
    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(String tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

 
}
