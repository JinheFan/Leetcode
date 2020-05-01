package HashMap;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Random;

public class _380_InsertDeleteGetRandom {
    static HashMap<Integer, Integer> map;
    static List<Integer> list;
    static Random rmd;

    public _380_InsertDeleteGetRandom() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rmd = new Random();
    }

    public static boolean Insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public static boolean Delete(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int lastVal = list.remove(list.size() - 1);
        int index = map.remove(val);
        if(index != list.size()) {
            map.put(lastVal, index);
            list.set(index, lastVal);
        }
        return true;
    }

    public static int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }

}
