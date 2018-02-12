import java.util.*;

/**
 * Merge Overlapping Intervals
 * 
 * Time  Complexity - O(nLogn)
 * Space Complexity - O(n)
 */
class stack {
       
        public static void main(String[] args) {
            Interval inter[] = {new Interval(1,3),new Interval(2,4),new Interval(6,8),new Interval(5,7)};
            Arrays.sort(inter, new Comparator<Interval>() {
               public int compare(Interval a, Interval b) {
                   return a.start - b.start;
               } 
            });
            Stack<Interval> s = new Stack<>();
            s.push(inter[0]);
            for(int i=1;i<inter.length;i++) {
                Interval top = s.peek();
                if(top.end < inter[i].start) {
                    s.push(inter[i]);
                } else if(top.end < inter[i].end){
                    top.end = inter[i].end;
                    s.pop();
                    s.push(top);
                }
            }
            while(!s.empty()) {
                Interval i = s.pop();
                System.out.println(i.start + " " + i.end);
            }
        }
}

class Interval{
    int start;
    int end;
    public Interval(int a, int b) {
        start = a;
        end = b;
    }
}