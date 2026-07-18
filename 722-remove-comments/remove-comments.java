class Solution {
    public List<String> removeComments(String[] source) {
       
        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        boolean inBlock = false;

        for (String s : source) {
            int i = 0;

            if (!inBlock) {
                line.setLength(0);
            }

            while (i < s.length()) {
                if (!inBlock && i + 1 < s.length()
                        && s.charAt(i) == '/'
                        && s.charAt(i + 1) == '*') {
                    inBlock = true;
                    i += 2;
                } else if (inBlock && i + 1 < s.length()
                        && s.charAt(i) == '*'
                        && s.charAt(i + 1) == '/') {
                    inBlock = false;
                    i += 2;
                } else if (!inBlock && i + 1 < s.length()
                        && s.charAt(i) == '/'
                        && s.charAt(i + 1) == '/') {
                    break;
                } else if (!inBlock) {
                    line.append(s.charAt(i));
                    i++;
                } else {
                    i++;
                }
            }

            if (!inBlock && line.length() > 0) {
                result.add(line.toString());
            }
        }

        return result;
           
    }
}