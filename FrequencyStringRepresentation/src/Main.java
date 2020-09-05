import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 2, 5, 7, 7);
        List<String> results = new ArrayList<>();

        int freq = 1;
        int currNumber;

        for (int i = 0; i < numbers.size() - 1; i++) {
            currNumber = numbers.get(i);
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                freq++;
            } else {
                if (freq > 1) {
                    results.add(currNumber + ":" + freq);
                } else {
                    results.add(currNumber + "");
                }
                freq = 1;
            }
        }

        int lastNumber = numbers.get(numbers.size() - 1);

        if (freq > 1) {
            results.add(lastNumber + ":" + freq);
        } else {
            results.add(lastNumber + "");
        }

        results.forEach(System.out::println);
    }
}
