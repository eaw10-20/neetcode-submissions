class Solution {
    public int characterReplacement(String s, int k) {

        if(s.length()<= k+1) return s.length();

        int left = 0; int right = k;
        int maxSize = k+1;
        int mostFrequent = 1;
        int charCount;
        Map<Character, Integer> numChars = new HashMap<>();

        for(int i = 0; i <= k; i++){
            if(numChars.containsKey(s.charAt(i))){
                charCount = numChars.get(s.charAt(i))+1;
                mostFrequent = Math.max(mostFrequent, charCount);
                numChars.put(s.charAt(i),charCount);
            }else numChars.put(s.charAt(i),1);
        }

        while(right < s.length()-1){
            right++;
            if(numChars.containsKey(s.charAt(right))){
                charCount = numChars.get(s.charAt(right))+1;
                numChars.put(s.charAt(right),charCount);
                mostFrequent = Math.max(mostFrequent, charCount);
                maxSize = k + mostFrequent;
            }else numChars.put(s.charAt(right),1);

            if(right-left+1 > maxSize){
                numChars.put(s.charAt(left), numChars.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return Math.min(maxSize, s.length());
    }
}
