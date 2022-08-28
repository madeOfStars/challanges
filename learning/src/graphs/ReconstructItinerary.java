/*
https://leetcode.com/problems/reconstruct-itinerary/
 */

package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReconstructItinerary {
    private boolean solved = false;
    List<String> result = new ArrayList<>();

    private record Pair(String city, int index) {
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            List<Pair> tmpQueue = map.getOrDefault(ticket.get(0), new ArrayList<>());
            tmpQueue.add(new Pair(ticket.get(1), i));
            map.put(ticket.get(0), tmpQueue);
        }
        map.forEach((s, pairs) -> pairs.sort(Comparator.comparing(o -> o.city)));

        helper(map, new LinkedList<>(), "JFK", tickets.size() + 1, new HashSet<>());

        return result;
    }

    private void helper(Map<String, List<Pair>> map, LinkedList<String> tmpList, String city, int numberOfCities, Set<String> visited) {
        if (solved)
            return;

        tmpList.add(city);

        if (tmpList.size() == numberOfCities) {
            result = new ArrayList<>(tmpList);
            solved = true;
            return;
        }

        List<Pair> queue = map.get(city);

        if (queue == null || queue.isEmpty())
            return;

        for (Pair pair : queue) {
            String nextCity = pair.city;
            String key = city + nextCity + pair.index;
            if (!visited.contains(key) && !solved) {
                visited.add(key);
                helper(map, tmpList, nextCity, numberOfCities, visited);
                tmpList.removeLast();
                visited.remove(key);
            }
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary m = new ReconstructItinerary();
        m.solved = false;

        List<String> itinerary = m.findItinerary(
                List.of(
                        List.of("MUC", "LHR"),
                        List.of("JFK", "MUC"),
                        List.of("SFO", "SJC"),
                        List.of("LHR", "SFO")
                )
        );

        System.out.println(itinerary); // ["JFK","MUC","LHR","SFO","SJC"]

        m.solved = false;
        List<String> itinerary2 = m.findItinerary(
                List.of(
                        List.of("JFK", "SFO"),
                        List.of("JFK", "ATL"),
                        List.of("SFO", "ATL"),
                        List.of("ATL", "JFK"),
                        List.of("ATL", "SFO")
                )
        );

        System.out.println(itinerary2); // ["JFK","ATL","JFK","SFO","ATL","SFO"]

        m.solved = false;
        List<String> itinerary3 = m.findItinerary(
                List.of(
                        List.of("JFK", "KUL"),
                        List.of("JFK", "NRT"),
                        List.of("NRT", "JFK")
                )
        );

        System.out.println(itinerary3); // ["JFK","NRT","JFK","KUL"]

        m.solved = false;
        List<String> itinerary4 = m.findItinerary(
                List.of(
                        List.of("EZE", "AXA"),
                        List.of("TIA", "ANU"),
                        List.of("ANU", "JFK"),
                        List.of("JFK", "ANU"),
                        List.of("ANU", "EZE"),
                        List.of("TIA", "ANU"),
                        List.of("AXA", "TIA"),
                        List.of("TIA", "JFK"),
                        List.of("ANU", "TIA"),
                        List.of("JFK", "TIA")
                )
        );

        System.out.println(itinerary4); // [JFK, ANU, EZE, AXA, TIA, ANU, JFK, TIA, ANU, TIA, JFK]
    }
}
