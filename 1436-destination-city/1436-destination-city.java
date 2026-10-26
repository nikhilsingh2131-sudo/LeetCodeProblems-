class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();

        for(List<String> path : paths){
            set.add(path.get(0));

        }

        for(List<String> path :paths){
            String key = path.get(1);

            if(!set.contains(key)){
                return key;
            }
        }
        return "";
    }
}