package MaShiBing;

public class ThreadTest {
    public static void main(String[] args) {

        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();
        for(int i = 0; i < 100; i++){
            System.out.println("main :" + i);
        }

    }

}
class Runner implements Runnable{
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("Runner" + i);
        }
    }
}