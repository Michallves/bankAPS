import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco() {
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public void criarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente criado: " + cliente);
    }

    public void criarConta(Cliente cliente, double saldo, String numeroConta, String agencia) {
        Conta conta = new Conta(cliente, saldo, numeroConta, agencia);
        contas.add(conta);
        System.out.println("Conta criada: " + conta);
    }

    public void atualizarConta(int id, double novoSaldo, String novoNumeroConta, String novaAgencia) {
        for (Conta conta : contas) {
            if (conta.getId() == id) {
                conta.depositar(novoSaldo);
                conta.setNumeroConta(novoNumeroConta);
                conta.setAgencia(novaAgencia);
                System.out.println("Conta atualizada: " + conta);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void excluirConta(int id) {
        for (Conta conta : contas) {
            if (conta.getId() == id) {
                contas.remove(conta);
                System.out.println("Conta excluída: " + conta);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void listarContas() {
        System.out.println("Lista de Contas:");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
}