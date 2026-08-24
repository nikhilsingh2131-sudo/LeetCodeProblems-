class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String st : strs) {

            char[] chars = st.toCharArray();
            Arrays.sort(chars);

            String curr = new String(chars);

            if (map.containsKey(curr)) {
                map.get(curr).add(st);
            } else {
                map.put(curr, new ArrayList<>());
                map.get(curr).add(st);
            }
        }

        return new ArrayList<>(map.values());
    }
}