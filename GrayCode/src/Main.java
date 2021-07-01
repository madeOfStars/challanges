/*
https://leetcode.com/problems/gray-code/
 */
import java.util.*;

public class Main {
    public List<Integer> grayCode(int n) {
        if (n == 0)
            return List.of(0);

        List<Integer> buffer = new ArrayList<>();
        buffer.add(0);
        Set<String> visited = new HashSet<>();
        visited.add(intToBinaryString(0, n));

        return getList(n, 0, buffer, visited);
    }

    private List<Integer> getList(int n, int i, List<Integer> buffer, Set<String> visited) {
        String binary = intToBinaryString(buffer.get(i), n);

        for (int j = 0; j < binary.length(); j++) {
            StringBuilder sb = new StringBuilder(binary);
            sb.setCharAt(j, sb.charAt(j) == '0' ? '1' : '0');
            String newString = sb.toString();

            if (buffer.size() == Math.pow(2, n)) {
                return new ArrayList<>(buffer);
            }

            if (!visited.contains(newString)) {
                buffer.add(Integer.parseInt(newString, 2));
                visited.add(newString);

                List<Integer> list = getList(n, i + 1, buffer, visited);

                visited.remove(newString);
                buffer.remove(buffer.size() - 1);

                return list;
            }

        }

        return List.of();
    }

    private String intToBinaryString(int value, int leadingZero) {
        String binary = Integer.toBinaryString(value);
        return String.format("%" + leadingZero + "s", binary).replace(' ', '0');
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.grayCode(4));
    }
}
