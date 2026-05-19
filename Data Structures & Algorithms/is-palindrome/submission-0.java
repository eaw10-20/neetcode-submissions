class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        String sLower = s.toLowerCase();
        
        while(end > start){
            if(Character.isLetterOrDigit(sLower.charAt(start)) && Character.isLetterOrDigit(sLower.charAt(end))){
                if(sLower.charAt(start) != sLower.charAt(end)) return false;
                start++;
                end--;
            }else{
                if(!Character.isLetterOrDigit(sLower.charAt(start))) start++;
                if(!Character.isLetterOrDigit(sLower.charAt(end))) end--;
            }
        }
        return true;
    }
}
