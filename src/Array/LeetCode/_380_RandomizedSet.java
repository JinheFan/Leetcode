package Array.LeetCode;
/**
* // Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _380_RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rmd;

    public _380_RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rmd = new Random();
    }

    public boolean insert(int val){
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastVal = list.remove(list.size() - 1);
        if(index != list.size()){
            map.put(lastVal, index);
            list.set(index, lastVal);
        }
        return true;
    }

    public int getRandom(){
        return list.get(rmd.nextInt(list.size()));
    }

    public static void main(String[] args) {
        _380_RandomizedSet randomize = new _380_RandomizedSet();
        randomize.insert(1);
        randomize.insert(2);
        randomize.insert(3);
        randomize.remove(2);
        System.out.println(randomize.getRandom());
    }
}
