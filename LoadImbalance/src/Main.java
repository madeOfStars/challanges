import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public int load(List<Integer> weight) {
        if (weight.size() == 1)
            return 0;

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int sum = 0;

        for (int i = 0; i < weight.size(); i++) {
            int currWeight = weight.get(i);
            maxQueue.add(currWeight);
            minQueue.add(currWeight);

            PriorityQueue<Integer> maxQueue1 = new PriorityQueue<>(maxQueue);
            PriorityQueue<Integer> minQueue1 = new PriorityQueue<>(minQueue);

            for (int j = i + 1; j < weight.size(); j++) {
                int tmpWeight = weight.get(j);
                sum += maxQueue1.poll() - minQueue1.poll();

                maxQueue1.add(tmpWeight);
                minQueue1.add(tmpWeight);
            }

            sum += maxQueue1.poll() - minQueue1.poll();
        }

        //sum += maxQueue.poll() - minQueue.poll();

        return sum;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.load(List.of(3, 2, 3)));
        //System.out.println(m.load(List.of(1, 2, 3)));
    }
}
