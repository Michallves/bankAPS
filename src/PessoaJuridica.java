public class PessoaJuridica extends Titular {
    private String cnpj;
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }
}
