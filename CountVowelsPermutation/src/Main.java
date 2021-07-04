/*
https://leetcode.com/problems/count-vowels-permutation/
 */
public class Main {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;

        long aCount = 1;
        long eCount = 1;
        long iCount = 1;
        long oCount = 1;
        long uCount = 1;


        for (int i = 1; i < n; i++) {
            long aCountNext = (eCount + iCount + uCount) % MOD;
            long eCountNext = (aCount + iCount) % MOD;
            long iCountNext = (eCount + oCount) % MOD;
            long oCountNext = (iCount) % MOD;
            long uCountNext = (iCount + oCount) % MOD;
            aCount = aCountNext;
            eCount = eCountNext;
            iCount = iCountNext;
            oCount = oCountNext;
            uCount = uCountNext;
        }
        long result = (aCount + eCount + iCount + oCount + uCount)  % MOD;
        return (int)result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.countVowelPermutation(2));
    }
}
