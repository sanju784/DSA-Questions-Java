/**
	Middle node of Linked List
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
		int res = ll.getMid(ll.head);
		System.out.println("Mid of Linked List is " + res);
	}

	public int getMid(Node h) {
		Node slow = h;
		Node fast = h;
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
}