class Solution {
    private int find(int x,int[] par){
        if( par[x] == x ) return x ;
        return par[x] = find(par[x],par) ;
    }

    private boolean union(int x,int y,int[] par,int[] rank){
        int px = find(x,par) ;
        int py = find(y,par) ;

        if( px == py ) return false ;
    
        if( rank[px] < rank[py] ){
            par[px] = py ;
        } else if( rank[px] > rank[py] ){
            par[py] = px ;
        }else{
            par[px] = py ;
            rank[py]++ ; ;
        }
        return true ;
    
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length ;
        int[] par = new int[n] ;
        int[] rank = new int[n] ;
        int[] ans = new int[2] ;

        for(int i = 0 ; i < n ; i++){
            par[i] = i ;
        }

        for(int[] edge:edges){
            int u = edge[0] ;
            int v = edge[1] ;
            if(!union(u-1,v-1,par,rank)) ans = new int[]{u,v} ;
        }

        return ans ;
    }
}
