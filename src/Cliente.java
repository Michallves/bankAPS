
class Cliente {
    private int id;
    private String nome;
    private String cpf;

    public Cliente(int contadorId, String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente [ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + "]";
    }

    public int getIdCliente() {
        return 0;
    }
}