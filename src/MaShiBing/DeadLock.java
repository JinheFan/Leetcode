package MaShiBing;

public class DeadLock {
    static Object o1 = new Object();
    static Object o2 = new Object();
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Thread thread1 = new Thread(runner1);

        Runner2 runner2 = new Runner2();
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();
    }

    static class Runner1 implements Runnable{
        @Override
        public void run() {
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + " o1");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + " o2");
                }
            }
        }
    }

    static class Runner2 implements Runnable{
        @Override
        public void run() {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + " o2");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + " o1");
                }
            }
        }
    }
}
