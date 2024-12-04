
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Cliente cliente;
        Scanner teclado = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Listar Crescente");
            System.out.println("3 - Listar Descrescente");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção (1-4): ");
            while (true) {
                try {
                    opcao = teclado.nextInt();
                    if (opcao >= 1 && opcao <= 4) {
                        break;
                    }
                    System.err.print("Escolha uma opção válida (1-4): ");
                } catch (InputMismatchException ex) {
                    System.err.print("Somente inteiros de 1-4 são permitidos.");
                    teclado.next();
                }
            }

            switch (opcao) {
                case 1:
                    cliente = capturaCliente(teclado);
                    try {
                        lista.add(cliente);
                        System.out.println("\n\n\n\n");
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 2:
                    if (lista.tamanho == 0) {
                        System.out.println("\n\n\n\n");
                        System.err.println("Lista Vazia");
                    } else {
                        System.out.println("\n\n\n\n");
                        lista.printCresc();
                    }
                    break;
                case 3:
                    if (lista.tamanho == 0) {
                        System.out.println("\n\n\n\n");
                        System.err.println("Lista Vazia");
                    } else {
                        System.out.println("\n\n\n\n");
                        lista.printDecresc();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (opcao != 4);
        teclado.close();
    }

    public static Cliente capturaCliente(Scanner scanner) {
        System.out.println("Digite o código do cliente:");
        int codigo = digitaInteiro(scanner);
        System.out.println("Digite o nome do cliente:");
        String nome = digitaString(scanner);
        System.out.println("Digite o telefone do cliente:");
        int telefone = digitaInteiro(scanner);

        return new Cliente(codigo, nome, telefone);
    }

    public static int digitaInteiro(Scanner teclado) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero > 0) {
                    break;
                }
                System.err.print("O valor deve ser maior que 0. Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente inteiros são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return numero;
    }

    public static String digitaString(Scanner teclado) {
        String texto;
        while (true) {
            try {
                texto = teclado.next();
                if (texto.matches("[\\p{L} ]+")) {
                    break;
                }
                System.err.print("Texto Inválido");
            } catch (InputMismatchException ex) {
                System.err.print("Somente textos são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return texto;
    }
}
