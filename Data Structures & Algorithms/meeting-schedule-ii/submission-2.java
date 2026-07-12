/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> inter) {
        if( inter.size() == 0 ) return 0 ;
        inter.sort((a,b) -> Integer.compare(a.start,b.start)) ;

        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        int cnt = 1 ;
        pq.add(inter.get(0).end) ;

        for(int i = 1 ; i < inter.size() ; i++){

            if( pq.peek() > inter.get(i).start ){
                pq.add(inter.get(i).end ) ;
                cnt++ ;
            } else{
                pq.poll() ;
                pq.add(inter.get(i).end) ;
            }

        }
        return cnt ;
    }
}
