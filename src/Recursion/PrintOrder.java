package Recursion;

public class PrintOrder {
    public static void main(String[] args) {
        PrintOrder order = new PrintOrder();
        order.bar();
        System.out.println("main");
    }

    private void bar() {
        doWork();
        System.out.println("bar");
    }

    private void doWork() {
        doMore();
        System.out.println("doWork");
    }

    private void doMore() {
        System.out.println("doMore");
    }
}
