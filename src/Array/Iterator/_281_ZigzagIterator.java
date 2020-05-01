package Array.Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _281_ZigzagIterator {
    /**
     * 281. Zigzag Iterator
     * For example, given two 1d vectors:

     v1 = [1, 2]
     v2 = [3, 4, 5, 6]

     output : 1 3 2 4 5 6

     [1,2,3]
     [4,5,6,7]
     [8,9]
     It should return [1,4,8,2,5,9,3,6,7].

     time : O(n)
     space : O(1)
     */

    Queue<Iterator> q;

    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList();
        if (!v1.isEmpty()) q.offer(v1.iterator());  // 放进去的是个整体（V1）， 不是单独的值
        if (!v2.isEmpty()) q.offer(v2.iterator());
    }

    public int next() {
        Iterator cur = q.poll();
        int res = (int) cur.next();
        if (cur.hasNext()) q.offer(cur);
        return res;
    }

    public boolean hasNext() {
        return q.peek() != null;
    }
}
