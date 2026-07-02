class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int INF = Integer.MAX_VALUE ;

        Queue<int[]> q = new LinkedList<>() ;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if( grid[i][j] == 0) q.add(new int[]{i,j,0}) ;
            }
        }

        int[] dx = {1,-1,0,0} ;
        int[] dy = {0,0,-1,1} ;

        while( !q.isEmpty() ){

            int[] curr = q.poll() ;
            for(int i = 0 ; i < 4 ; i++){
                int nx = curr[0]+dx[i] ;
                int ny = curr[1]+dy[i] ;
                int dist = curr[2]+1 ;

                if( nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == -1 || grid[nx][ny] == 0 ) continue ;
                else if( grid[nx][ny] == INF){
                    grid[nx][ny] = dist ;
                    q.add(new int[]{nx,ny,dist}) ;
                }
                else continue ;
            }


        }

    }
}
