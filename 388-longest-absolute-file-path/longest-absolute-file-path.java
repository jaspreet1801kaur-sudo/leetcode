class Solution {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] stack = new int[parts.length + 1];
        int maxLen = 0;

        for (String part : parts) {
            int level = part.lastIndexOf("\t") + 1;
            int len = part.length() - level;

            if (level == 0) {
                stack[level] = len;
            } else {
                stack[level] = stack[level - 1] + len + 1;
            }

            if (part.contains(".")) {
                maxLen = Math.max(maxLen, stack[level]);
            }
        }

        return maxLen;
    }
}
        
    