public class PessoaFisica extends Titular {
    private String cpf;
    public PessoaFisica(int id, String nome, String cpf) {
        super(id, nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}
