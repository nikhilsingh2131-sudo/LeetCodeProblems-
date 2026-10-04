class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans  = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] arr = s.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }

        for(List<String>temp: map.values()){
            ans.add(temp);
        }
        return ans ;
    }
}