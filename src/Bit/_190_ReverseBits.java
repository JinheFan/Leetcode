package Bit;

public class _190_ReverseBits {
    /**
     * 190. Reverse Bits
     * Reverse bits of a given 32 bits unsigned integer.

     For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
     return 964176192 (represented in binary as 00111001011110000010100101000000).

     time : O(1) / O(logn)
     space : O(1)
     */
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }
}
