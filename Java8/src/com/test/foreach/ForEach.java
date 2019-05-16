/**
 * 
 */
package com.test.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author KJAYATHILAKE
 *
 */
public class ForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			myList.add(i);
		}
		
	
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
			
		});

	}

}
