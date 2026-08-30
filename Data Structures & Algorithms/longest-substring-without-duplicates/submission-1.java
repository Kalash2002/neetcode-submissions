class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0;
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {

            // If duplicate exists, shrink window
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            // Add current character
            set.add(s.charAt(j));

            // Current window = [i ... j]
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}



//  Map<Character, Integer> map = new HashMap<>();

//         int i = 0;
//         int ans = 0;

//         for (int j = 0; j < s.length(); j++) {

//             char current = s.charAt(j);

//             // If character was seen before,
//             // move left pointer after its previous occurrence
//             if (map.containsKey(current)) {
//                 i = Math.max(i, map.get(current) + 1);
//             }

//             // Store/update last occurrence
//             map.put(current, j);

//             // Current window = [i ... j]
//             ans = Math.max(ans, j - i + 1);
//         }

//         return ans;
