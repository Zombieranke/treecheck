package treecheck;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TreeCheck
{
	static Tree tr;
	
	public static void main(String[] args)
	{
		if ((args.length < 1) || (args.length > 1))
		{
			System.out.println("Not the right amount of arguments! Aborting!");
			return;
		}
		try
		{
			Scanner sc = new Scanner(Paths.get(args[0], new String[0]));
			if (sc.hasNextInt())
			{
				tr = new Tree(sc.nextInt());
			}
			else
			{
				System.out.println("File is empty");
			}
			while (sc.hasNextInt())
			{
				tr.addNode(sc.nextInt());
			}
			sc.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if(tr.isBalanced())
		{
			System.out.print("AVL: yes");
		}
		else
		{
			System.out.print("AVL: no");
		}
		System.out.println();
		System.out.print("min: "+tr.min()+", max: "+tr.max()+", avg: "+tr.average());
	}
}
