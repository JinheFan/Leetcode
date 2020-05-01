package MaShiBing;

public class ThreadTest2 {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        for(int i = 0; i < 100; i++){
            System.out.println("Main :" + i);
        }
    }
    static class Runner extends Thread{
        @Override
        public void run(){
            for(int i = 0; i < 100; i++){
                System.out.println("Runner :" + i);
            }
        }
    }
}


