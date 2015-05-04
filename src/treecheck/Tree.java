package treecheck;

/**Implementation of a tree node
 * 
 * @author Christoph Majcen and Arthur Bouz
 */
public class Tree
{
	/**Value of the node
	 */
	private int value;
	
	/**The left branch of the tree with this node as root
	 */
	private Tree leftBranch;
	
	/**The right branch of the tree with this node as root
	 */
	private Tree rightBranch;

	/**Constructs a new tree node
	 * 
	 * @param value The value of this node
	 */
	Tree(int value)
	{
		this.value = value;
		leftBranch = null;
		rightBranch = null;
	}
	
	/**Adds a node with given value to this tree
	 * 
	 * @param value The value of the node to add
	 */
	public void addNode(int value)
	{
		if(this.value > value)
		{
			if(leftBranch == null)
			{
				leftBranch = new Tree(value);
			}
			else
			{
				leftBranch.addNode(value);
			}
		}
		else if(this.value < value)
		{
			if(rightBranch == null)
			{
				rightBranch = new Tree(value);
			}
			else
			{
				rightBranch.addNode(value);
			}
		}
		else
		{
			System.out.println(value + "is already part of the tree");
		}
		
	}	
	
	/**Gets the height of this tree
	 * 
	 * @return The height
	 */
	public int getHeight()
	{
		int heightLeft = 0;
		int heightRight = 0;
		int maximum = 0;

		if(leftBranch != null)
		{
			heightLeft = leftBranch.getHeight();
		}
		
		if(rightBranch != null)
		{
			heightRight = rightBranch.getHeight();
		}
		
		maximum = Math.max(heightLeft,heightRight);
		
		return 1 + maximum;
	}
	
	/**Checks whether this tree is balanced
	 * 
	 * @return True if balanced, false if not
	 */
	public boolean isBalanced()
	{
		boolean avlTree = true;
		boolean avlLeft = true;
		boolean avlRight = true;
		int balance = 0;
		int heightLeft = 0;
		int heightRight = 0;
			
		if(rightBranch != null)
		{
			avlRight = rightBranch.isBalanced();
			heightRight = rightBranch.getHeight();
		}
		
		if(leftBranch != null)
		{
			avlLeft = leftBranch.isBalanced();
			heightLeft = leftBranch.getHeight();
		}

		avlTree = avlLeft && avlRight;
		
		balance = heightRight - heightLeft;
		
		System.out.print("bal("+value+") = "+balance);
		
		if(Math.abs(balance)>1)
		{
			System.out.print(" (AVL violation!)");
			avlTree = false;
		}
		System.out.println();
		
		return avlTree;
	}
	
	/**Retrieves the minimum value of this tree
	 * 
	 * @return The minimum value
	 */
	public int min()
	{
		return leftBranch == null ? value : leftBranch.min();
	}
	
	/**Retrieves the maximum value of this tree
	 * 
	 * @return The maximum value
	 */
	public int max()
	{
		return rightBranch == null ? value : rightBranch.max();
	}
	
	/**Calculates the average value of this tree
	 * 
	 * @return The average value
	 */
	public double average()
	{
		double sum = (double) this.sum();
		double count = (double) this.count();
		return sum/count;
	}
	
	/**Calculates the sum of all nodes of this tree
	 * 
	 * @return The sum of all nodes
	 */
	public int sum()
	{
		int sum = value;
		
		if(leftBranch != null)
		{
			sum += leftBranch.sum();
		}
		
		if(rightBranch != null)
		{
			sum += rightBranch.sum();
		}
		
		return sum;
	}
	
	/**Counts the nodes of the tree
	 * 
	 * @return The count of nodes
	 */
	public int count()
	{
		int count = 1;
		
		if(leftBranch != null)
		{
			count += leftBranch.count();
		}
		
		if(rightBranch != null)
		{
			count += rightBranch.count();
		}
		
		return count;
	}
}