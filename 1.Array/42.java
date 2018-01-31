import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Sliding Window Maximum
 * 
 * Deque -
 * Space Complexity O(k)
 * Time Complexity  O(n)
 * 
 * Stack - 
 * Space Complexity O(n+k)
 * Time Complexity  O((n-k)*k)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {12, 1, 78, 90, 57, 89, 56};
		System.out.println(Arrays.toString(a));
		int k = 3;
		maxSub(a, k);
		maxSub2(a, k);
	}

	//Using Dequeue
	static void  maxSub(int a[], int k) {
		int n = a.length;
		Deque<Integer> dq = new LinkedList<>();
		int i;
		for(i=0;i<k;i++) {
			while(!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		
		for(;i<n;i++) {
			System.out.print(a[dq.peek()] + " ");
			while(!dq.isEmpty() && dq.peek() <= i-k) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.print(a[dq.peek()] + "\n");
	}
	
	//Using 2 Stack (Easy to remember)
	/**
	 * if we push the elements of array in reverse order in stack1 and pop 
	 * top k no of elements and push them into another stack while maintaining 
	 * maximum of those k and printing max.Then we can pop back top k-1 elements 
	 * from stack2 to stack1 and repeat the process until stack1 has greater than 
	 * or equal to k elements
	 */
	static void maxSub2(int a[], int k) {
		int n = a.length;
		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			stk1.push(a[i]);
		}
		while(!stk1.isEmpty() && stk1.size() >= k) {
			int max = Integer.MIN_VALUE;
			for(int i=0;i<k;i++) {
				int element = stk1.pop();
				if(element > max)
					max = element;
				stk2.push(element);
			}
			System.out.print(max + " ");
			for(int i=0;i<k-1;i++) {
				stk1.push(stk2.pop());
			}
			stk2.removeAllElements();
		}
	}
}
