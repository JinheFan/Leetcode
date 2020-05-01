package BackTracking;
/**
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Input: n = 3, k = 3
 * Output: "213"
 * */
import java.util.ArrayList;
import java.util.List;

public class _60_getPermutation {
    public static String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n);
        List<Integer> list = res.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for(Integer num : list){
            sb.append("" + num);
        }
        return sb.toString();
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                helper(res, list, n);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n, k));
    }
}
