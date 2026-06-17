class Solution {
    public int countSubstrings(String s) {
        int pals = 0;

        //check odd length pals
        for(int i = 0; i < s.length(); i++){
            pals++;
            int radius = 1;
            while(i-radius >=0 && i+radius < s.length() && s.charAt(i-radius) == s.charAt(i+radius)){
                pals++;
                radius++;
            }
        }

        //check even length pals
        for(int i = 0; i < s.length()-1; i++){
            int radius = 1;
            while(i-radius+1 >= 0 && i+radius < s.length() && s.charAt(i-radius+1) == s.charAt(i+radius)){
                pals++;
                radius++;
            }
        }

        return pals;
    }
}
