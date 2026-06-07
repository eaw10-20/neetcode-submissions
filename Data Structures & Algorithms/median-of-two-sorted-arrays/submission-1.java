class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 2 pointer
        int size = nums1.length+nums2.length;
        int half = size/2;
        int p1 = 0, p2 = 0;
        int i = 0;

        while(i < half && p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1]<nums2[p2]) p1++;
            else p2++;
            i++;
        }
        while(i<half && p1 < nums1.length){
            p1++;
            i++;
        }
        while(i<half && p2 < nums2.length){
            p2++;
            i++;
        }
        if(size%2==1){
            if(nums1.length == 0) return (double) nums2[p2];
            if(nums2.length == 0) return (double) nums1[p1];
            return (double) Math.min(nums1[p1],nums2[p2]);
        } 
        int m1,m2;
        if(p1 == 0) m1 = nums2[p2-1];
        else if(p2 == 0) m1 = nums1[p1-1];
        else m1 = Math.max(nums1[p1-1],nums2[p2-1]);

        if(p1 == nums1.length) m2 = nums2[p2];
        else if(p2 == nums2.length) m2 = nums1[p1];
        else m2 = Math.min(nums1[p1],nums2[p2]);

        return (m1+m2)/2.0;
    }
}