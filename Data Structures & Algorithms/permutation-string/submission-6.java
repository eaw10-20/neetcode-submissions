class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> chars = new HashMap<>();

        if(s1.length() > s2.length()) return false;

        int length = s1.length();
        for(int i = 0; i < s1.length(); i++){
            char curr = s1.charAt(i);
            if(chars.containsKey(curr)) chars.put(curr,chars.get(curr)+1);
            else chars.put(curr,1);
        }

        for(int i = 0; i < s1.length(); i++){
            char curr = s2.charAt(i);
            if(chars.containsKey(curr)) chars.put(curr,chars.get(curr)-1);
        }

        boolean ret = true;
        for(char c: chars.keySet()){
            if(chars.get(c) != 0){
                ret = false;
                break;
            }
        }
        if(ret) return true;

        for(int i = s1.length(); i < s2.length(); i++){
            char curr = s2.charAt(i);
            if(chars.containsKey(s2.charAt(i-length))) chars.put(s2.charAt(i-length),chars.get(s2.charAt(i-length))+1);
            if(chars.containsKey(s2.charAt(i))){
                chars.put(curr,chars.get(curr)-1);
                for(char c: chars.keySet()){
                    ret = true;
                    if(chars.get(c) != 0){
                        ret = false;
                        break;
                    }
                }
                if(ret) return true;
            }
        }
        return false;
    }
}
