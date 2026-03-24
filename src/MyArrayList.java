import java.util.Scanner;

public class MyArrayList {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        int[] origenArray = {10, 20, 30, 40, 50,};
        int[] modifArray;
        System.out.println("Lista inicial:");
        display(origenArray);
        System.out.println();

        if(IsFull(origenArray)) {
            System.out.println("Vetor cheio");
            int[] temporaryArray = new int[origenArray.length*2];
            for (int i = 0; i< origenArray.length;i++) temporaryArray[i] = origenArray[i];
            origenArray=temporaryArray;
        }

        if(IsEmpty(origenArray)) System.out.println("Vetor vazio");

        System.out.println("--- addFirst, addLast, AddSorted insertAt ---");
        System.out.println("Number: ");
        int number = sc.nextInt();
        System.out.println("Index: ");
        int index = sc.nextInt();
        System.out.println();

        addFirst(origenArray,number);
        addLast(origenArray,number);
        addSorted(origenArray,number);
        insertAt(origenArray,index,number);
        System.out.println();

        System.out.println("--- removeFirst, removeLast, removeAt, remove ---");
        System.out.println("Number: ");
        number = sc.nextInt();
        System.out.println("Index: ");
        index = sc.nextInt();
        System.out.println();

        removeFirst(origenArray);
        removeLast(origenArray);
        removeAt(origenArray, index);
        remove(origenArray,number);
        System.out.println();

        System.out.println("--- find, get ---");
        System.out.println("Number: ");
        number = sc.nextInt();
        System.out.println("Index: ");
        index = sc.nextInt();
        System.out.println();

        find(origenArray, number);
        get(origenArray, index);
        System.out.println();

        System.out.println("--- set ---");
        System.out.println("Number: ");
        number = sc.nextInt();
        System.out.println("Index: ");
        index = sc.nextInt();
        System.out.println();
        set(origenArray,index,number);
        System.out.println();

    }

    // Metodos Parte II
    public static void display(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int count(int[] array) {
        int c = 0;
        for (int i =0;i< array.length;i++){
            if (array[i]!=-1)c++;
        }
        return c;
    }
    public static boolean IsFull(int[] array){
        if (count(array)==array.length) return true;
        else return false;
    }

    public static boolean IsEmpty(int[] array){
        if (count(array)==0) return true;
        else return false;
    }
    public static void addSorted(int[] array, int number){
        int[] novoArray = new int[array.length + 1];
        int i = 0;

        while (i < array.length && array[i] < number) {
            novoArray[i] = array[i];
            i++;
        }
        novoArray[i] = number;

        while (i < array.length) {
            novoArray[i + 1] = array[i];
            i++;
        }

        System.out.println("Add Sorted\nNumber: "+number);
        display(novoArray);
    }

    // Metodos da Parte I

    public static void addFirst(int[] array, int number) {
        int[] novoArray = new int[array.length + 1];
        novoArray[0] = number;

        for (int i = 0; i < array.length; i++) {
            novoArray[i + 1] = array[i];
        }
        System.out.println("Add First");
        display(novoArray);
    }
    public static void addLast(int[] array, int number) {
        int[] novoArray = new int[array.length + 1];
        novoArray[array.length]=number;
        for (int i = 0; i < array.length; i++){
            novoArray[i] = array[i];
        }
        System.out.println("Add Last");
        display(novoArray);
    }

    public static void insertAt(int[] array, int indice, int number) {
        int[] novoArray = new int[array.length + 1];
        for (int i = 0; i < indice; i++) {
            novoArray[i] = array[i];
        }
        novoArray[indice] = number;
        for (int i = indice; i < array.length; i++) {
            novoArray[i + 1] = array[i];
        }
        System.out.println("Insert \nAt: "+indice+"\nNumber: "+number);
        display(novoArray);
    }

    public static void removeFirst(int[] array) {
        int[] novoArray = new int[array.length - 1];
        for (int i = 0; i < novoArray.length; i++) novoArray[i] = array[i + 1];
        System.out.println("Remove First");
        display(novoArray);
    }

    public static void removeLast(int[] array) {
        int[] novoArray = new int[array.length - 1];
        for (int i = 0; i < novoArray.length; i++) novoArray[i] = array[i];
        System.out.println("Remove Last");
        display(novoArray);
    }

    public static void removeAt(int[] array, int indice) {

        int[] novoArray = new int[array.length - 1];

        for (int i = 0; i < indice; i++) {
            novoArray[i] = array[i];
        }
        novoArray[indice] = 0;
        for (int i = indice; i < novoArray.length; i++) novoArray[i] = array[i + 1];
        System.out.println("Remove At\nAt: "+indice);
        display(novoArray);
    }

    public static void remove(int[] array, int number) {
        int indice=-1;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==number){
                indice = i;
                break;
            }
        }
        if (indice == -1) {

            System.out.println("Remove\nErro: Número " + number + " não encontrado na lista.");
            return;
        }
        int[] novoArray = new int[array.length-1];
        for (int i = 0; i < indice; i++) {
            novoArray[i] = array[i];
        }
        for (int i = indice; i < novoArray.length; i++) {
            novoArray[i] = array[i + 1];
        }
        System.out.println("Remove \nNumber: "+number);
        display(novoArray);
    }

    public static void find(int[] array, int number){
        int indice = -1;
        for (int i =0; i< array.length; i++){
            if (array[i]==number) {
                indice = i;
                break;
            }
        }
        if (indice==-1) System.out.println("This number"+number+" don´t exist in this array.");
        else System.out.println("Find \nAt: " +indice+"\nNumber: "+ number);
    }
    public static void get(int[] array, int indice){
        System.out.println("Get \nAt: "+indice+"\nNumber: "+array[indice]);
    }

    public static void set(int[] array, int indice, int number){
        array[indice]=number;
        System.out.println("Set \nAt: "+indice+"\nNumber: "+number);
        display(array);
    }
}