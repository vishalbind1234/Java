package practice_problems;

public class binary_search {
	
	static int[] arr = {1,2,3,4,5,6,7,8,9};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int data = 10;
		
		int index = search(data , 0 , arr.length-1);
		System.out.println(index);

	}
	
	public static int search(int data , int l , int r) {
		
		if(l < 0 || r > arr.length-1 || l == r )
			if(arr[l] != data)
				return -1;
		
		
		int mid = (l+r)/2;
		
		if(data == arr[mid] )
			return mid;
		
		if(data > arr[mid]) {
			l = mid+1;
			return search(data , l , r);
		}
		
		if(data < arr[mid]) {
			r = mid-1;
			return search(data , l , r);
		}
		
		return -1;
	}

}
