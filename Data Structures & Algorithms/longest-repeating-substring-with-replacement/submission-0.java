class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            int index = s.charAt(right) - 'A';
            freq[index]++;

            // Maximum frequency seen in the current window
            maxFreq = Math.max(maxFreq, freq[index]);

            // Number of characters we need to replace
            int replacements =
                    (right - left + 1) - maxFreq;

            // Shrink the window if it requires
            // more than k replacements
            if (replacements > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum valid window
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
