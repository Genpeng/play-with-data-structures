package linkedList;

import stack.Stack;

/**
 * Test the self-defined stack class {@code LinkedListStack}.
 *
 * @author  StrongXGP
 * @date    2018/06/21
 */
public class TestLinkedListStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i=0; i<5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
