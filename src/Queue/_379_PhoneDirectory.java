package Queue;
/**
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 *
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 *
 * // Assume it returns 1.
 * directory.get();
 *
 * // The number 2 is available, so return true.
 * directory.check(2);
 *
 * // It returns 2, the only number that is left.
 * directory.get();
 *
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 *
 * // Release number 2 back to the pool.
 * directory.release(2);
 *
 * // Number 2 is available again, return true.
 * directory.check(2);*/
        import java.util.HashSet;
        import java.util.LinkedList;
        import java.util.Queue;

public class _379_PhoneDirectory {

    int maxNum;
    Queue<Integer> queue;
    HashSet<Integer> used;

    public _379_PhoneDirectory(int maxNum) {
        this.maxNum = maxNum;
        this.queue = new LinkedList<>();
        this.used = new HashSet<>();
        for (int i = 0; i < maxNum; i++) {
            queue.offer(i);
        }
    }

    public int get(){
        Integer res = queue.poll();
        if(res == null){
            return -1;
        }
        used.add(res);
        return res;
    }

    public boolean check(int val){
        if(val < 0 || val >= maxNum){
            return false;
        }
        return !used.contains(val);
    }

    public void release(int val){
        if(used.remove(val)){
            queue.offer(val);
        }
    }
}
