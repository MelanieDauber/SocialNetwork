/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Melanie Dauber */

package project;

public class SocialBST {
	
	//create node
	class Node{
	  Profile data;
		String key;
		Node left, right;
		
		//add node at end
		Node (Profile info){
			data = info;
			left = null;
			right = null;
			key = info.name;
		}
		
		//add node
		Node (Profile info, Node leftChild, Node rightChild){
			data = info;
			left = leftChild;
			right = rightChild;
		}
	}
	
	private Node root = null;
	
	public void insert(Profile info){
		root = insert(info, root);
	}
	
	//insert new node
	private Node insert(Profile info, Node root){
		if (root == null){
			root = new Node(info);
		} else if (info.name.compareToIgnoreCase(root.key) < 0){
			root.left = insert(info, root.left);
		} else if (info.name.compareToIgnoreCase(root.key) > 0){
			root.right = insert(info, root.right);
		}
		return root;
	}
	
	public Profile findProfile(String key){
		return findProfile(root, key);
	}
	
	//search given a name
	private Profile findProfile(Node root, String key){
		if (root == null){
			return null;
		}
		if (key.compareToIgnoreCase(root.key) < 0){
			return findProfile(root.left, key);
		} else if (key.compareToIgnoreCase(root.key) > 0){
			return findProfile(root.right, key);
		} else {
			return root.data;
		}
	}
	
}
