package MaShiBing;

import java.util.*;

import static java.lang.Thread.sleep;

public class ThreadSleep {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);

        thread.start();
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    static class Runner implements Runnable{

        @Override
        public void run() {
            while(true){
                System.out.println(new Date());
                try{
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}


