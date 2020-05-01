package MaShiBing;

import java.util.Stack;

public class ProducerConsumer {
    public static void main(String[] args) {

        Basket basket = new Basket();
        Producer producer = new Producer(basket);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(basket);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Bread{
    int id;
    public Bread(int id) {
        this.id = id;
    }
}

class Basket{
    int size = 10;
    Stack<Bread> stack = new Stack<>();

    public synchronized void push(Bread bread){
        if(stack.size() == size){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        stack.push(bread);
    }

    public synchronized Bread pop(){
        if(stack.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return stack.pop();
    }
}

class Producer implements Runnable{

    Basket basket;

    public Producer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            Bread bread = new Bread(i);
            basket.push(bread);
            System.out.println("Producer : " + bread.id);
        }
    }
}

class Consumer implements Runnable{

    Basket basket;

    public Consumer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            Bread bread = basket.pop();
            System.out.println("Consumer : " + bread.id);
        }
    }
}

