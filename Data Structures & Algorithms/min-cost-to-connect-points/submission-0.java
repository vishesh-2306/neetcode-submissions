class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ;
        boolean[] vist = new boolean[n] ;
        int[] dist = new int[n] ;
        Arrays.fill(dist,Integer.MAX_VALUE) ;
        dist[0] = 0 ;

        int ans = 0 ;
        

        for(int i = 0 ; i < n ; i++){
            
            int u = -1 ;
            for(int j = 0 ; j < n ; j++){
                if( !vist[j] && ( u == -1 || dist[j] < dist[u] )){
                    u = j ;
                }
            }

            vist[u] = true ;
            ans+= dist[u] ;

            for(int j = 0 ; j < n ; j++){
                int x = Math.abs(points[u][0]-points[j][0]) ;
                int y = Math.abs(points[u][1]-points[j][1]) ;
                dist[j] = Math.min(dist[j],x+y) ;
            }
        }

        return ans ;
    }
}
