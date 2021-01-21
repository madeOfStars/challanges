/*
https://leetcode.com/problems/keys-and-rooms/
 */
package queue_and_stack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> roomsToVisit = IntStream.rangeClosed(0, rooms.size() - 1).boxed()
                .collect(Collectors.toSet());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        roomsToVisit.remove(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer room = queue.poll();
                List<Integer> keys = rooms.get(room);

                for (Integer key : keys) {
                    if (roomsToVisit.contains(key)) {
                        roomsToVisit.remove(key);
                        queue.add(key);
                    }
                }
            }
        }
        return roomsToVisit.isEmpty();
    }

    public static void main(String[] args) {
        KeysAndRooms kr = new KeysAndRooms();

        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Collections.singletonList(1));
        rooms1.add(Collections.singletonList(2));
        rooms1.add(Collections.singletonList(3));
        rooms1.add(Collections.emptyList());

        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));
        rooms2.add(Arrays.asList(3, 0, 1));
        rooms2.add(Collections.singletonList(2));
        rooms2.add(Collections.singletonList(0));


        System.out.println(kr.canVisitAllRooms(rooms1));
        System.out.println(kr.canVisitAllRooms(rooms2));
    }
}
