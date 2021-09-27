/*
https://leetcode.com/problems/unique-email-addresses/
 */
import java.util.HashSet;
import java.util.Set;

public class Main {
    public int numUniqueEmails(String[] emails) {
        if (emails.length == 1)
            return 1;

        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] tokens = email.split("@");

            StringBuilder sb = new StringBuilder();

            for (char c : tokens[0].toCharArray()) {
                if (c == '+')
                    break;

                if (c == '.')
                    continue;

                sb.append(c);
            }
            sb.append("@");
            sb.append(tokens[1]);

            set.add(sb.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {
        Main m = new Main();

        String[] arr1 = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(m.numUniqueEmails(arr1));

        String[] arr2 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(m.numUniqueEmails(arr2));

        String[] arr3 = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(m.numUniqueEmails(arr3));
    }
}
