package MaShiBing;

public class ThreadPriority {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Thread thread1 = new Thread(runner1);

        Runner2 runner2 = new Runner2();
        Thread thread2 = new Thread(runner2);

        thread1.setPriority(Thread.NORM_PRIORITY + 4);
        thread1.start();
        thread2.start();
    }

    static class Runner1 implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                System.out.println("Runner1 :" + i);
            }
        }
    }

    static class Runner2 implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                System.out.println("Runner2 :" + i);
            }
        }
    }
}
