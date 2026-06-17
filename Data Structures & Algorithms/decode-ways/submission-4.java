class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];

        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        if(len == 1) return 1;

        for(int i = 1; i < len; i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(curr == '0'){
                if(prev != '1' && prev != '2') return 0;
                dp[i] = dp[i-1];
            }
            else if(prev == '1' || prev == '2' && curr < '7'){
                if(i == len-1 || s.charAt(i+1) != '0'){
                    if(i-2 >= 0) dp[i] = dp[i-1] + dp[i-2];
                    else dp[i] = dp[i-1] + 1;
                } 
                else dp[i] = dp[i-1];
            }
            else dp[i] = dp[i-1];
        }
        return dp[len-1];
    }
}
