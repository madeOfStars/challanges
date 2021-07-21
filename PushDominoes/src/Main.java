/*
https://leetcode.com/problems/push-dominoes/
 */
public class Main {
    public String pushDominoes(String dominoes) {
        int size = dominoes.length();

        int[] weights = new int[size];
        int weight = 0;

        for (int i = 0; i < size; i++) {
            if (dominoes.charAt(i) == 'R')
                weight = size;
            else if (dominoes.charAt(i) == 'L')
                weight = 0;
            else weight = Math.max(weight - 1, 0);
            weights[i] = weight;
        }

        weight = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L')
                weight = size;
            else if (dominoes.charAt(i) == 'R')
                weight = 0;
            else weight = Math.max(weight - 1, 0);
            weights[i] -= weight;
        }

        StringBuilder sb = new StringBuilder();

        for (int el : weights) {
            if (el > 0)
                sb.append('R');
            else if (el < 0)
                sb.append('L');
            else
                sb.append('.');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.pushDominoes("RR.L"));
        System.out.println(m.pushDominoes(".L.R...LR..L.."));
    }
}
