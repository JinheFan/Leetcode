package Heap.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueClass {
    static class Node{
        private int a;
        private int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });
        Node node1 = new Node(1, 2);
        Node node2 = new Node(2, 3);
        priorityQueue.offer(node1);
        priorityQueue.offer(node2);
        System.out.println(priorityQueue.poll().a);

    }
}
