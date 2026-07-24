class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        ArrayList<Integer>[] graph = new ArrayList[26] ;
        for(int i = 0 ; i < 26 ; i++) graph[i] = new ArrayList<>() ;

        int[] indeg = new int[26] ;
        boolean[] present = new boolean[26];
        int count = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!present[c - 'a']) {
                    present[c - 'a'] = true;
                    count++;
                }
            }
        }


        for(int i = 0 ; i < n-1 ; i++){

            String s = words[i] ;
            String t = words[i+1] ;

            int j = 0 ;

            while( j < Math.min(s.length(),t.length()) ){

                if( s.charAt(j) == t.charAt(j) ){
                    j++ ;
                    continue ;
                }

                graph[s.charAt(j) - 'a'].add(t.charAt(j) - 'a');
                indeg[t.charAt(j)-'a']++ ;
                break ;
            }

            if( j == Math.min(s.length(),t.length()) && s.length() > t.length() ) return "" ;
        }
        Queue<Integer> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if ( indeg[i] == 0 && present[i]) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int u = q.poll() ;
            ans.append((char)(u+'a')) ;

            for(int v : graph[u] ){
                indeg[v]-- ;

                if( indeg[v] == 0 && present[v]) q.offer(v) ;
            }
        }

        if( ans.length() != count ) return "" ;
        return ans.toString() ;
    }
}
