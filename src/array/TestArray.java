package array;

/**
 * Test the self-defined array.
 *
 * @author  StrongXGP
 * @date    2018/06/11
 */
public class TestArray {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.addLast(0);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        System.out.println(array);

        array.insert(1, 99);
        System.out.println(array);

        array.addFirst(100);
        System.out.println(array);

        array.addLast(999);
        System.out.println(array);

        System.out.println(array.find(99));

        System.out.println(array.contains(7));

        array.remove(0);
        System.out.println(array);

        array.remove(1);
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeLast();
        array.removeLast();
        array.removeLast();
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        System.out.println(array.get(1));

        array.set(0, 99);
        System.out.println(array);

        // Use Student class to test Array class
        // ================================================================================ //
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("01", "xugenpeng", 98));
        arr.addLast(new Student("02", "zhangjun", 100));
        System.out.println(arr);
    }
}
