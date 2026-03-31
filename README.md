# Estrutura de dados
# ED1-List6-Part2

Este repositório contém a evolução da implementação do TAD Lista Sequencial em Java para números inteiros, atividade integrante da Parte 2 da disciplina de Estrutura de Dados I. O projeto baseia-se na definição da interface (`MyArrayListTad`) e na sua implementação (`MyArrayList`) utilizando arrays de tamanho fixo. 
Nesta segunda parte, o foco se expande para a inserção ordenada de dados, verificações detalhadas de estado (vazia/cheia) e a inclusão de um **menu interativo no console** para testar a estrutura de dados em tempo real.

---

## 📚 Exercícios

O objetivo principal desta atividade é aprimorar a estrutura onde os elementos permanecem organizados sequencialmente na memória, garantindo integridade e ausência de "buracos" no array, agora com a possibilidade de testar as lógicas dinamicamente através da classe principal.

### A classe MyArrayList implementa as seguintes operações fundamentais da interface MyArrayListTad:

- **➕ Inserção (Shift Right)**
  - `addFirst(int newItem)`: Insere um dado no início da lista, deslocando todos os elementos pré-existentes uma casa para a direita.
  - `addLast(int newItem)`: Insere o elemento na primeira posição livre ao final da lista.
  - `insertAt(int indice, int newItem)`: Insere um elemento em um índice específico, realizando o deslocamento necessário à direita a partir daquela posição.
  - `addSorted(int newItem)`: **(NOVO)** Descobre a posição correta e insere o elemento mantendo a ordem crescente da lista, realizando o deslocamento automático à direita.

- **➖ Remoção (Shift Left)**
  - `removeFirst()`: Remove o primeiro dado da lista, deslocando os demais elementos uma casa para a esquerda.
  - `removeLast()`: Remove o último elemento inserido (apenas decrementando o contador de itens).
  - `removeAt(int indice)`: Remove o elemento de uma posição específica e desloca os subsequentes para a esquerda para manter a continuidade.
  - `remove(int item)`: Localiza e remove a primeira ocorrência do valor informado na lista.

- **🔍 Busca e Atualização**
  - `find(int item)`: Vasculha a lista e retorna o índice onde o elemento foi encontrado (ou -1 se não existir).
  - `get(int indice)`: Retorna o valor alocado no índice solicitado.
  - `set(int indice, int newItem)`: Substitui o dado existente em um índice específico por um novo valor.

- **🛠️ Controle de Estado e Utilitários**
  - `isEmpty()`: **(NOVO)** Verifica se a lista está completamente vazia.
  - `isFull()`: **(NOVO)** Verifica se a lista atingiu sua capacidade máxima.
  - `count()`: **(NOVO)** Retorna a quantidade atual de itens na lista.
  - `display()`: Exibe de forma formatada na tela o estado atual da lista (ex: `[ 1 2 3 ]`).

---

## 🚀 Recursos Implementados

O projeto inclui:

- Código em Java puro (sem frameworks).
- **Menu interativo via console (`Main.java`)** para criar a lista com capacidade personalizada e testar todas as operações repetidamente através da classe `Scanner`.
- Uso da interface `MyArrayListTad` para definir o contrato do Tipo Abstrato de Dados (TAD).
- Organização lógica focada no controle de estado interno com variáveis encapsuladas (`private`).
- Lógica de deslocamento de dados no array (shift right e shift left) para as operações de inserção e remoção.
- Tratamento de exceções (como `IndexOutOfBoundsException`) e mensagens de erro no console para índices inválidos ou limites de array.

---

## 🧩 Estrutura de Pastas

```text
├── src/
│   ├── Main.java
│   ├── MyArrayListTad.java
│   └── MyArrayList.java
```

## 🛠️ Pré-requisitos

Antes de compilar/rodar, você precisa ter:

- **Java JDK 11+** instalado
- Uma IDE ou editor de código (como IntelliJ IDEA, Eclipse ou VS Code)

## 💻 Executar o exercício
- main.java
- MyArrayList.java
- MyArrayListTad.java
