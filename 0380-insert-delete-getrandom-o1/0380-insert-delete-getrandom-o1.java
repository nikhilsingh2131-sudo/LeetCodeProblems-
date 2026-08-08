class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        // Already present
        if (map.containsKey(val)) {
            return false;
        }

        // Add value
        list.add(val);

        // Store value -> index
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        // Value doesn't exist
        if (!map.containsKey(val)) {
            return false;
        }

        // Index of value to remove
        int index = map.get(val);

        // Last element
        int lastValue = list.get(list.size() - 1);

        // Put last element at the removed element's position
        list.set(index, lastValue);

        // Update last element's index
        map.put(lastValue, index);

        // Remove last element
        list.remove(list.size() - 1);

        // Remove value from map
        map.remove(val);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(list.size());

        return list.get(index);
    }
}