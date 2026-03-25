public interface MyArrayListTad{
    void addFirst(int newItem);
    void addLast(int newItem);
    void addSort(int newItem);
    void insertAt(int indice, int newItem);
    void removeFirst();
    void removeLast();
    void removeAt(int indice);
    void remove(int number);
    void find(int item);
    void get(int indice);
    void set(int indice, int newItem);
    boolean isEmpty();
    boolean isFull();
    int count();
    void display();
}
