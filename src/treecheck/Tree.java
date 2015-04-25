package treecheck;

public class Tree
{
	private int value;
	private Tree leftBranch;
	private Tree rightBranch;
		
	Tree(int value)
	{
		this.value = value;
		leftBranch = null;
		rightBranch = null;
	}

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
	
	public int min()
	{
		return leftBranch == null ? value : leftBranch.min();
	}
	
	public int max()
	{
		return rightBranch == null ? value : rightBranch.max();
	}
	
	public double average()
	{
		double sum = (double) this.sum();
		double count = (double) this.count();
		return sum/count;
	}
	
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