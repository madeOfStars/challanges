/*
https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
package recursion;

public class KthSymbolInGrammarI {
    public int kthGrammar(int N, int K) {
        if (N == 1)
            return 0;

        if (K % 2 == 0)
            return kthGrammar(N - 1, K / 2) == 0 ? 1 : 0;
        else
            return kthGrammar(N - 1, (K + 1) / 2);
    }

    public static void main(String[] args) {
        KthSymbolInGrammarI ks = new KthSymbolInGrammarI();

        System.out.println(ks.kthGrammar(1, 1));
        System.out.println(ks.kthGrammar(2, 1));
        System.out.println(ks.kthGrammar(2, 2));
        System.out.println(ks.kthGrammar(4, 5));
        System.out.println(ks.kthGrammar(30, 434991989));
    }
}
