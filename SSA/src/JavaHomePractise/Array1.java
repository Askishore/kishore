package JavaHomePractise;

public class Array1 {
	
//.................Print all the array elements using while loop.................
	public void arrwhile(int[] numbers){
		System.out.println("Print all the array elements using for whileloop");
		int i=0;
		while(i<=numbers.length){
			System.out.println(numbers[i]);
		i++;
		}
	}
	
	

// .................Print all the array elements using for each loop..................
	public void arrfor(int[] numbers){	
		System.out.println("Print all the array elements using for each loop");
		for(int x:numbers){
			System.out.println(x);
		}	
	}
	
	
//.................. Print all the array elements using for loop.......................
	public void arrlen(int[] numbers){
		System.out.println("Print all the array elements using for loop");
		for(int i=0;i<numbers.length;i++){
			System.out.println(numbers[i]);
		}
	}
	
	
//.................... Print all the added array elements................................
    public void arradd(int[] numbers){
    	System.out.println("Print all the added array elements");
    	int total=0;
    	for(int y:numbers){
    		System.out.println(y);
    		total+=y;
    	}
    	System.out.println("Sum of the array is: "+ total);    	
    }
	
	public static void main(String[] args) {
		int[] a={10,20,30,40,50};
		Array1 arr=new Array1();
		arr.arrfor(a);
		arr.arrlen(a);
		arr.arradd(a);
		arr.arrwhile(a);
	}
}
