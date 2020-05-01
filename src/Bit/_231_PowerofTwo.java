package Bit;

public class _231_PowerofTwo {
    /**
     * 231. Power of Two
     * Given an integer, write a function to determine if it is a power of two.
     *
     *
     * 2, 4, 8, 16...
     *
     * 2 : 10
     * 4 : 100
     * 8 : 1000
     * 16: 10000
     *
     * time : O(1);
     * space : O(1);
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
