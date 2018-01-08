/**
	Search in Linked List - Recursive
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
		int n = 5;
		if(ll.searchRec(ll.head, n))
			System.out.println(n + " is in Linked List");
		else
			System.out.println(n + " is not in Linked List");
	}

	public boolean searchRec(Node head, int n) {
		if (head == null)
			return false;
		if (head.data == n)
			return true;
		return searchRec(head.next, n);
	}
}