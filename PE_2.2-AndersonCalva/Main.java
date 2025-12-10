public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Lista vacia: " + list.isEmpty());

        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        list.InsertAtEnd(40);
        list.InsertAtEnd(50);
        list.InsertAtEnd(60);
        list.InsertAtEnd(70);
        list.InsertAtEnd(80);
        list.InsertAtEnd(90);
        list.InsertAtEnd(00);

        System.out.print("Lista creada: ");
        list.display();

        System.out.println("Parte 2");
        System.out.println("Lista original");
        list.display();
        System.out.println("Lista reverse");
        list.reverse();
        list.display();

        DoublyLinkedList singleList = new DoublyLinkedList();

        System.out.println("Un solo elemento (Caso borde");
        singleList.InsertAtEnd(60);
        singleList.display();
        System.out.println("Reversa");
        singleList.reverse();
        singleList.display();

        System.out.println("Parte 3");
        System.out.println("Parte 3.1");
        System.out.println("lista original");
        list.display();
        System.out.println("nodo eliminado");
        list.deleteByValue(40);
        list.display();

    }
}
