class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length ;
        if( n == 1) return n ;

        Arrays.sort(nums) ;

        int l = 0 ;
        int ops = 0 ;
        int ans = 0 ;

        for(int r = 1 ; r < n ; r++){
            ops += (nums[r]-nums[r-1])*(r-l) ;

            while( ops > k){
                ops -= nums[r]-nums[l] ;
                l++ ;
            }

            ans = Math.max(ans,r-l+1) ;
        }

        return ans ;
    }
}