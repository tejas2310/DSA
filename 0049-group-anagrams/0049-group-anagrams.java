class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // Step 1: frequency count
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            // Step 2: build canonical key
            StringBuilder key = new StringBuilder();
            for (int count : freq) {
                key.append('#').append(count);
            }

            // Step 3: group by key
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(s);
        }

        return new ArrayList<>(map.values());
    }
}
