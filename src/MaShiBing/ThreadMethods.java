package MaShiBing;

public class ThreadMethods {
    static class Person{
        int id = 100;
        public synchronized void Modify(){
            id = 1000;
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + id);
        }

        public void UnModify(){
            System.out.println(Thread.currentThread().getName() + " " + id);
        }
    }
    static class Runner implements Runnable{

        @Override
        public void run() {
            Person person = new Person();
            person.Modify();
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);

        thread.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Person person = new Person();
        person.UnModify();

    }
}


