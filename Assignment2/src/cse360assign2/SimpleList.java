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
 * @version 1.2
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
	 * The size of the list
	 */
	private int size;
	
	/**
	 * Class constructor. Initializes count to 0 and sets size of list to 10
	 */
	public SimpleList()
	{
		count = 0;
		size = 10;
		list = new int[size];
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
		if(count > size)
		{
			//find half of the size and add it to current size
			int halfSize = size / 2;
			size += halfSize;
					
			//declare a new integer list
			int[] newList = new int[size];
					
			//add newInt to the beginning of newList
			newList[0] = newInt;
					
			//use for loop to add the current list's integers to
			//newList, starting from the second place of newList
			for(int arrayNum = 0; arrayNum < (count - 1); arrayNum++)
			{
				newList[arrayNum + 1] = list[arrayNum];
			}
					
			//assign newList to list
			list = newList;
		} 
		else
		{
			//use for loop to swap the elements while inserting
			//newInt at the front of the array
			for(int arrayNum = 0; arrayNum < count; arrayNum++)
			{
				temp = list[arrayNum];
				list[arrayNum] = newInt;
				newInt = temp; 
			}
		}
	}
	
	/**
	 * Removes removeInt from the list
	 * @param removeInt - the integer to be removed from the list
	 */
	public void remove(int removeInt)
	{
		//local boolean variable declaration to make sure that if there are 
		//duplicates, only the first instance of the integer is removed
		boolean isRemoved = true;
		
		//for loop to search through list
		for(int arrayNum = 0; arrayNum < count; arrayNum++)
		{
			if(isRemoved)
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
					
					//if size is greater than 1 and count is 75% of size,
					//decrease size
					if(size > 1 && count <= ((size * 3) / 4))
					{
						//change size to three-fourths of it's original number
						//and create a new array with the new size
						size = ((size * 3) / 4);
						int[] newList = new int[size];
						
						//for loop to put the current list values into newList
						for(int replace = 0; replace < count; replace++)
						{
							newList[replace] = list[replace];	
						}
						
						//assign newList to list
						list = newList;
					}
					
					//change the boolean variable to false
					isRemoved = false;
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
			//and searchLocation is not populated with the
			//location of a duplicate integer
			if((list[arrayNum] == searchInt) && (searchLocation == -1))
			{
				//change searchLocation to the location
				//that searchInt is at
				searchLocation = arrayNum;
			}
		}
		return searchLocation;
	}
	
	/**
	 * Returns number of elements that could possibly be stored in the list
	 * @return size - the size of the list
	 */
	public int size()
	{
		return size;
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
		
		if(count > 0)
		{
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
		}
		else if(count == 0)
		{
			//print out an empty string if count is equal to 0
			intList = "";
		}
		
		return intList;
	}

} //end SimpleList class
