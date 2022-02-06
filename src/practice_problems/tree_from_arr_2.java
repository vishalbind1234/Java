package practice_problems;

import java.util.ArrayList;
import java.lang.Math;

public class tree_from_arr_2 {
	
	static int[] arr = {0,1,0,1,0,0,1};
	static int node_no = 0;
	static int level = 0;
	static ArrayList<Integer> alist = new ArrayList<Integer>();
	static int total = 0;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		node root = new node();
		furtherNode(root);
		
		//System.out.println(root.left.left.data);
		
		print_till_leaves(root);
		System.out.println("\n total  = " + total/2);

		

	}

//-----------------------------------------------------furtherNode()--------------------------------
	
	//  node_no  and  arr[]  is taken as static variable.........
	
	public static void furtherNode(node n) { // root node is passed in this function
		
		if(node_no < arr.length) {
			n.data = arr[node_no];
		}
		
		if(2*node_no + 1 < arr.length) {  //---------check for left node  data
			
			n.left = new node();  //-------------if data present for left node then initialize left node-----
			node_no = 2*node_no + 1 ;  //-------------node number acts as index of array---------
			furtherNode(n.left);
			node_no = node_no/2 ; //-------------this line is for  backtracking----------
			
		}
		else {
			n.left = null;
		}
	
		if(2*node_no + 2 < arr.length) {  //-------------check for right node data
			
			n.right = new node();   //-------------if data present for right node then initialize right node-----
			node_no = 2*node_no + 2 ;  //-------------node number acts as index of array---------
			furtherNode(n.right);
			node_no = node_no/2 - 1 ;  //-------------this line is for  backtracking----------
			
		}
		else {
			n.right = null;
		}
		
		return;
	}
	
//----------------------------------------------------class node-------------------------------------	
	
	public static class node{
		
		int data;
		node left ;
		node right ;
	}
	
//---------------------------------------------------print_till_leaves()-------------------------------------	

	public static void print_till_leaves(node n) {
		
		if(n == null) {
			System.out.println(alist);
			int ans = 0;
			int sum = 0;
			for(int b : alist) {
				sum = sum + (b * (int)(Math.pow(2 , ans)) );
				ans++;
			}
			total = total + sum;
			System.out.println( sum);
			
			return;

		}
		
		alist.add(n.data);
		print_till_leaves(n.left);
		print_till_leaves(n.right);
		alist.remove(n.data);
	}
}


