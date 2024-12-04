import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Veiculo veiculo;
        Scanner teclado = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir (por placa)");
            System.out.println("3 - Listar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção (1-4): ");
            while (true) {
                try {
                    opcao = teclado.nextInt();
                    if (opcao >= 1 && opcao <= 4)
                        break;
                    System.err.print("Escolha uma opção válida (1-4): ");
                } catch (InputMismatchException ex) {
                    System.err.println("Somente inteiros de 1-4 são permitidos.");
                    teclado.next();
                }
            }

            switch (opcao) {
                case 1:
                    veiculo = capturarVeiculo(teclado);
                    lista.add(veiculo);
                    System.out.println("\n\n\n\n");
                    break;
                case 2:
                    if((lista.tamanho == 0)) {
                        System.out.println("\n\n\n\n");
                        System.out.println("Lista Vazia");
                    }else {
                        System.out.println("Digite a placa do veículo:");
                        String placa = teclado.next();
                        if(lista.del(placa)) {
                            System.out.println("\n\n\n\n");
                            System.out.println("Apagado com Sucesso!");
                        }
                        else {
                            System.out.println("\n\n\n\n");
                            System.out.println("Não encontrado!");
                        }
                        break;
                    }
                case 3:
                    if((lista.tamanho == 0)) {
                        System.out.println("\n\n\n\n");
                        System.out.println("Lista Vazia");
                    }else{
                        System.out.println("\n\n\n\n");
                        lista.printLista();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (opcao != 4);
        teclado.close();
    }

    public static Veiculo capturarVeiculo(Scanner scanner) {
        System.out.println("Digite a placa do veículo:");
        String placa = scanner.next();

        System.out.println("Digite a marca do veículo:");
        String marca = scanner.next();

        System.out.println("Digite o modelo do veículo:");
        String modelo = scanner.next();

        System.out.println("Digite o preço do veículo:");
        double preco = digitaDouble(scanner);

        return new Veiculo(placa, marca, modelo, preco);
    }

    public static double digitaDouble(Scanner teclado) {
        double numero;
        while (true) {
            try {
                numero = teclado.nextDouble();
                if (numero > 0)
                    break;
                System.err.print("O valor deve ser maior que 0. Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente double são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return numero;
    }

}
