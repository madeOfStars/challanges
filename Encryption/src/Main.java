import static java.lang.Math.*;

public class Main {
    static String encryption(String s) {
        String trimmed = s.replaceAll("\\s+", "");
        int length = trimmed.length();

        int sqrt = (int) ceil(sqrt(length));
        StringBuilder sb = new StringBuilder();

        for (int i = 0;  i < sqrt; i++)
        {
            int j = i;
            while (j < length)
            {
                sb.append(trimmed.charAt(j));
                j += sqrt;
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "if man was meant to stay on the ground god would have given us roots";
        System.out.println(encryption(s));
    }
}
