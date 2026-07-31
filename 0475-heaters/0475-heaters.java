class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        // Step 1: Heaters ko sort kar do
        Arrays.sort(heaters);

        int ans = 0;

        // Step 2: Har house ke liye nearest heater dhoondo
        for (int house : houses) {

            // Binary Search
            int idx = Arrays.binarySearch(heaters, house);

            // Agar house ki position par heater mil gaya
            if (idx >= 0)
                continue;

            // Insertion Point nikalna
            idx = -idx - 1;

            // Right heater ki distance
            int right = (idx == heaters.length)
                    ? Integer.MAX_VALUE
                    : heaters[idx] - house;

            // Left heater ki distance
            int left = (idx == 0)
                    ? Integer.MAX_VALUE
                    : house - heaters[idx - 1];

            // Nearest heater choose karo
            ans = Math.max(ans, Math.min(left, right));
        }

        return ans;
    }
}