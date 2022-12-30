/*
https://leetcode.com/problems/evaluate-division/
 */

package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    private record Weight(String end, double value) {
    }

    private boolean stop = false;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Weight>> map = new HashMap<>();
        Set<String> letters = new HashSet<>();

        for (int i = 0; i < equations.size(); i++) {
            var equation = equations.get(i);

            var originalDirection = map.getOrDefault(equation.get(0), new ArrayList<>());
            originalDirection.add(new Weight(equation.get(1), values[i]));

            var invertedDirection = map.getOrDefault(equation.get(1), new ArrayList<>());
            invertedDirection.add(new Weight(equation.get(0), 1 / values[i]));

            map.put(equation.get(0), originalDirection);
            map.put(equation.get(1), invertedDirection);

            letters.add(equation.get(0));
            letters.add(equation.get(1));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            stop = false;
            var query = queries.get(i);
            double res = helper(map, letters, new HashSet<>(), query.get(0), query.get(1));
            ans[i] = !stop ? -1 : res;
        }

        return ans;
    }

    private double helper(Map<String, List<Weight>> map, Set<String> letters, Set<String> visited, String start, String end) {
        visited.add(start);
        double res = -1;

        if (!letters.contains(start) || !letters.contains(end)) {
            return -1;
        }

        if (start.equals(end)) {
            stop = true;
            return 1;
        }

        var list = map.get(start);

        for (Weight weight : list) {
            if (visited.contains(weight.end()))
                continue;
            res =  weight.value() * helper(map, letters, visited, weight.end(), end);
            if (stop) {
                return res;
            }
        }

        visited.remove(start);
        return res;
    }

    public static void main(String[] args) {
        EvaluateDivision m = new EvaluateDivision();

        var eq1 = List.of(
                List.of("a", "b"),
                List.of("b", "c")
        );

        double[] values1 = new double[]{2.0, 3.0};

        var queries1 = List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x")
        );

        System.out.println(Arrays.toString(m.calcEquation(eq1, values1, queries1))); // [6.0, 0.5, -1.0, 1.0, -1.0]

        var eq2 = List.of(
                List.of("a", "b"),
                List.of("b", "c"),
                List.of("bc", "cd")
        );

        double[] values2 = new double[]{1.5, 2.5, 5.0};

        var queries2 = List.of(
                List.of("a", "c"),
                List.of("c", "b"),
                List.of("bc", "cd"),
                List.of("cd", "bc")
        );

        System.out.println(Arrays.toString(m.calcEquation(eq2, values2, queries2))); // [3.75, 0.4, 5.0, 0.2]

        var eq3 = List.of(
                List.of("x1", "x2"),
                List.of("x2", "x3"),
                List.of("x3", "x4"),
                List.of("x4", "x5")
        );

        double[] values3 = new double[]{3.0, 4.0, 5.0, 6.0};

        var queries3 = List.of(
                List.of("x1", "x5"),
                List.of("x5", "x2"),
                List.of("x2", "x4"),
                List.of("x2", "x2"),
                List.of("x2", "x9"),
                List.of("x9", "x9")
        );

        System.out.println(Arrays.toString(m.calcEquation(eq3, values3, queries3))); // [360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000]

        var eq4 = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        double[] values4 = new double[]{1.0, 1.0};

        var queries4 = List.of(
                List.of("a", "c"),
                List.of("b", "d"),
                List.of("b", "a"),
                List.of("d", "c")
        );

        System.out.println(Arrays.toString(m.calcEquation(eq4, values4, queries4))); // [["a","c"],["b","d"],["b","a"],["d","c"]]

        var eq5 = List.of(
                List.of("a", "b"),
                List.of("c", "d"),
                List.of("e", "f"),
                List.of("g", "h")
        );

        double[] values5 = new double[]{4.5, 2.3, 8.9,0.44};

        var queries5 = List.of(
                List.of("a", "c"),
                List.of("d", "f"),
                List.of("h", "e"),
                List.of("b", "e"),
                List.of("d", "h"),
                List.of("g", "f"),
                List.of("c", "g")
        );

        System.out.println(Arrays.toString(m.calcEquation(eq5, values5, queries5))); // [["a","c"],["b","d"],["b","a"],["d","c"]]
    }
}
