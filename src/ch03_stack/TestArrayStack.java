package ch03_stack;

/**
 * Test the self-defined stack class.
 *
 * @author  StrongXGP
 * @date    2018/06/12
 */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i=0; i<5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
