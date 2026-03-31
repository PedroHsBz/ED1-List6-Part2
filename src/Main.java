import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Defina a capacidade inicial da lista: ");
        int capacidade = scanner.nextInt();
        MyArrayList lista = new MyArrayList(capacidade);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("--------------------------------------");
            System.out.println("         MENU TAD MYARRAYLIST         ");
            System.out.println("--------------------------------------");
            System.out.println("1. Adicionar no inicio (addFirst)");
            System.out.println("2. Adicionar ao final (addLast)");
            System.out.println("3. Inserir ordenado (addSorted)");
            System.out.println("4. Inserir em posição (insertAt)");
            System.out.println("5. Remover primeiro (removeFirst)");
            System.out.println("6. Remover ultimo (removeLast)");
            System.out.println("7. Remover por valor (remove)");
            System.out.println("8. Remover por índice (removeAt)");
            System.out.println("9. Buscar índice de um valor (find)");
            System.out.println("10. Obter valor por índice (get)");
            System.out.println("11. Alterar valor por índice (set)");
            System.out.println("12. Exibir informações (Size/Full/Empty)");
            System.out.println("13. Exibir lista completa (display)");
            System.out.println("0.  Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Digite o valor: ");
                    lista.addFirst(scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Digite o valor: ");
                    lista.addLast(scanner.nextInt());
                }
                case 3 -> {
                    System.out.print("Digite o valor para inserir ordenado: ");
                    lista.addSorted(scanner.nextInt());
                }
                case 4 -> {
                    System.out.print("Índice: ");
                    int idx = scanner.nextInt();
                    System.out.print("Valor: ");
                    lista.insertAt(idx, scanner.nextInt());
                }
                case 5 -> lista.removeFirst();

                case 6 -> lista.removeLast();

                case 7 -> {
                    System.out.print("Valor para remover: ");
                    lista.remove(scanner.nextInt());
                }
                case 8 -> {
                    System.out.print("Índice para remoção: ");
                    lista.removeAt(scanner.nextInt());
                }
                case 9 -> {
                    System.out.print("Valor para busca: ");
                    int valor = scanner.nextInt();
                    int posicao = lista.find(valor);
                    if(posicao != -1) System.out.println("Valor encontrado no índice: " + posicao);
                    else System.out.println("Valor não encontrado.");
                }
                case 10 -> {
                    try {
                        System.out.print("Índice: ");
                        int index = scanner.nextInt();
                        System.out.println("Valor na posição: " + lista.get(index));
                    } catch (Exception e) { System.out.println("Erro: Índice inválido."); }
                }
                case 11 -> {
                    try {
                        System.out.print("Índice: ");
                        int index = scanner.nextInt();
                        System.out.print("Novo Valor: ");
                        lista.set(index, scanner.nextInt());
                        System.out.println("Valor atualizado!");
                    } catch (Exception e) { System.out.println("Erro: Índice inválido."); }
                }
                case 12 -> {
                    System.out.println("-> Total de elementos: " + lista.count());
                    System.out.println("-> Está vazia? " + lista.isEmpty());
                    System.out.println("-> Está cheia? " + lista.isFull());
                }
                case 13 -> lista.display();

                case 0 -> System.out.println("Encerrando programa...");

                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
