/**
 * 
 */
package JavaHomePractise;

import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist {

	public static void main(String[] args) {
		ArrayList<String> obj1=new ArrayList<String>();
		obj1.add("Ravi");
		obj1.add("Kamal");
		obj1.add("kiran");
		obj1.add("Rajesh");
		obj1.add("Kumar");
		obj1.add("Naresh");
		System.out.println(obj1.size());
		System.out.println("Display1 : "+obj1);
		
		ArrayList<String> obj2=new ArrayList<String>();
		obj2.add("Sailu");
		obj2.add("Anu");
		obj2.add("barghavi");
		System.out.println(obj2.size());
		System.out.println("Display1 : "+obj2);
		
//AddAll( merging to objects)........................
		obj1.addAll(obj2);
		System.out.println("obj1 & obj2 : "+ obj1);
		
		
//ContainsAll........................................
		obj1.containsAll(obj1);
		System.out.println("obj1 & obj2 : "+ obj1);
	
		
//get.................................................
		System.out.println("Gets all the items present in ArryList using ForLoop");
		for(int i=0;i<obj1.size();i++){
			System.out.println(obj1.get(i));
		}
		
		
//Clear...............................................
			//obj1.clear();
			//System.out.println("Clears all the items in ArrayList : "+ obj1);
		
//Iteration
		System.out.println("    ");
		System.out.println("Iteration List...................: ");
		Iterator<String> itr=obj1.iterator();
		while(itr.hasNext()){
		String name=itr.next();
		System.out.println(name);
		}
	
//Remove		
		System.out.println("Remove perticular item in array...................: ");
		obj1.remove(0);
		System.out.println(obj1);
		
//Index of	
		System.out.println(obj1.size());
		int s=obj1.lastIndexOf("kiran");
		System.out.println(s);
		
	}
}
