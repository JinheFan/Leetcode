package Array.LeetCode;

import java.util.List;

public class _251_Flatten2DVector {
    /**
     * 251. Flatten 2D Vector
     * Given 2d vector =

     [
     [1,2],
     [3],
     [4,5,6]
     ]
     By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].

     time : O(n)
     space : O(1)

     */

    int indexList, indexElement;
    List<List<Integer>> list;


    public _251_Flatten2DVector(List<List<Integer>> vec2d) {
        indexElement = 0;
        indexList = 0;
        list = vec2d;
    }


    //@Override
    public Integer next() {
        return list.get(indexList).get(indexElement++);
    }

    //@Override
    public boolean hasNext() {
        while (indexList < list.size()) {
            if (indexElement < list.get(indexList).size()) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}
