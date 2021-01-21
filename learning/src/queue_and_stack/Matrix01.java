/*
https://leetcode.com/problems/01-matrix/
 */
package queue_and_stack;

import java.util.*;

public class Matrix01 {
    private static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Set<Pair> visited = new HashSet<>();
                Queue<Pair> queue = new LinkedList<>();
                int count = 0;

                if (matrix[i][j] != 0) {
                    queue.add(new Pair(i, j));
                    visited.add(new Pair(i, j));

                    boolean interrupt = false;

                    while (!queue.isEmpty()) {
                        int size = queue.size();

                        for (int k = 0; k < size; k++) {
                            Pair polledPair = queue.poll();

                            if (matrix[polledPair.i][polledPair.j] == 0) {
                                matrix[i][j] = count;
                                interrupt = true;
                                break;
                            }


                            Pair pair = new Pair(polledPair.i, polledPair.j - 1);
                            insertToQueue(matrix, visited, queue, pair);

                            pair = new Pair(polledPair.i - 1, polledPair.j);
                            insertToQueue(matrix, visited, queue, pair);

                            pair = new Pair(polledPair.i, polledPair.j + 1);
                            insertToQueue(matrix, visited, queue, pair);

                            pair = new Pair(polledPair.i + 1, polledPair.j);
                            insertToQueue(matrix, visited, queue, pair);
                        }
                        if (interrupt)
                            break;
                        count++;
                    }
                }
            }
        }
        return matrix;
    }

    private void insertToQueue(int[][] matrix, Set<Pair> visited, Queue<Pair> queue, Pair pair) {
        if (isValid(matrix, pair) && !visited.contains(pair)) {
            queue.add(pair);
            visited.add(pair);
        }
    }

    private boolean isValid(int[][] matrix, Pair pair) {
        int i = pair.i;
        int j = pair.j;
        int n = matrix.length;

        return i >= 0 && i < n && j >= 0 && j < matrix[i].length;
    }

    public static void main(String[] args) {
        Matrix01 m = new Matrix01();

        int[][] matrix1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] matrix2 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(m.updateMatrix(matrix1)));
        System.out.println(Arrays.deepToString(m.updateMatrix(matrix2)));
    }
}
