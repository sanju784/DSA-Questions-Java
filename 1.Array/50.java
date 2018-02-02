import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Merge Overlapping Intervals
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		Interval a[] = {new Interval(6,8), new Interval(1,9),
				new Interval(2,4), new Interval(4,7)};
		Arrays.sort(a, new Comparator<Interval> () {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		Stack<Interval> stk = new Stack<>();
		stk.push(a[0]);
		for(int i=1;i<a.length;i++) {
			Interval top = stk.peek();
			if(top.end < a[i].start) {
				stk.push(a[i]);
			} else if (top.end < a[i].end) {
				top.end = a[i].end;
				stk.pop();
				stk.push(top);
			}
		}
		while(!stk.isEmpty()) {
			Interval t = stk.pop();
			System.out.println(t.start + ", " + t.end);
		}
	}
}

class Interval {
	int start;
	int end;
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}
