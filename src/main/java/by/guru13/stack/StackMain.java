package by.guru13.stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>();
        stringStack.push("1");
        stringStack.push("2");
        stringStack.push("3");
        stringStack.push("4");
        stringStack.push("5");
        checkWhile(stringStack);
    }

    static void checkWhile(Stack<String> stack) {
        System.out.println("Stack start size-----" + stack.size());
        while (stack.size() > 0) {
            System.out.println("Stack current0 size-----" + stack.size());
            stack.pop();
            System.out.println("Stack current1 size-----" + stack.size());
            stack.pop();
            System.out.println("Stack current2 size-----" + stack.size());
        }
        System.out.println("Stack final size-----" + stack.size());
    }
}
