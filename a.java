// C# program to find inorder
// successor of a node
using System;

class GFG
{
	
// A Binary Tree Node
public class Node
{
	public int data;
	public Node left, right;
}

// Temporary node for case 2
public static Node temp = new Node();

// Utility function to create
// a new tree node
public static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = temp.right = null;
	return temp;
}

// function to find left most
// node in a tree
public static Node leftMostNode(Node node)
{
	while (node != null &&
		node.left != null)
	{
		node = node.left;
	}
	return node;
}

// function to find right most
// node in a tree
public static Node rightMostNode(Node node)
{
	while (node != null &&
		node.right != null)
	{
		node = node.right;
	}
	return node;
}

// recursive function to find the
// Inorder Successor when the right
// child of node x is null
public static Node findInorderRecursive(Node root,
										Node x)
{
	if (root == null)
	{
		return null;
	}

	if (root == x ||
	(temp = findInorderRecursive(root.left, x)) != null ||
	(temp = findInorderRecursive(root.right, x)) != null)
	{
		if (temp != null)
		{
			if (root.left == temp)
			{
				Console.Write("Inorder Successor of " + x.data);
				Console.Write(" is " + root.data + "\n");
				return null;
			}
		}

		return root;
	}

	return null;
}

// function to find inorder successor
// of a node
public static void inorderSuccessor(Node root, Node x)
{
	// Case1: If right child is not null
	if (x.right != null)
	{
		Node inorderSucc = leftMostNode(x.right);
		Console.Write("Inorder Successor of " +
							x.data + " is ");
		Console.Write(inorderSucc.data + "\n");
	}

	// Case2: If right child is null
	if (x.right == null)
	{
		int f = 0;

		Node rightMost = rightMostNode(root);

		// case3: If x is the right most node
		if (rightMost == x)
		{
			Console.Write("No inorder successor! " +
							"Right most node.\n");
		}
		else
		{
			findInorderRecursive(root, x);
		}
	}
}

// Driver Code
public static void Main(string[] args)
{
	// Let's construct the binary tree
	// as shown in above diagram
	Node root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.right = newNode(6);

	// Case 1
	inorderSuccessor(root, root.right);

	// case 2
	inorderSuccessor(root, root.left.left);

	// case 3
	inorderSuccessor(root, root.right.right);
}
}

// This code is contributed by Shrikant13
