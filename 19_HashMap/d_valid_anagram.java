import java.util.HashMap;

public class d_valid_anagram {
    public static void main(String[] args) {
        String s = "knee";
        String r = "keen";
        if (s.length() != r.length()) {
            System.out.println("Not anagrams");
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < r.length(); i++) {
            char ch = r.charAt(i);
            if (!map.containsKey(ch)) {
                System.out.println("Not arguments");
                return;
            } else {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        if (map.isEmpty()) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }

    }
}
