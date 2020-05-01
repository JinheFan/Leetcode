package Google;
/**
 * 有两行骰子， 每行个数一样多
 * 然后定义一个换位操作，就是在某一个index， 把两行骰子在这个index上的位置互换
 * 问， 最少经过多少次操作以后，可以让两行骰子里面的某一行的值都是一样的
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 *
 * */
public class _1007_MinDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;          // A 这行变成 A[0] 所需要的次数
            if (B[i] != A[0]) b++;          // B 这行变成 A[0] 所需要的次数
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
}
