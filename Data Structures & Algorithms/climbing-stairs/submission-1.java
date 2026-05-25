class Solution {
    public int climbStairs(int n) {
        List<Integer> stairs = new ArrayList<>();
        stairs.add(0,0);
        stairs.add(1,1);
        stairs.add(2,2);
        for(int i = 3; i <= n; i++){
            stairs.add(i,stairs.get(i-1)+stairs.get(i-2));
        }
        return stairs.get(n);
    }
}

//