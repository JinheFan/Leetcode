package Array.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorBasic {

    public static void Iter (){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }

        for (Integer i : list) {
            System.out.print(i + ",");
        }

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ",");
        }

    }

    public static void main(String[] args) {
        Iter();
    }
}
