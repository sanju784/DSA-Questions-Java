/**
	Nth node from end of Linked List
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
	Node head = null;
	
	public void insertAtFirst(int n) {
		Node newNode = new Node(n);
		newNode.next = head;
		head = newNode;
	}
	
	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		ll.insertAtFirst(5);
		ll.insertAtFirst(4);
		ll.insertAtFirst(3);
		ll.insertAtFirst(2);
		ll.insertAtFirst(1);
		ll.print();
		int n = 4;
		int res = ll.getNthFromEnd(ll.head, n);
		System.out.println(n + " node from end of Linked List is " + res);
	}

	public int getNthFromEnd(Node h, int n) {
		Node last = h;
		Node nth = h;
		int c = 0;
		
		while (c < n) {
			c++;
			last = last.next;
		}
		
		while(last != null)
		{
			nth = nth.next;
			last = last.next;
		}
		return nth.data;
	}
}