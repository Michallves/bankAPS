import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int escolha = lerInteiro(scanner);

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.next();
                    System.out.println("Digite o CPF do cliente (apenas números):");
                    String cpfCliente = lerCPF(scanner);
                    if (cpfCliente != null) {
                        banco.criarCliente(nomeCliente, cpfCliente);
                    } else {
                        System.out.println("CPF inválido. Tente novamente.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do cliente:");
                    int idCliente = lerInteiro(scanner);
                    if (idCliente > 0) {
                        System.out.println("Digite o saldo inicial:");
                        double saldoInicial = lerDouble(scanner);
                        System.out.println("Digite o número da conta:");
                        String numeroConta = scanner.next();
                        System.out.println("Digite o número da agência:");
                        String agencia = scanner.next();
                        banco.criarConta(idCliente, saldoInicial, numeroConta, agencia);
                    } else {
                        System.out.println("ID de cliente inválido. Tente novamente.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID da conta:");
                    int idContaDeposito = lerInteiro(scanner);
                    if (idContaDeposito > 0) {
                        System.out.println("Digite o valor a ser depositado:");
                        double valorDeposito = lerDouble(scanner);
                        if (valorDeposito >= 0) {
                            banco.depositar(idContaDeposito, valorDeposito);
                        } else {
                            System.out.println("Valor de depósito inválido. Tente novamente.");
                        }
                    } else {
                        System.out.println("ID de conta inválido. Tente novamente.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o ID da conta:");
                    int idContaSaque = lerInteiro(scanner);
                    if (idContaSaque > 0) {
                        System.out.println("Digite o valor a ser sacado:");
                        double valorSaque = lerDouble(scanner);
                        if (valorSaque >= 0) {
                            banco.sacar(idContaSaque, valorSaque);
                        } else {
                            System.out.println("Valor de saque inválido. Tente novamente.");
                        }
                    } else {
                        System.out.println("ID de conta inválido. Tente novamente.");
                    }
                    break;
                case 5:
                    System.out.println("Digite o ID da conta de origem:");
                    int idContaOrigem = lerInteiro(scanner);
                    System.out.println("Digite o ID da conta de destino:");
                    int idContaDestino = lerInteiro(scanner);
                    if (idContaOrigem > 0 && idContaDestino > 0) {
                        System.out.println("Digite o valor a ser transferido:");
                        double valorTransferencia = lerDouble(scanner);
                        if (valorTransferencia >= 0) {
                            banco.transferir(idContaOrigem, idContaDestino, valorTransferencia);
                        } else {
                            System.out.println("Valor de transferência inválido. Tente novamente.");
                        }
                    } else {
                        System.out.println("IDs de conta inválidos. Tente novamente.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o ID da conta:");
                    int idContaSaldo = lerInteiro(scanner);
                    if (idContaSaldo > 0) {
                        banco.mostrarSaldo(idContaSaldo);
                    } else {
                        System.out.println("ID de conta inválido. Tente novamente.");
                    }
                    break;
                case 7:
                    scanner.close();
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Criar Cliente");
        System.out.println("2. Criar Conta");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Transferir");
        System.out.println("6. Mostrar Saldo");
        System.out.println("7. Sair");
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Entrada inválida. Digite um número inteiro:");
        }
        return scanner.nextInt();
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Entrada inválida. Digite um número válido:");
        }
        return scanner.nextDouble();
    }

    private static String lerCPF(Scanner scanner) {
        String cpf = scanner.next().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        if (cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return null; // CPF inválido
        }
        // Formata o CPF (###.###.###-##)
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
    }
}
