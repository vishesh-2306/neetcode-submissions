class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> tails = new ArrayList<>() ;

        for(int n : nums){
            int l = 0 , r = tails.size() ;

            while( l < r){
                int mid = (l+r)/2 ;

                if( tails.get(mid) < n){
                    l = mid+1 ;
                } else{
                    r = mid ;
                }
            }

            if( l == tails.size() ) tails.add(n) ;
            else tails.set(l,n) ;
        }

        return tails.size() ;
    }
}
