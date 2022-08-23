package in.tamilarasu.java.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import in.tamilarasu.java.problem.BinaryTreeInorder.Node;

public class BinarySearchTree {
	
	Node root;
	
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			super();
			this.data = data;
		}		
	}
	public void add(int data) {
		Node node = new Node(data);
		if(root == null) {
			root = node;
		}else {
			Node tmp = root;
			while(true) {
				if(data > tmp.data) {
					if(tmp.right !=null) {
						tmp = tmp.right;
					}else {
						tmp.right = node;
						break;
					}
				}
				else{
					if(tmp.left !=null) {
						tmp = tmp.left;
					}else {
						tmp.left = node;
						break;
					}
				}
			}
			
		}
		
	}
	public void displayLevelOrder() {
		if(root == null) {
			System.out.println("No Tree");
		}else {
			System.out.println("Level Order Traversal");
			Node tmp = root;
			Queue<Node> queue = new LinkedList<Node>();
			while(tmp != null) {
				if(tmp.left !=null) {
					queue.add(tmp.left);
				}
				if(tmp.right !=null) {
					queue.add(tmp.right);
				}
				System.out.print(tmp.data + " ");
				tmp = queue.poll();
			}
			
		}
		
	}
	public void displayInOrder(Node tmp) {
		if(tmp == null) {
			System.out.println("No Tree");
		}else {
			Stack<Node> stack = new Stack<Node>();
			while(tmp!=null) {
				if(tmp.left != null) {
					stack.push(tmp);
					tmp = tmp.left;
				}else {
					System.out.print(tmp.data + " ");
					tmp = tmp.right;
				}
				if(tmp == null && !stack.isEmpty()) {
					tmp = stack.pop();
					tmp.left=null;
				}
			}
			
		}
	}
	public void displayPostOrder(Node tmp) {
		if(tmp == null) {
			System.out.println("No Tree");
		}else {
			Stack<Node> stack = new Stack<Node>();
			while(tmp!=null) {
				if(tmp.left == null && tmp.right ==null) {
					System.out.print(tmp.data+" ");
					tmp = null;
					if(!stack.isEmpty()) {
						Node temp = stack.pop();
						tmp = temp.right;
						temp.right = null;
						stack.push(temp);
					}
										
				}
				else {
					Node temp = tmp.left;
					tmp.left = null;
					stack.push(tmp);
					tmp = temp;
				}
				if(tmp == null && !stack.isEmpty()) {
					tmp = stack.pop();
				}
			}
			
		}
	}
	public void displayPreOrder(Node tmp) {
		if(tmp == null) {
			System.out.println("No Tree");
		}else {
			Stack<Node> stack = new Stack<Node>();
			while(tmp!=null) {
				System.out.print(tmp.data + " ");
				if(tmp.right != null) {
					stack.push(tmp.right);
				}
				tmp = tmp.left;
				if(tmp == null && !stack.isEmpty()) {
					tmp = stack.pop();
				}
			}
			
		}
	}

	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(6);
		tree.add(8);
		tree.add(7);
		tree.add(2);
		tree.add(1);
		tree.add(5);
		tree.add(9);
		tree.displayLevelOrder();
//		System.out.println("\nPre-Order Traversal without Recursion");
//		tree.displayPreOrder(tree.root);
//		System.out.println("\nIn Order Traversal without Recursion");
//		tree.displayInOrder(tree.root);
		System.out.println("\nPost-Order Traversal without Recursion");
		tree.displayPostOrder(tree.root);

	}

}
