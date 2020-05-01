package SegmentTree;
/**
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * */
public class _303_RangeSumQuery {
    static int[] sum;
    public static void rangeSum(int[] num){
        sum = new int[num.length + 1];
        for (int i = 0; i < num.length; i++) {
            sum[i + 1] = sum[i] + num[i];
        }
    }

    public static int range(int i, int j){
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] num = new int[]{-2, 0, 3, -5, 2, -1};
        rangeSum(num);
        System.out.println(range(2, 5));
    }
}
