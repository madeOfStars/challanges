/*
https://leetcode.com/problems/find-median-from-data-stream/
 */

package amz;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private final PriorityQueue<Integer> minQueue;
    private final PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxQueue.isEmpty() || maxQueue.peek() >= num) {
            maxQueue.add(num);
        } else {
            minQueue.add(num);
        }

        if (maxQueue.size() > minQueue.size() + 1) {
            minQueue.add(maxQueue.poll());
        }

        if (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        } else if (minQueue.size() < maxQueue.size()) {
            return maxQueue.peek();
        } else {
            var min = minQueue.isEmpty() ? 0 : minQueue.peek();
            var max = maxQueue.isEmpty() ? 0 : maxQueue.peek();
            return (min * 1.0 + max) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian()); // return 2.0

        medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian()); // -1
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian()); // -1.5
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian()); // -2
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian()); // -2.5
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian()); // -3
    }
}
