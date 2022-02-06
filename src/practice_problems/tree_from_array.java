package practice_problems;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
public class tree_from_array {
	
	static int[] arr =  {0,0,1,0,1 , 1 ,0};
	static int[] print_arr  = new int[3];
	
	static ArrayList<Integer> alist = new ArrayList<Integer>();
	static int idx = -1;

	static int level = 0  ,  node_no = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 node root = new node();
		 
		 createFurther(root);
		 

		 System.out.println(root.right.left.data);
		 
		 if(root.right.left.left == null)
			 System.out.println("yes");
		 
		 print_dfs_arr(root);
		 
		 System.out.println("--------------------------------");
		 
		 print_dfs_alist(root);

	}
	
	//--------------------------------------------------------further node method ---------------------------------------------
	
	public static void createFurther(node n) {
		
	// --------------------------------------------------------------------------------
		if(node_no >= arr.length) {	
			n = null ;
			return;
		}
   //-----------------------------------------------base-----------------------------		
		
		
		if(node_no < arr.length) {
			
			n.data = arr[node_no];
			
			
			level = level + 1;
			node_no = 2*node_no + 1;
			
			if(node_no < arr.length) {	
				n.left = new node();
			}
			
			createFurther(n.left);
			
			node_no = node_no/2 ;
			level = level - 1;
	//-----------------------------------------------------------------------------------		
			level = level + 1;
			node_no = 2*node_no + 2;
			
			if(node_no < arr.length) {	
				n.right = new node();
			}
			createFurther(n.right);
			
			node_no = node_no/2 - 2;
			level = level - 1;
			
			return;

		}
		
	}
	
	
	
//-----------------------------------------node class---------------------------------------------------------	
	
	public static class node{
		int data;
		node left ;
		node right ;
	}
	
	public static void print_dfs_arr(node n) {
		
		if(n == null) {
			
			System.out.println(Arrays.toString(print_arr));
			
			return;
		}
		
		idx++;
		print_arr[idx] =  n.data;

		print_dfs_arr(n.left);
		print_dfs_arr(n.right);
		print_arr[idx] = -1;
		idx--;
		
		return;
	}
	
public static void print_dfs_alist(node n) {
		
		if(n == null) {
			
			System.out.println(alist);
			
			return;
			
		}

		alist.add(n.data);
		print_dfs_alist(n.left);
		
		print_dfs_alist(n.right);
		alist.remove(n.data);
		
		return;
	}
	

}
