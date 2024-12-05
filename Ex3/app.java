
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Cidade cidade;
        Scanner teclado = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Adicionar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Listar");
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
                    System.err.print("Somente inteiros de 1-4 são permitidos:");
                    teclado.next();
                }
            }
            switch (opcao) {
                case 1:
                    cidade = capturaCidade(teclado);
                    try {
                        lista.add(cidade);
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
                        teclado.nextLine();
                        System.out.print("Digite o nome da cidade:");
                        String nome = digitaString(teclado);
                        System.out.print("Digite o nome da país:");
                        String pais = digitaString(teclado);
                        try {
                            lista.del(nome, pais);
                            System.out.println("\n\n\n\n");
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                        break;
                    }
                case 3:
                    if (lista.tamanho == 0) {
                        System.out.println("\n\n\n\n");
                        System.err.println("Lista Vazia");
                    } else {
                        int posicao = 1;
                        int op;
                        do {
                            Cidade c = lista.print(posicao);
                            System.out.println(" - " + c.getNome() + ": Possui " + c.getPrincipaisAtrativos() + ". Nota: " + c.getNota());
                            if (lista.tamanho == 1) {
                                System.out.println("Apenas um registro disponível. Digite 0 para sair.");
                                op = digitaBooleano(teclado);
                            } else if (posicao == 1) {
                                System.out.println("Digite 2 para ir para o próximo ou 0 para sair");
                                op = digitaBooleano(teclado);
                                if (op == 2) {
                                    posicao++;
                                } else if (op == 1) {
                                    System.out.println("\nNão é possível voltar. Este é o primeiro registro.");
                                }
                            } else if (posicao == lista.tamanho) {
                                System.out.println("Digite 1 para voltar ou 0 para sair");
                                op = digitaBooleano(teclado);
                                if (op == 1) {
                                    posicao--;
                                } else if (op == 2) {
                                    System.out.println("\nNão é possível avançar. Este é o último registro.");
                                }
                            } else {
                                System.out.println("Digite 1 para voltar, 2 para ir para o próximo, ou 0 para sair");
                                op = digitaBooleano(teclado);
                                if (op == 1) {
                                    posicao--;
                                } else if (op == 2) {
                                    posicao++;
                                }
                            }
                        } while (op != 0);
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (opcao != 4);
        teclado.close();
    }

    public static Cidade capturaCidade(Scanner teclado) {
        teclado.nextLine();
        System.out.print("Digite o nome da cidade: ");
        String nome = digitaString(teclado);
        System.out.print("Digite o nome do país: ");
        String pais = digitaString(teclado);
        System.out.print("Digite os principais atrativos da cidade: ");
        String atrativos = digitaString(teclado);
        System.out.print("Digite a nota da cidade: ");
        int nota = digitaInteiro(teclado);
    
        return new Cidade(nome, pais, atrativos, nota);
    }

    public static int digitaInteiro(Scanner teclado) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero > 0 && numero <= 10) {
                    teclado.nextLine();
                    break;
                }
                System.err.print("O valor deve ser entre 0 e 10. Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente inteiros são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return numero;
    }

    public static int digitaBooleano(Scanner teclado) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero >= 0 && numero <= 2) {
                    break;
                }
                System.err.print("O valor deve ser 0 ou 1. Tente novamente: ");
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
                texto = teclado.nextLine();
                if (texto.matches("[\\p{L}\\s\\-]+")) {
                    break;
                }
                System.err.print("Texto Inválido. Tente novamente: ");
            } catch (Exception ex) {
                System.err.print("Erro na leitura. Tente novamente: ");
            }
        }
        return texto;
    }
}
