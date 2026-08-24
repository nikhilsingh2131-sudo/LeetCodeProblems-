class Solution {
    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {

        Arrays.sort(products);

        List<List<String>> ans = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {

            String prefix = searchWord.substring(0, i);

            int index = lowerBound(products, prefix);

            List<String> list = new ArrayList<>();

            for (int j = index; j < products.length && list.size() < 3; j++) {

                if (products[j].startsWith(prefix)) {
                    list.add(products[j]);
                } else {
                    break;
                }
            }

            ans.add(list);
        }

        return ans;
    }

    private int lowerBound(String[] products, String target) {

        int left = 0;
        int right = products.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (products[mid].compareTo(target) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}