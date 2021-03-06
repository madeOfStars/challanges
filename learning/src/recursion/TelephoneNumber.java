package recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TelephoneNumber {
    private static final int PHONE_NUMBER_LENGTH = 7;
    private final int[] phoneNum;
    private final char[] result = new char[PHONE_NUMBER_LENGTH];

    private final Map<Integer, List<Character>> CHARS = Map.of(
            2, List.of('A', 'B', 'C'),
            3, List.of('D', 'E', 'F'),
            4, List.of('G', 'H', 'I'),
            5, List.of('J', 'K', 'L'),
            6, List.of('M', 'N', 'O'),
            7, List.of('P', 'R', 'S'),
            8, List.of('T', 'U', 'V'),
            9, List.of('W', 'X', 'Y')
    );

    public TelephoneNumber(int[] phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void printWords() {
        printWords(0);
    }

    private void printWords(int curDigit) {
        if (curDigit == PHONE_NUMBER_LENGTH) {
            System.out.println(new String(result));
            return;
        }

        for (int i = 0; i < 3; i++) {
            result[curDigit] = getCharKey(phoneNum[curDigit], i);
            printWords(curDigit + 1);
            if (phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
                return;
        }
    }

    public void printWordsBFS() {
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            queue.add(getCharKey(phoneNum[i], 0) + "");
        }

        int count = 0;

        while (!queue.isEmpty()) {
            String polledValue = queue.poll();

            if (polledValue.length() == PHONE_NUMBER_LENGTH) {
                count++;
                System.out.println(polledValue);
                continue;
            }

            for (int digit : phoneNum) {
                for (int i = 0; i < 3; i++) {
                    queue.add(polledValue + getCharKey(digit, i));
                }
            }
        }

        System.out.println(count);
    }

    private char getCharKey(int telephoneKey, int place) {
        return CHARS.get(telephoneKey).get(place);
    }

    public static void main(String[] args) {
        TelephoneNumber tn = new TelephoneNumber(new int[]{8, 6, 6, 2, 6, 6, 5});

        tn.printWords();
        tn.printWordsBFS();
    }
}
