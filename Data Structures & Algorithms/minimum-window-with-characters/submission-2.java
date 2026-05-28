class Solution {
    //s is the large string and t is the small that contains chars to find in substring
    public String minWindow(String s, String t) {
        int size = t.length();
        int[] chars = new int[52];
        int val;

        //store t in array
        for(int i = 0; i < size; i++){
            char c = t.charAt(i);
            val = c-'A';
            if(val > 26) val -= 'a'-'Z' + 1;
            chars[val] += 1;
        }

        //sliding window to check for substring
        int used = 0;   //number of used chars
        int left = -1, right = 0;
        int[] reference = new int[52];
        int lastMoved = 0;
        int subLeft = 0, subRight = s.length()+1;
        

        while(right < s.length()){
            char c = s.charAt(lastMoved);
            val = c-'A';
            if(val > 26) val -= 'a'-'Z' + 1;
            if(lastMoved == left){
                if(reference[val] > 0 && reference[val] <= chars[val]) used--;
                reference[val]-=1;
            }
            else if(lastMoved == right){
                if(chars[val] > reference[val]) used++;
                reference[val]+=1;
            }
            if(used < size){    //loop if not all chars used
                right++;
                lastMoved = right;
            }else{
                //check for new substring here
                if(right-left < subRight-subLeft){
                    subRight = right;
                    subLeft = left;
                }
                left++;
                lastMoved = left;
            }
        }
        if(subRight == s.length()+1) return "";
        return s.substring(subLeft+1,subRight+1);
    }
}
