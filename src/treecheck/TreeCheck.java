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
			System.out.println("USAGE: treecheck <Path to textfile>");
			return;
		}
		
		//Read file
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
		
		//Checks and statistics
		if(tr.isBalanced())
		{
			System.out.println("AVL: yes");
		}
		else
		{
			System.out.println("AVL: no");
		}
		System.out.println("min: "+tr.min()+", max: "+tr.max()+", avg: "+tr.average());
	}
}
