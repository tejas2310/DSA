class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0, result = 0;

        for (int end = 0; end < fruits.length; end++) {
            freq.merge(fruits[end], 1, Integer::sum);

            while (freq.size() > 2) {
                freq.merge(fruits[start], -1, Integer::sum);
                if (freq.get(fruits[start]) == 0) {
                    freq.remove(fruits[start]);
                }
                start++;
            }

            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
