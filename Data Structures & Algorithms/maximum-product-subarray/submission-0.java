class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length ;

        int currMin = 1 , currMax = 1 ;
        int res = nums[0] ;
        
        for(int i = 0 ; i < n ; i++){
            

            int temp = currMax ;
            currMax = Math.max(nums[i],Math.max(nums[i]*currMax,nums[i]*currMin)) ;
            currMin = Math.min(nums[i],Math.min(nums[i]*temp,nums[i]*currMin)) ;

            res = Math.max(currMax,res) ;
        }

        return res ;
    }
}
