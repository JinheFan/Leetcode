package Amazon;
/**
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * */
import java.util.PriorityQueue;

public class _295_MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public _295_MedianFinder() {
        this.small = new PriorityQueue<>((a, b) -> (b - a));
        this.large = new PriorityQueue<>();
    }

    public void add(int val){
        large.offer(val);
        small.offer(large.poll());
        if(large.size() < small.size()){
            large.offer(small.poll());
        }
    }

    public double median(){
        return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        _295_MedianFinder finder = new _295_MedianFinder();
        finder.add(1);
        finder.add(2);
        System.out.println(finder.median());
    }
}
