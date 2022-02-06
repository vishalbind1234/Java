package practice_problems;

import java.util.Arrays;

public class my_merge_sort {

	static int[] arr = {1,23,4,56,3,9,-1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] result = sort(0 , arr.length - 1 );
		System.out.println(Arrays.toString(result));
		
	}
	
	public static int[] sort(int l , int r ) {
		
	//---------------------------------------------------------------------------------
		if(l == r) {
			int[] single = {arr[l]};
			return single;
		}
	//----------------------------------------base case---------------------------------	
		
		int m = (l+r)/2;
		int[] l_arr = sort(l,m);
		int[] r_arr = sort(m+1,r);
		
		int[] res = new int[l_arr.length + r_arr.length];
		int i , j , k ;
		for(i = 0 , j = 0 , k = 0 ; i < l_arr.length && j < r_arr.length ;   ) {
			
			if(l_arr[i] <= r_arr[j]) {            //-------------putting elements one by one ---------------------
				res[k] = l_arr[i];        
				i++;
				k++;
			}
			else {
				res[k] = r_arr[j];
				j++;
				k++;
				
			}
			
		}
		
		for( ; i < l_arr.length ;  ) {      //-------------remaining elements in l_arr ----------------
			res[k] = l_arr[i];
			i++;
			k++;
		}
		
		for( ; j < r_arr.length ;  ) {       //-------------remaining elements in r_arr ----------------
			res[k] = r_arr[j];
			j++;
			k++;
		}
		
		return res;
		
		
	}
	
	

}