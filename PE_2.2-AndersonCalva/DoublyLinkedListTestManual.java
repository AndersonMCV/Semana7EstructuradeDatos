public class DoublyLinkedListTestManual {

    static DoublyLinkedList list;
    static int pruebasTotales = 0;
    static int pruebasPasadas = 0;

    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS MANUALES PARA DoublyLinkedList ===\n");

        testInsertIntoEmptyList();
        testDeleteFromEmptyList();
        testDeleteOnlyElement();
        testDeleteHeadMultipleElements();
        testDeleteTailMultipleElements();
        testDeleteMiddleNode();
        testDeleteNonExistentValue();
        testReverseEmptyList();
        testReverseSingleElement();
        testReverseMultipleElements();
        testIsEmptyVariousStates();
        testMultipleInsertionsAndPointers();

        System.out.println("\n=== RESUMEN DE PRUEBAS ===");
        System.out.println("Total de pruebas: " + pruebasTotales);
        System.out.println("Pasadas: " + pruebasPasadas);
        System.out.println("Fallidas: " + (pruebasTotales - pruebasPasadas));

        if (pruebasPasadas == pruebasTotales) {
            System.out.println("¡TODAS LAS PRUEBAS PASARON EXITOSAMENTE!");
        } else {
            System.out.println("Algunas pruebas fallaron. Revisa los mensajes arriba.");
        }
    }

    private static void iniciarPrueba(String id, String descripcion) {
        pruebasTotales++;
        System.out.println("[" + id + "] " + descripcion);
        list = new DoublyLinkedList();
    }

    private static void afirmar(boolean condicion, String mensajeError) {
        if (!condicion) {
            System.out.println("    ✗ FALLÓ: " + mensajeError);
            throw new AssertionError(mensajeError); // detiene la prueba actual
        } else {
            System.out.print(".");
        }
    }

    private static void finPrueba() {
        pruebasPasadas++;
        System.out.println(" → PASÓ");
    }

    // TC-DLL-001
    private static void testInsertIntoEmptyList() {
        iniciarPrueba("TC-DLL-001", "Insertar en lista vacía");
        list.InsertAtEnd(10);

        afirmar(!list.isEmpty(), "La lista no debería estar vacía después de insertar");
        afirmar(list.head.data == 10, "head.data debería ser 10");
        afirmar(list.tail.data == 10, "tail.data debería ser 10");
        afirmar(list.head.prev == null, "head.prev debe ser null");
        afirmar(list.tail.next == null, "tail.next debe ser null");
        afirmar(list.head == list.tail, "head y tail deben apuntar al mismo nodo");

        finPrueba();
    }

    // TC-DLL-002
    private static void testDeleteFromEmptyList() {
        iniciarPrueba("TC-DLL-002", "Eliminar en lista vacía");
        boolean resultado = list.deleteByValue(99);

        afirmar(!resultado, "deleteByValue debe retornar false en lista vacía");
        afirmar(list.head == null, "head debe seguir siendo null");
        afirmar(list.tail == null, "tail debe seguir siendo null");

        finPrueba();
    }

    // TC-DLL-003
    private static void testDeleteOnlyElement() {
        iniciarPrueba("TC-DLL-003", "Eliminar único elemento (head == tail)");
        list.InsertAtEnd(50);
        boolean resultado = list.deleteByValue(50);

        afirmar(resultado, "deleteByValue debe retornar true al eliminar el único elemento");
        afirmar(list.isEmpty(), "La lista debe quedar vacía");
        afirmar(list.head == null, "head debe ser null después de eliminar el único elemento");
        afirmar(list.tail == null, "tail debe ser null después de eliminar el único elemento");

        finPrueba();
    }

    // TC-DLL-004
    private static void testDeleteHeadMultipleElements() {
        iniciarPrueba("TC-DLL-004", "Eliminar head en lista con múltiples elementos");
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        boolean resultado = list.deleteByValue(10);

        afirmar(resultado, "Debe retornar true al eliminar el head");
        afirmar(list.head.data == 20, "El nuevo head debe tener data = 20");
        afirmar(list.head.prev == null, "El nuevo head.prev debe ser null");
        afirmar(list.tail.data == 30, "tail debe seguir siendo 30");

        finPrueba();
    }

    // TC-DLL-005
    private static void testDeleteTailMultipleElements() {
        iniciarPrueba("TC-DLL-005", "Eliminar tail en lista con múltiples elementos");
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        boolean resultado = list.deleteByValue(30);

        afirmar(resultado, "Debe retornar true al eliminar el tail");
        afirmar(list.tail.data == 20, "El nuevo tail debe tener data = 20");
        afirmar(list.tail.next == null, "El nuevo tail.next debe ser null");
        afirmar(list.head.data == 10, "head debe seguir siendo 10");

        finPrueba();
    }

    // TC-DLL-006
    private static void testDeleteMiddleNode() {
        iniciarPrueba("TC-DLL-006", "Eliminar nodo intermedio");
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        list.InsertAtEnd(40);
        boolean resultado = list.deleteByValue(20);

        afirmar(resultado, "Debe retornar true al eliminar nodo intermedio");
        afirmar(list.head.next.data == 30, "Después de 10 debe venir 30");
        afirmar(list.head.next.prev.data == 10, "El prev de 30 debe ser 10");
        afirmar(list.head.next.next.data == 40, "Después de 30 debe venir 40");

        finPrueba();
    }

    // TC-DLL-007
    private static void testDeleteNonExistentValue() {
        iniciarPrueba("TC-DLL-007", "Eliminar valor inexistente");
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        boolean resultado = list.deleteByValue(99);

        afirmar(!resultado, "Debe retornar false si el valor no existe");
        afirmar(list.head.data == 10, "La lista no debe modificarse");
        afirmar(list.tail.data == 20, "La lista no debe modificarse");

        finPrueba();
    }

    // TC-DLL-008
    private static void testReverseEmptyList() {
        iniciarPrueba("TC-DLL-008", "Invertir lista vacía");
        list.reverse();

        afirmar(list.isEmpty(), "Lista vacía debe seguir vacía después de reverse");
        afirmar(list.head == null, "head debe ser null");
        afirmar(list.tail == null, "tail debe ser null");

        finPrueba();
    }

    // TC-DLL-009
    private static void testReverseSingleElement() {
        iniciarPrueba("TC-DLL-009", "Invertir lista con un solo elemento");
        list.InsertAtEnd(42);
        list.reverse();

        afirmar(list.head.data == 42, "El dato debe seguir siendo 42");
        afirmar(list.tail.data == 42, "El dato debe seguir siendo 42");
        afirmar(list.head.prev == null, "head.prev debe ser null");
        afirmar(list.tail.next == null, "tail.next debe ser null");

        finPrueba();
    }

    // TC-DLL-010
    private static void testReverseMultipleElements() {
        iniciarPrueba("TC-DLL-010", "Invertir lista con múltiples elementos");
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        list.reverse();

        afirmar(list.head.data == 30, "Head después de reverse debe ser 30");
        afirmar(list.tail.data == 10, "Tail después de reverse debe ser 10");
        afirmar(list.head.prev == null, "head.prev debe ser null después de reverse");
        afirmar(list.tail.next == null, "tail.next debe ser null después de reverse");
        afirmar(list.head.next.data == 20, "El siguiente del head debe ser 20");

        finPrueba();
    }

    // TC-DLL-011
    private static void testIsEmptyVariousStates() {
        iniciarPrueba("TC-DLL-011", "Verificar isEmpty en diferentes estados");
        afirmar(list.isEmpty(), "Lista recién creada debe estar vacía");

        list.InsertAtEnd(5);
        afirmar(!list.isEmpty(), "Después de insertar no debe estar vacía");

        list.deleteByValue(5);
        afirmar(list.isEmpty(), "Después de eliminar el único elemento debe estar vacía");

        finPrueba();
    }

    // TC-DLL-012
    private static void testMultipleInsertionsAndPointers() {
        iniciarPrueba("TC-DLL-012", "Múltiples inserciones y verificación de punteros");
        list.InsertAtEnd(1);
        list.InsertAtEnd(2);
        list.InsertAtEnd(3);

        afirmar(list.head.prev == null, "head.prev debe ser null");
        afirmar(list.head.next.data == 2, "El siguiente del head debe ser 2");
        afirmar(list.head.next.prev.data == 1, "El prev del nodo 2 debe ser 1");
        afirmar(list.tail.data == 3, "tail debe ser 3");
        afirmar(list.tail.next == null, "tail.next debe ser null");

        finPrueba();
    }
}
