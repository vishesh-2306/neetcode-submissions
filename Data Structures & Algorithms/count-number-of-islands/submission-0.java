class Solution {
    private void dfs(char[][] grid,int i , int j , boolean[][] vist){
        int m = grid.length ;
        int n = grid[0].length ;
        if( i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || vist[i][j] ) return ;

        vist[i][j] = true ;

        dfs(grid,i-1,j,vist) ;
        dfs(grid,i+1,j,vist) ;
        dfs(grid,i,j-1,vist) ;
        dfs(grid,i,j+1,vist) ;

        return ;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        boolean[][] vist = new boolean[m][n] ;
        int count = 0 ;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if( grid[i][j] == '1' && !vist[i][j] ){
                    dfs(grid,i,j,vist) ;
                    count++ ;
                } 
            }
        }

        return count ;
    }
}
