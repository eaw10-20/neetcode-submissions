class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;

        int twoBack;
        int oneBack = cost[0];
        int step = cost[1];

        if(len == 2) return Math.min(oneBack, step);

        for(int i = 2; i < len; i++){
            twoBack = oneBack;
            oneBack = step;
            step = cost[i] + Math.min(oneBack,twoBack);
        }

        return Math.min(oneBack,step);
    }
}
