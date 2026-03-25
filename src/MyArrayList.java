public class MyArrayList implements MyArrayListTad{

    private int[] items;
    private int capacity;
    private int count;

    public MyArrayList(int size){
    this.capacity = size;
    this.items = new int[capacity];
    this.count=0;
    }

    @Override
    public boolean isEmpty(){return count == 0;}

    @Override
    public boolean isFull(){return count == capacity;}

    @Override
    public int count() {return count;}

    // Os métodos de inserção

    @Override
    public void addFirst(int newItem){
        if (isFull()){
            System.out.println("Erro\nArray esta completa."); return;
        }
        for (int i=count; i>0; i--) items[i]=items[i-1];
        items[0]=newItem;
        count++;
    }

    @Override
    public void addLast(int newItem){
    if (isFull()){
        System.out.println("Erro\nArray esta completa"); return;
    }
    items[count++]=newItem;
    }

    public void addSort(int newItem){
        if (isFull()){
            System.out.println("Erro!\nArray esta completa");
        }
        int index = 0;
        for (int i =0; i<count; i++){
            if(newItem<items[i]){
                index = i;
                break;
            }
        }
        for(int i=count; i>index; i--)items[i]=items[i-1];
        items[index]=newItem;
        count++;
    }

    @Override
    public void insertAt(int index, int newItem){
        if (isFull() || index<0 || index>count){
            System.out.println("Erro\nIndice não existe ou array completa"); return;
        }
        count++;
        for (int i=count; i>index; i--) items[i]=items[i-1];
        items[index]=newItem;
    }

    // Os métodos de remoção

    @Override
    public void removeFirst(){
        if (isEmpty()){
            System.out.println("Erro\nArray vazia"); return;
        }
        items[0]=0;
        for (int i = 0; i < count; i++) items[i] = items [i+1];
        count--;
    }

    @Override
    public void removeLast(){
        if (isEmpty()){
            System.out.println("Erro\nArray vazia"); return;
        }
        items[count]=0;
        count--;
    }

    @Override
    public void removeAt(int index){
        if (isEmpty() || index<0 || index>count){
            System.out.println("Erro\nIndice não existe ou array vazia"); return;
        }
        for (int i = index; i<count-1; i++)items[i]=items[i+1];
        count--;
    }

    @Override
    public void remove(int item){
        if (isEmpty()){
            System.out.println("Erro\nArray vazia"); return;
        }
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Item não encontrado");
            return;
        }
        for (int j = index; j < count - 1; j++) {
            items[j] = items[j + 1];
        }
        count--;
    }

    // Os métodos de busca

    @Override
    public void find(int item){
        int index = -1;
        if (isEmpty()){
            System.out.println("Erro! \nArray vazia"); return;
        }

        for (int i = 0; i < count; i++) if(items[i]==item)index=i;

        if (index==-1) {
            System.out.println("Indice invalido!");return;
        }
        System.out.println("Indice: "+index);
    }

    @Override
    public void get(int index){
        if (isEmpty() || index<0 || index>count){
            System.out.println("Erro! \nIndice invalido ou array vazia");return;
        }
        System.out.println(items[index]);
    }
    // Os métodos de atualização

    @Override
    public void set(int index, int item){
        if (isEmpty() || index<0 || index>count){
            System.out.println("Erro! \nIndice invalido ou array vazia");
        }
        items[index]=item;
    }

    // Os métodos de visualização

    @Override
    public void display(){
        for (int i = 0; i < count; i++){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }


}

