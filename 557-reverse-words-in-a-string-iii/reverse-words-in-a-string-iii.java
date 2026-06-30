class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String ans = "";
        for(int i=0; i<words.length; i++){
            String rev = "";
            for(int j = words[i].length() -1; j>=0; j--){
                rev += words[i].charAt(j);
            }
            ans += rev;
            if(i!= words.length -1){
                ans+= " ";
            }
        }
        return ans;
        
    }
}