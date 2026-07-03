class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n] ;
        
        for(int i = 0; i < n ; i++){
            graph[i] = new ArrayList<>() ;
        }

        for(int[] edge:times){
            int u = edge[0]-1 ;
            int v = edge[1]-1 ;
            int w = edge[2] ;

            graph[u].add(new int[]{v,w}) ;
        }
        boolean vist[] = new boolean[n] ;
        int[] dist = new int[n] ;
        Arrays.fill(dist,Integer.MAX_VALUE) ;
        dist[k-1] = 0 ;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0])) ;
        pq.add(new int[]{0,k-1}) ;



        while( !pq.isEmpty() ){
            int curr[] = pq.poll() ;
            if (vist[curr[1]]) continue;
            vist[curr[1]] = true ;

            for(int i = 0 ; i < graph[curr[1]].size() ; i++){
                int[] next = graph[curr[1]].get(i) ;
                int v = next[0] ;
                int wt = next[1] ;
                if( dist[curr[1]] + wt < dist[v] ){
                    dist[v] = dist[curr[1]] + wt ;
                    pq.add(new int[]{dist[curr[1]]+wt,next[0]}) ;

                }
            }
        }
        int res = 0 ;
        for(int i = 0 ; i < n ; i++){
            res = Math.max(res,dist[i]) ;
        }

        return (res == Integer.MAX_VALUE ) ? -1 : res ;
    }
}
