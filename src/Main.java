public class Main {

    public static void main(String[] args){
        MyArrayList List = new MyArrayList(10) {
        };

        //Test inserção
        System.out.println("INSEÇÂO");

        List.addFirst(40);
        List.display();
        List.addFirst(30);
        List.display();
        List.addFirst(20);
        List.display();
        List.addFirst(10);
        List.display();

        List.addLast(80);
        List.display();

        List.addSort(36);
        List.display();

        List.insertAt(5,70);
        List.display();

        //Test remove
        System.out.println("REMOVE");

        List.removeFirst();
        List.display();

        List.removeLast();
        List.display();

        List.removeAt(1);
        List.display();

        List.remove(40);
        List.display();

        //Test busca
        System.out.println("BUSCA");

        List.find(36);

        List.get(3);

        //Test atualização
        System.out.println("ATUALIZAÇÃO");

        List.set(1,100);
        List.display();
    }
}
