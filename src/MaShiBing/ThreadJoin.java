package MaShiBing;

import static java.lang.Thread.sleep;


public class ThreadJoin {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 10; i++){
            System.out.println("Main");
        }
    }

    static class Runner implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println("Runner");
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }

        }
    }
}
