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
    public boolean canAttendMeetings(List<Interval> inter) {
        inter.sort((a, b) -> Integer.compare(a.start, b.start)) ;
        if( inter.size() == 0) return true ;

        int prevEnd = inter.get(0).end ;

        for(int i = 1 ; i < inter.size() ; i++){
            if( inter.get(i).start < prevEnd ) return false ;
            prevEnd = inter.get(i).end ;
        }

        return true ;
    }
}
