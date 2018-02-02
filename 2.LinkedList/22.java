/**
 * Flatten a Linked List
 * 
 * Space Complexity O(m*n) Auxiliary
 * Time Complexity  O(m*n)
 */

class Node {
	int data;
	Node right;
	Node down;
	
	public Node(int n) {
		data = n;
		right = null;
		down = null;
	}
}

class LinkedList {
	static Node push(Node head, int val) {
		Node newNode = new Node(val);
		newNode.down = head;
		head = newNode;
		return head;
	}
	
	static void print(Node h) {
		while(h != null) {
			System.out.print(h.data + " ");
			h = h.down;
		}
		System.out.println();
	}
	
	static Node root=null;
	public static void main(String[] args) {
		root = push(root, 30);
		root = push(root, 8);
		root = push(root, 7);
		root = push(root, 5);
		
		root.right = push(root.right, 20);
		root.right = push(root.right, 10);
		
		root.right.right = push(root.right.right, 50);
		root.right.right = push(root.right.right, 22);
		root.right.right = push(root.right.right, 19);
		
		root.right.right.right = push(root.right.right.right, 45);
		root.right.right.right = push(root.right.right.right, 40);
		root.right.right.right = push(root.right.right.right, 35);
		root.right.right.right = push(root.right.right.right, 20);
		root = flatten(root);
		print(root);
	}
	
	static Node flatten(Node root) {
		if(root == null || root.right == null)
			return root;
		root.right = flatten(root.right);
		
		root = merge(root, root.right);
		return root;
	}
	
	static Node merge(Node a, Node b) {
		if(b == null)
			return a;
		if(a == null)
			return b;
		Node result;
		if(a.data < b.data) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(a, b.down);
		}
		return result;
	}
}
 