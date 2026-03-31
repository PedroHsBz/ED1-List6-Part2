// O TAD (Tipo Abstrato de Dados) define as operações que nossa lista deve ter.
// Quem implementar esta interface será OBRIGADO a escrever o código de todos estes métodos.
public interface MyArrayListTad {
    void addFirst(int newItem);             // Adiciona no início
    void addLast(int newItem);              // Adiciona no final
    void addSorted(int newItem);            // Adiciona mantendo a ordem crescente
    void insertAt(int indice, int newItem); // Insere em uma posição específica
    void removeFirst();                     // Remove o primeiro item
    void removeLast();                      // Remove o último item
    void removeAt(int indice);              // Remove de uma posição específica
    void remove(int number);                // Busca um número específico e o remove
    int find(int item);                     // Busca um item e retorna o seu índice
    int get(int indice);                    // Retorna o valor que está em um índice
    void set(int indice, int newItem);      // Substitui o valor de um índice
    boolean isEmpty();                      // Verifica se a lista está vazia
    boolean isFull();                       // Verifica se a lista está cheia
    int count();                            // Retorna a quantidade ATUAL de itens
    void display();                         // Imprime a lista na tela
}