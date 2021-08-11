/*
https://leetcode.com/problems/array-of-doubled-pairs/
 */
import java.util.*;

public class Main {
    public boolean canReorderDoubled(int[] arr) {
        if (arr.length == 0)
            return true;

        Map<Integer, Integer> map = new TreeMap<>();

        for (int el : arr) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        for (int el : map.keySet()) {
            int missing = el > 0 ? el * 2 : el / 2;
            Integer freq = map.get(el);

            if (freq == 0)
                continue;

            if ((el < 0 && el % 2 != 0) || map.getOrDefault(missing, 0) < freq)
                return false;

            map.put(missing, map.get(missing) - freq);
        }

        return true;
    }

    public boolean canReorderDoubled2(int[] arr) {
        if (arr.length == 0)
            return true;

        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();

        for (int el : arr) {
            if (el < 0)
                negList.add(el);
            else
                posList.add(el);
        }

        if (posList.size() == 1)
            return false;

        if (negList.size() == 1)
            return false;

        posList.sort(Comparator.naturalOrder());
        negList.sort(Comparator.reverseOrder());

        for (int i = 0; i < posList.size() - 1; i++) {
            int el = posList.get(i);

            int searchIndex = Collections.binarySearch(posList, el * 2);

            if (searchIndex < 0) {
                return false;
            }

            posList.remove(searchIndex);
        }

        for (int i = 0; i < negList.size() - 1; i++) {
            int el = negList.get(i);

            int searchIndex = Collections.binarySearch(negList, el * 2, Comparator.reverseOrder());

            if (searchIndex < 0)
                return false;

            negList.remove(searchIndex);
        }

        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr1 = {3, 1, 3, 6};
        System.out.println(m.canReorderDoubled(arr1));

        int[] arr2 = {2, 1, 2, 6};
        System.out.println(m.canReorderDoubled(arr2));

        int[] arr3 = {4, -2, 2, -4};
        System.out.println(m.canReorderDoubled(arr3));

        int[] arr4 = {1, 2, 4, 16, 8, 4};
        System.out.println(m.canReorderDoubled(arr4));

        int[] arr5 = {-1, 2};
        System.out.println(m.canReorderDoubled(arr5));

        int[] arr6 = {1, 2, 4, 8};
        System.out.println(m.canReorderDoubled(arr6));

        int[] arr7 = {2, 1, 2, 1, 1, 1, 2, 2};
        System.out.println(m.canReorderDoubled(arr7));
    }
}
