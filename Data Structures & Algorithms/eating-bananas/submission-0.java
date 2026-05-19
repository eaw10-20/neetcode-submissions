class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 1, mid;

        for(int pile: piles){
            max = Math.max(pile, max);
        }

        while(max > min){
            mid = (min + max)/2;
            boolean valid = validRate(mid,h,piles);
            if(valid){
                max = mid;
                if(max-min == 1){
                    if(validRate(min,h,piles)) return min;
                    return max;
                }
            }else{
                min = mid+1;
            }
        }
        
        return max;
    }

    boolean validRate(int rate, int hours, int[] piles){
        int count = 0;
        for(int pile:piles){
            count += pile/rate;
            if(pile%rate != 0) count++;
            if(count > hours) return false;
        }

        return true;
    }
}
