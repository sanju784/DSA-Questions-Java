import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater Element
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {11, 13, 21, 3};
		System.out.println(Arrays.toString(a));
		NGE(a);
	}

	static void NGE(int a[]) {
		int n = a.length;
		Stack<Integer> s = new Stack<>();
		s.push(a[0]);
		int element, next;
		for(int i=1;i<n;i++) {
			next = a[i];
			if(s.isEmpty() == false) {
				element = s.pop();
				while(element < next) {
					System.out.println(element + " --> " + next);
					if(s.isEmpty() == true)
						break;
					element = s.pop();
				}
				if(element > next)
					s.push(element);
			}
			s.push(next);
		}
		while(s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.println(element + " --> " + next);
		}
	}
}
