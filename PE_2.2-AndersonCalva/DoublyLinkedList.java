public class DoublyLinkedList {
    public DLL_Node head;
    public DLL_Node tail;

    // inicializar mi lista doble

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // head es null
    public boolean isEmpty() {
        return head == null;

    }

    // Insetar nodo al final
    public void InsertAtEnd(int data) {
        DLL_Node newNode = new DLL_Node(data);

        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.print("Lista vacia");
            return;
        }

        DLL_Node current = head;

        while ( (current !=null)) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("<--->");
            }
            current = current.next;
        }


        System.out.println();
    }

    public void reverse() {
        if(isEmpty() || head == tail){
            return;
        }
        DLL_Node current = head;
        DLL_Node temp = null;

        while (current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean deleteByValue(int data) {
        if(isEmpty()) {
            return false;
        }

        DLL_Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if(current == null) return false; // no pudimos eliminar porque no encontramos un valor

        // Caso 1: Valor a eliminar es el head
        if(current == head ) {
            head = head.next;
            if(head != null){
                head.prev = null;
            } else {
                tail = null; // lista quedo vacia
            }
        }else if (current == tail) {
            // Caso 2: Vamos a eliminar tail
            tail = tail.prev;
            tail.next = tail=null;
        }else {
            // si el nodo a eliminar es intermedio
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return true;

    }
}