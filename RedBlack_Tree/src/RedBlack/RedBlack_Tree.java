package RedBlack;

public class RedBlack_Tree {
	
	private Node root;
	
	public RedBlack_Tree() {
		root = null;
	}
	
	public void insert(int v)
	{
		if(root ==null)
		{
			root = new Node(v, Color.Black, null);
			return;
		}
		
		Node iterator = root;
		Node newNode = 	insertRec(v, iterator);
		
		traverseColors(newNode);
		
	}
	////////////////////////////////////////////
	
	public void print ()
	{
		printRec(root, 0);
	}
	private void printRec (Node iterator, int level)
	{
		if(iterator == null)
			return;
		
		printRec(iterator.left, level +1 );
		
		System.out.println("level = " + level + "  value = " + iterator.value + " color " + iterator.color);
		
		printRec(iterator.right, level +1 );
		
	}
	////////////////////////////////////////////
	private Node insertRec(int v, Node iterator)
	{
		if(v <= iterator.value)
		{
			if(iterator.left == null)
			{
				iterator.left = new Node(v, Color.Red, iterator);
				return iterator.left;
			}
			return insertRec(v, iterator.left);
		}
		
		else
		{
			if(iterator.right == null)
			{
				iterator.right = new Node(v, Color.Red, iterator);
				return iterator.right;
			}
			return insertRec(v, iterator.right);
		}
		
		
	}
	/////////////////////////////
	private void traverseColors(Node iterator)
	{
		if(iterator == null)
			return;
		// reach root
		if(iterator.parent == null)
		{
			iterator.color = Color.Black;
			return;
		}
		////////////////////////////////////////
		// no problem here
		if(iterator.parent.color == Color.Black)
			return;
		// no uncle
		if(iterator.getUncle() == null)
		{
			doRotation(iterator);
		}
		// uncle exists
		else
		{	
			// parent is red and uncle is red
			if(iterator.color == iterator.getUncle().color)
			{
				//System.out.println("Uncle Red");
				iterator.parent.color = iterator.getUncle().color = Color.Black;
				
				iterator.parent.parent.color = Color.Red;
				
			}
			// uncle is black
			else
			{
				//System.out.println("Uncle Black");
				doRotation(iterator);
			}
		}
		iterator = iterator.parent.parent;
		traverseColors(iterator);
	}
	
	///////////////////////////////////////////
	public void doRotation(Node iterator)
	{
		// parent is left 
		if(iterator.parent == iterator.parent.parent.left)
		{
			// left left 
			if(iterator == iterator.parent.left)
			{
				
				
			}
			// left right
			else
			{
				
				
			}
			
		}
		// parent is right
		else{	
			// right left 
			if(iterator == iterator.parent.left)
			{
				
				
			}
			// right right
			else
			{
				
				
			}

		}
	}
	///////////////////////////////////////////////////////////////
	private void rotateRight (Node x){
		// 1 node not null
		if(x == null)
			return;
		// 2 left node not null
		if(x.left == null)
			return;
		// 3 keep left node in y
		Node y = x.left;
		
		// 4 update parent of  y  to parent of x
		y.parent = x.parent;
		// 5 update x's parent 
		x.parent = y;
		
		// 6 if y's parent not null make y his child instead of x
		if (y.parent != null)
		{
			if(x == y.parent.left )
				y.parent.left = y;
			else
				y.parent.right = y;
		}
		else
			root = y;
		// 7 update x left 
		x.left = y.right;
		// 8 update parent of x left
		if(x.left != null)
			x.left.parent = x;
		// 9 update y right
		y.right = x;
	}
	////////////////////////////
	private void rotateLeft (Node x){
		// 1 node not null
		if(x == null)
			return;
		// 2 right node not null
		if(x.right == null)
			return;
		// 3 keep left node in y
		Node y = x.right;
		// 4 update parent of  y  to parent of x
		y.parent = x.parent;
		// 5 update x's parent 
		x.parent = y;
		// 6 if y's parent not null make y his child instead of x
		if (y.parent != null)
		{
			if(x == y.parent.left )
				y.parent.left = y;
			else
				y.parent.right = y;
		}
		else
			root = y;
		// 7 update x right 
		x.right = y.left;
		// 8 update parent of x right
		if(x.right != null)
			x.right.parent = x;
		// 9 update y left
		y.left = x;
	}
	//////////////////////////////////////////
	public void testRotateRight()
	{
		rotateRight(root);
	}
	public void testRotateLeft()
	{
		rotateLeft(root);
	}
}
