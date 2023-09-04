
class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.id = contadorId++;
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
}