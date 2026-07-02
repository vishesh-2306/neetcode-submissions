class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        Queue<int[]> q = new LinkedList<>(); 
        int fresh = 0 ; 

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if( grid[i][j] == 2 ){
                    q.add(new int[]{i,j}) ;
                } else if( grid[i][j] == 1){
                    fresh++ ;
                }
            }
        }

        if( fresh == 0 ) return 0 ;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int minutes = 0 ; 

        while( !q.isEmpty() && fresh > 0 ){
            int size = q.size() ;

            
            for(int k = 0 ; k < size ; k++){
                int[] curr = q.remove() ;

                for(int[] d : dir){
                    int nr = curr[0] + d[0] ;
                    int nc = curr[1] + d[1] ;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2 ;
                        fresh-- ;
                        q.add(new int[]{nr,nc}) ;
                    }
                } 
            }
            
            minutes++ ;
        }

        return (fresh == 0 ) ? minutes : -1 ;
    }
}
