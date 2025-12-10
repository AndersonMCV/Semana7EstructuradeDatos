public class DLL_Node {
    int data;
    DLL_Node prev; // Puntero al anterior
    DLL_Node next; // Puntero al siguiente

    public DLL_Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}