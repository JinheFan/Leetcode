package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [1, 2, 3] ->
//[1, 2]
//[1, 3]
//[2, 3]
public class Combination {

    public static void combination(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);
        for(int i = 0; i < res.size(); i++){
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
        if(k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            helper(res, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        combination(3, 2);
    }
}
