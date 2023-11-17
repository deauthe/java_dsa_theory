public class ok {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int charBool[] = new int[26];
            int l = 0;
            int r = 1;
            int maxLength = 1;
            charBool[(int) s.charAt(0) - 97] = 1;
            while (r < s.length()) {
                int rightIntVal = (int) s.charAt(r) - 97;
                int leftIntVal = (int) s.charAt(l) - 97;
                String currStr = s.substring(l, r);

                if (charBool[rightIntVal] == 1) {
                    charBool[leftIntVal] = 0;
                    l++;
                    r++;
                } else {
                    r++;
                    maxLength = Math.max(maxLength, currStr.length());
                    if (charBool[rightIntVal] == 1 && maxLength == currStr.length()) {
                        maxLength -= 1;
                    }

                }

            }
            return maxLength;
        }
    }
}
