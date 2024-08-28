// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return the nth ugly number

class Solution {
    public int nthUglyNumber(int n) {
        int[] t = new int[n + 1];

        t[1] = 1; 

        int i2 = 1; 
        int i3 = 1; 
        int i5 = 1; 

        for (int i = 2; i <= n; i++) {
            int i2th_ugly = t[i2] * 2;
            int i3rd_ugly = t[i3] * 3;
            int i5th_ugly = t[i5] * 5;

            t[i] = Math.min(Math.min(i2th_ugly, i3rd_ugly), i5th_ugly);

            if (t[i] == i2th_ugly) {
                i2++;
            }

            if (t[i] == i3rd_ugly) {
                i3++;
            }

            if (t[i] == i5th_ugly) {
                i5++;
            }
        }

        return t[n];
    }
}
