class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s, String t) {

        // Your code here
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(char c: s.toCharArray()) {count[c-'a']++;}
        for(char c: t.toCharArray()){
            if(--count[c-'a'] < 0)return false;
        }
        return true;
    }
}