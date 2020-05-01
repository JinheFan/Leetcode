package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _341_FlattenNestedListIterator implements Iterator<Integer> {
    /**
     * 341. Flatten Nested List Iterator
     * Given a nested list of integers, implement an iterator to flatten it.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Example 1:
     Given the list [[1,1],2,[1,1]],

     By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

     Example 2:
     Given the list [1,[4,[6]]],

     By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

     time : O(n)
     space : O(n)

     */
    class NestedInteger{

        public  Integer getInteger(){
            return null;
        }

        public boolean isInteger(){
            return true;
        }

        public List<NestedInteger> getList(){
            return new ArrayList<>();
        }
    }

    Stack<NestedInteger> stack;

    public _341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    //@Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    //@Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }
}
