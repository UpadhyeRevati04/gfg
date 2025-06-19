class Solution {
    public static String caseSort(String s) {
        // code here
        int n = s.length();
        char[] low = new char[n];
        char[] high = new char[n];
        int lindex=0,hindex=0;
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                low[lindex++] = ch;
            } else {
                high[hindex++] = ch;
            }
        }
        Arrays.sort(low, 0, lindex);
        Arrays.sort(high, 0, hindex);
        StringBuilder result = new StringBuilder(s);
        lindex = 0;
        hindex = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                result.setCharAt(i, low[lindex++]);
            } else {
                result.setCharAt(i, high[hindex++]);
            }
        }

        return result.toString();
    }
}