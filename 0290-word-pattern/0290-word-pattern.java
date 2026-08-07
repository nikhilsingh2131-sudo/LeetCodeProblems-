import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> used = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            // Character already mapped
            if (map.containsKey(ch)) {

                // Existing mapping different hai
                if (!map.get(ch).equals(word)) {
                    return false;
                }

            } else {

                // Ye word kisi aur character ko already assigned hai
                if (used.contains(word)) {
                    return false;
                }

                map.put(ch, word);
                used.add(word);
            }
        }

        return true;
    }
}