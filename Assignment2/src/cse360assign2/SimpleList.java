//Filename: SimpleList.java
//Name: Amber Luu
//Class ID: 315
//Assignment #: 1
//Description: A class for a simple list of integers with
//			   methods to interact with the list

package cse360assign2;
import java.util.*;

/**
 * Allows user to create a simple integer list
 * @author amber
 * @version 1.0
 */
public class SimpleList 
{
	/**
	 * The array to hold the list of integers
	 */
	private int[] list;
	
	/**
	 * The number of integers in the list
	 */
	private int count;
	
	/**
	 * Class constructor. Initializes count to 0 and sets size of list to 10
	 */
	public SimpleList()
	{
		count = 0;
		list = new int[10];
	}
	
	/**
	 * Adds newInt to the front of the list
	 * @param newInt - the integer to be added to the list
	 */
	public void add(int newInt)
	{
		//declare third variable for swapping elements
		int temp;
		
		//increment count
		count++;
		
		//if statement to make sure that count stays at ten or less
		if(count == 11)
		{
			count = 10;
		} 
		
		//use for loop to swap the elements while inserting
		//newInt at the front of the array
		for(int arrayNum = 0; arrayNum < count; arrayNum++)
		{
			temp = list[arrayNum];
			list[arrayNum] = newInt;
			newInt = temp; 
		}
	}
	
	/**
	 * Removes removeInt from the list
	 * @param removeInt - the integer to be removed from the list
	 */
	public void remove(int removeInt)
	{
		//for loop to search through list
		for(int arrayNum = 0; arrayNum < count; arrayNum++)
		{
			//if statement to check if removeInt is in list
			if(list[arrayNum] == removeInt)
			{
				//variable declaration for where to start with
				//removing elements in list
				int startRemove = arrayNum;
				
				//for loop to shift all of the elements down
				//and also replaces where removeInt was
				for(int shift = (arrayNum + 1); shift < count; shift++)
				{
					list[startRemove] = list[shift];
					startRemove++;
				}
				
				//decrement count and replace last element that's shifted with 0
				if(count > 0)
				{
					count--;
					list[count] = 0;
				}
			}
		}
	} 
	
	/**
	 * Returns number of elements stored in the list
	 * @return count - the number of elements stored in the list
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Returns the location of searchInt in the list
	 * @param searchInt - the integer to search for
	 * @return searchLocation - the index of searchInt. 
	 *         If searchInt is not in the array, searchLocation is -1.
	 */
	public int search(int searchInt)
	{
		//declare local variable and initialize it with -1
		int searchLocation = -1;
		
		//for loop to search through the array
		for(int arrayNum = 0; arrayNum < count; arrayNum++)
		{
			//if statement for if searchInt is in the array
			if(list[arrayNum] == searchInt)
			{
				//change searchLocation to the location
				//that searchInt is at
				searchLocation = arrayNum;
			}
		}
		return searchLocation;
	}
	
	/**
	 * Returns the values in the list separated by spaces
	 * @return intList - the list as a String
	 */
	public String toString()
	{
		//declare variables to hold the String values
		String intString = new String();
		String intList = new String();
		
		//add first value of list to intList
		intList = String.valueOf(list[0]);
		
		//for loop to iterate through the list
		for(int arrayNum = 1; arrayNum < count; arrayNum++)
		{
			//convert integer to String
			intString = String.valueOf(list[arrayNum]);
			
			//concatenate intString to intList
			intList = intList + " " + intString;
		}
		
		return intList;
	}

} //end SimpleList class
