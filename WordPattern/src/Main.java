import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public boolean wordPattern(String pattern, String s) {
        int size = pattern.length();
        String[] words = s.split(" ");

        if (size != words.length)
            return false;

        String[] charToString = new String[26];
        Arrays.fill(charToString, "");

        Map<String, Character> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            char currChar = pattern.charAt(i);

            if (!charToString[currChar - 'a'].equals("") && !charToString[currChar - 'a'].equals(words[i]))
                return false;

            if (map.containsKey(words[i]) && !map.get(words[i]).equals(currChar))
                return false;

            charToString[currChar - 'a'] = words[i];
            map.put(words[i], currChar);
        }

        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.wordPattern("abba", "dog cat cat dog"));
        System.out.println(m.wordPattern("abba", "dog cat cat fish"));
        System.out.println(m.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(m.wordPattern("abba", "dog dog dog dog"));
        System.out.println(m.wordPattern("aaa", "aa aa aa aa"));
    }
}
