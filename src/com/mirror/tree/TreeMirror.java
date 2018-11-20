package com.mirror.tree;

public class TreeMirror
{
	TreeNode root;

	public void mirror()
	{
		root = getMirror(root);
	}

	TreeNode getMirror(TreeNode node)
	{
		if (node == null)
			return node;

		// For sub tree
		TreeNode left = getMirror(node.left);
		TreeNode right = getMirror(node.right);

		// change the pointers
		node.left = right;
		node.right = left;

		return node;
	}

	public void inOrder()
	{
		inOrder(root);
	}

	//overloaded method
	public void inOrder(TreeNode node)
	{
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	public static void main(String args[])
	{
		//create a tree
		TreeMirror tree = new TreeMirror();
		tree.root = new TreeNode(8);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(9);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(10);

		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror();

		System.out.println("Inorder traversal of mirror tree is : ");
		tree.inOrder();

	}
}
