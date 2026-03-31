public class MyArrayList implements MyArrayListTad {

    // VARIÁVEIS DE ESTADO (Encapsuladas com 'private')
    private int[] items;    // O array real na memória que vai guardar os números.
    private int capacity;   // O tamanho MÁXIMO do array (quantas "cadeiras" existem).
    private int count;      // Quantos elementos REALMENTE estão lá (quantas "cadeiras" estão ocupadas).

    // CONSTRUTOR: Chamado quando fazemos "new MyArrayList(tamanho)"
    public MyArrayList(int size) {
        this.capacity = size;             // Define a capacidade máxima
        this.items = new int[capacity];   // Cria o array físico na memória com esse tamanho
        this.count = 0;                   // Começa com 0 itens inseridos
    }

    // --- MÉTODOS DE CONTROLE ---

    @Override
    public boolean isEmpty() {
        return count == 0; // Se count for 0, retorna true (está vazia)
    }

    @Override
    public boolean isFull() {
        return count == capacity; // Se a quantidade de itens for igual ao limite, está cheia.
    }

    @Override
    public int count() {
        return count;
    }

    // --- MÉTODOS DE INSERÇÃO ---

    @Override
    public void addFirst(int newItem) {
        if (isFull()) { // Sempre verificar se há espaço antes de inserir
            System.out.println("Erro\nArray esta completa.");
            return;
        }
        // DESLOCAMENTO PARA A DIREITA (Shifting)
        // Para colocar alguém na posição 0, precisamos "empurrar" todo mundo uma casa para a direita.
        // O loop começa do final (count) e vem copiando o item da esquerda (i-1) para a direita (i).
        for (int i = count; i > 0; i--) {
            items[i] = items[i - 1];
        }
        items[0] = newItem; // Agora que a posição 0 está livre, colocamos o novo item nela.
        count++;            // Aumentamos a quantidade de itens na lista.
    }

    @Override
    public void addLast(int newItem) {
        if (isFull()) {
            System.out.println("Erro\nArray esta completa");
            return;
        }
        // Muito mais rápido (O(1)). Basta colocar o item na posição vazia logo após o último.
        // 'count++' usa o valor atual de count como índice e depois adiciona 1 à variável.
        items[count++] = newItem;
    }

    public void addSorted(int newItem) {
        if (isFull()) {
            System.out.println("Erro!\nArray esta completa");
            return;
        }
        int index = -1;

        // 1. Descobrir onde o item deve entrar para manter a ordem crescente
        for (int i = 0; i < count; i++) {
            if (newItem < items[i]) { // Encontramos o primeiro número maior que o novo
                index = i;            // Achamos a posição exata de inserção!
                break;
            }
        }

        // 2. Abrir espaço "empurrando" os elementos para a direita a partir desse índice
        for (int i = count; i > index; i--) {
            items[i] = items[i - 1];
        }

        // 3. Inserir e atualizar contador
        items[index] = newItem;
        count++;
    }

    @Override
    public void insertAt(int index, int newItem) {
        // Verifica se está cheia ou se o usuário passou um índice absurdo (negativo ou além dos itens)
        if (isFull() || index < 0 || index > count) {
            System.out.println("Erro\nIndice não existe ou array completa");
            return;
        }
        count++; // Aumenta o contador primeiro (abre o novo espaço lógico no final)

        // Desloca para a direita apenas os itens que estão do índice desejado para frente
        for (int i = count - 1; i > index; i--) {

            // Ajuste fino sugerido: usar count - 1 aqui para evitar IndexOutOfBounds
            items[i] = items[i - 1];
        }
        items[index] = newItem; // Insere no "buraco" que foi aberto
    }

    // --- MÉTODOS DE REMOÇÃO ---


    @Override
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Erro\nArray vazia");
            return;
        }
        // DESLOCAMENTO PARA A ESQUERDA (Shifting)
        // Para remover o primeiro (índice 0), copiamos quem está na frente (i+1) para trás (i).
        // Isso "esmaga" (sobrescreve) o elemento que estava na posição 0.
        for (int i = 0; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--; // O último elemento agora está duplicado, mas não tem problema, pois count-- esconde ele.
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Erro\nArray vazia");
            return;
        }
        // O(1) - Rapidíssimo! Não apagamos da memória fisicamente, só diminuímos o "count".
        // O elemento fica lá "morto", o array não o considera mais. Se um novo item for inserido, o sobrescreve.
        count--;
    }

    @Override
    public void removeAt(int index) {
        if (isEmpty() || index < 0 || index >= count) {
            // Correção: index deve ser < count (não pode remover onde não tem)
            System.out.println("Erro\nIndice não existe ou array vazia");
            return;
        }
        // Deslocamento para a esquerda a partir do índice que queremos remover
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    @Override
    public void remove(int item) {
        if (isEmpty()) {
            System.out.println("Erro\nArray vazia");
            return;
        }
        int index = -1;
        // 1. Busca linearmente onde está o item
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                index = i;
                break;
            }
        }
        // Se não achou, encerra
        if (index == -1) {
            System.out.println("Item não encontrado");
            return;
        }
        // 2. Deslocamento para a esquerda a partir do índice encontrado
        for (int j = index; j < count - 1; j++) {
            items[j] = items[j + 1];
        }
        count--;
    }

    // --- MÉTODOS DE BUSCA E ATUALIZAÇÃO ---

    @Override
    public int find(int item) {
        // Percorre a lista toda (O(n)) até achar. Retorna o índice ou -1 se não achar.
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        // Acesso direto em memória: O(1). É a grande vantagem do Array!
        if (isEmpty() || index < 0 || index >= count) {
            if (isEmpty()) System.out.println("Array vazia");
            throw new IndexOutOfBoundsException("Erro: Índice " + index + " fora dos limites.");
        }
        return items[index];
    }

    @Override
    public void set(int index, int item) {
        // Atualiza um valor diretamente na posição especificada
        if (isEmpty() || index < 0 || index >= count) {
            System.out.println("Erro! \nIndice invalido ou array vazia");
            return;
        }
        items[index] = item;
    }

    // --- EXIBIÇÃO ---

    @Override
    public void display() {
        System.out.print("[ ");
        // Só exibe até o "count", ignorando o lixo de memória que possa existir do "count" até a "capacity"
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}