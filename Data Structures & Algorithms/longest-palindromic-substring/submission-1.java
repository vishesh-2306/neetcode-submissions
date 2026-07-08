class Solution {
    public String longestPalindrome(String s) {
        int n = s.length() ;
        String ans = "" ;
        int res = 0 ;
        int[][] dp = new int[n][n] ;

        for(int[] arr : dp){
            Arrays.fill(arr,-1) ;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if( isPalindrome(s,i,j,dp)){
                    if( j-i+1 > ans.length() ){
                        ans = s.substring(i,j+1) ;
                    }
                }
            }
        }

        return ans ;
    }

    private boolean isPalindrome(String s,int i,int j,int[][] dp){
        if( i >= j ){
            dp[i][j] = 1 ;
            return true ;
        }

        if( dp[i][j] != -1 ) return (dp[i][j] == 1) ;

        if( s.charAt(i) != s.charAt(j) ){
            dp[i][j] = 0 ;
            return false ;
        }

        dp[i][j] = isPalindrome(s,i+1,j-1,dp) ? 1 : 0 ;
        return dp[i][j] == 1 ;
    }
}
