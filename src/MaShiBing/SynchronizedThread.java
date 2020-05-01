package MaShiBing;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class SynchronizedThread {
    public static void main(String[] args) {
        Runner r1 = new Runner("t1");
        Thread t1 = new Thread(r1);

        Runner r2 = new Runner("t2");
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    static class Runner implements Runnable{

        String name;

        public Runner(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            Timer timer = new Timer();
            timer.Count();
        }
    }

}
class Timer{
    static int num = 0;
    public  synchronized void Count(){
        this.num++;
        try{
            sleep(1);
        } catch (InterruptedException e) {
           //e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}