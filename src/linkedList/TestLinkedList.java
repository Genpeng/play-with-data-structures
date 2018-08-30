package linkedList;

/**
 * Test the self-defined class {@code LinkedList}.
 *
 * @author  StrongXGP
 * @date    2018/06/20
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 66);
        System.out.println(linkedList);
    }
}
