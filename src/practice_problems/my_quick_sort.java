package practice_problems;

import java.util.Arrays;

public class my_quick_sort {

	static int[] arr = { 555,6,6,555 , 25, -1,1,6,0 , 0 , 0 , 3,7 ,1 , 1 , 555,67,555, 0, 99 , 10 , -1 , -1 , -1 , -1 ,-1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sort(0 , arr.length - 1 );
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr));

		
	}
	
	public static void sort(int l , int r ) {
		
		int pivot = (l+r)/2 , left = l , right = r;
		
//----------------------------------------base case------------------------------------------------		
		if(left >= right)
			return;
//-------------------------------------------------------------------------------------------------
		outerloop:
		while(left < right) {
			
			
			while(arr[left] <= arr[pivot] ) {                      
				left++;
		
				if(left > right) {
					break outerloop;
				} 
			}
			
			while(arr[right] >= arr[pivot] ) {
				right--;  
	
			    if(right < left) {
					break outerloop;
				}   
			}
		
			if(left < right) {
				swap(left , right); 
			}	

		}
		
		
		
		if(left > pivot) {
			swap(pivot , right);
			sort(l , right-1);
			sort(right+1 , r);
			return;
		}
		if(left < pivot) {
			swap(pivot , left);
			sort(l , left-1);
	    	sort(left+1 , r);
	    	return;
		}
		
		
			
	}
	
//--------------------swap method--------------------------------------------------------------------------
	
	public static void swap(int a , int b ) {      
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
		
	}
	
	

}