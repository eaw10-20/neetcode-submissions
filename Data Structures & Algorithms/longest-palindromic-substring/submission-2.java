class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        int start = 0, length = 1;
        //checking for palindrome of odd number length
        for(int i = 0; i < s.length(); i++){
            int radius = 1;
            while(i-radius >=0 && i+radius < s.length() && s.charAt(i-radius) == s.charAt(i+radius)){
                if(radius*2+1 > length){
                    length = radius*2+1;
                    start = i-radius;
                }
                radius++;
            }
        }
        //checking for palindrome of even number length
        for(int i = 0; i < s.length()-1; i++){
            int radius = 1;
            while(i-radius+1 >=0 && i+radius < s.length() && s.charAt(i-radius+1) == s.charAt(i+radius)){
                if(radius*2 > length){
                    length = radius*2;
                    start = i-radius+1;
                }
                radius++;
            }
        }
        return s.substring(start,start+length);
    }
}
