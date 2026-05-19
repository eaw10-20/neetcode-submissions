class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        Set<Character> chars = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while(right < s.length()){
            if(left < right && chars.contains(s.charAt(right))){
                char c = s.charAt(right);
                while(s.charAt(left) != c && left != right){
                    chars.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            }else{
                chars.add(s.charAt(right));
                maxLength = Math.max(maxLength, right-left+1);
                right++;
            }
        }
        return maxLength;
    }
}
