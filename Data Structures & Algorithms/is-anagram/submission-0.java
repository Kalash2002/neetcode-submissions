class Solution {
    public boolean isAnagram(String s, String t) {
         if(s.length()!=t.length()){
            return false;
         }

         int[] freq = new int[26];

         for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']+=1;
         }

         for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(freq[c-'a']==0){
                return false;
            }
            freq[c-'a']-=1;
         }
         return true;
    }
}