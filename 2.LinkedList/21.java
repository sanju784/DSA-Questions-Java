/**
 * Sum of number in Linked List 
 * 
 * Space Complexity O(n) - Auxillary of size longest list
 * Time Complexity  O(n) - of longest list size
 */

class Node {
	int data;
	Node next;
	
	public Node(int n) {
		data = n;
		next = null;
	}
}

class LinkedList {
	static void push(int val, int list) {
		Node newNode = new Node(val);
		if(list == 1) {
			newNode.next = head1;
			head1 = newNode;
		} else if (list == 2) {
			newNode.next = head2;
			head2 = newNode;
		} else {
			newNode.next = result;
			result = newNode;
		}
	}
	
	static void print(Node h) {
		while(h != null) {
			System.out.print(h.data + " ");
			h = h.next;
		}
		System.out.println("");
	}
	
	static Node head1=null, head2=null, result=null;
	static int carry = 0;
	public static void main(String[] args) {
		push(9, 1);
		push(9, 1);
		push(9, 1);
		push(9, 1);
		push(9, 2);
		push(9, 2);
		print(head1);
		print(head2);
		addList();
		print(result);
	}
	static Node curr;
	static void addList() {
		if(head1 == null) {
			result = head2;
			return;
		}
		if(head2 == null) {
			result = head1;
			return;
		}
		int len1 = getCount(head1);
		int len2 = getCount(head2);
		if(len1 == len2) {
			addSameSize(head1, head2);
		} else {
			if(len1 < len2) {
				Node temp;
				temp = head1;
				head1 = head2;
				head2 = temp;
			}
			int diff = Math.abs(len1-len2);
			Node temp = head1;
			while(diff >= 0) {
				curr = temp;
				temp = temp.next;
				diff--;
			}
			addSameSize(curr, head2);
			
			addRemaining(head1);
		}
		if(carry > 0)
			push(carry, 3);
	}
	
	static void addRemaining(Node a) {
		if(a != curr)
		{
			addRemaining(a.next);
			int sum = a.data + carry;
			carry = sum /10;
			push(sum%10, 3);
		}
	}
	
	static void addSameSize(Node a, Node b) {
		if(a == null)
			return;
		addSameSize(a.next, b.next);
		int sum = a.data+b.data+carry;
		carry = sum/10;
		push(sum%10, 3);
	}

	static int getCount(Node h) {
		int l = 0;
		while(h != null) {
			l++;
			h = h.next;
		}
		return l;
	}
}
 