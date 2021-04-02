/*
https://leetcode.com/problems/permutation-sequence/
 */
package recursion;

public class PermutationsSequence {
    private int count = 0;
    private String answer = "";

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        boolean[] used = new boolean[n + 1];

        getPermutation(n, k, new StringBuilder(), used);

        return answer;
    }

    private void getPermutation(int n, int k, StringBuilder perm, boolean[] used) {
        if (!answer.equals(""))
            return;

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                perm.append(i);
                used[i] = true;

                if (perm.length() == n) {
                    count++;
                    if (count == k) {
                        answer = perm.toString();
                    }
                } else {
                    getPermutation(n, k, perm, used);
                }
                used[i] = false;
                perm.setLength(perm.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsSequence p = new PermutationsSequence();

        System.out.println(p.getPermutation(3, 3));
    }
}
