package cse360assign2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleListTest {

	@Test
	public void testAddSuccess() 
	{
		SimpleList aList = new SimpleList();
		aList.add(3);
		aList.add(10);
		assertEquals("10 3", aList.toString());
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		assertEquals("10 3 10 3 10 3 10 3 10 3 10 3", aList.toString());
		assertEquals(15, aList.size());
	}
	
	@Test
	public void testAddFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(3);
		aList.add(10);
		assertNotEquals("3 10", aList.toString());
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		aList.add(3);
		aList.add(10);
		assertNotEquals("10 3 10 3 10 3 10 3 10 3", aList.toString());
	}
	
	@Test
	public void testRemoveSuccess() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(4);
		aList.remove(2);
		assertEquals("4 10", aList.toString());
		assertEquals(7, aList.size());
		aList.remove(4);
		aList.remove(10);
		aList.remove(0);
		assertEquals(0, aList.count());
		aList.add(2);
		aList.add(2);
		aList.add(10);
		aList.add(2);
		aList.remove(2);
		assertEquals("10 2 2", aList.toString());
	}

	@Test
	public void testRemoveFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.remove(5);
		assertNotEquals("2", aList.toString());
		assertNotEquals(7, aList.size());
		aList.add(2);
		aList.add(2);
		aList.remove(2);
		assertNotEquals("10", aList.toString());
	}
	
	@Test
	public void testCountSuccess() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		assertEquals(1, aList.count());
		aList.add(10);
		assertEquals(2, aList.count());
		aList.add(9);
		assertEquals(3, aList.count());
	}
	
	@Test
	public void testCountFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.remove(2);
		aList.add(5);
		aList.add(10);
		assertNotEquals(4, aList.count());
	}
	
	@Test
	public void testSearchSuccess() 
	{
		SimpleList aList = new SimpleList();
		assertEquals(-1, aList.search(15));
		aList.add(2);
		aList.add(10);
		aList.add(9);
		assertEquals(1, aList.search(10));
		aList.add(2);
		aList.add(9);
		aList.add(10);
		assertEquals(2, aList.search(2));
	}
	
	@Test
	public void testSearchFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(5);
		assertNotEquals(2, aList.search(5));
		aList.add(2);
		aList.add(3);
		assertNotEquals(4, aList.search(2));
	}
	
	@Test
	public void testAppendSuccess() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.append(9);
		aList.append(2);
		aList.append(10);
		assertEquals("10 2 9 10 2 9 2 10", aList.toString());
	}
	
	@Test
	public void testAppendFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(5);
		aList.append(39);
		aList.append(2);
		aList.append(10);
		assertNotEquals("10 2 39 5 10 2", aList.toString());
	}
	
	@Test
	public void testFirstSuccess() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.append(9);
		aList.append(2);
		aList.append(10);
		assertEquals(10, aList.first());
	}
	
	@Test
	public void testFirstFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(5);
		aList.append(39);
		aList.append(2);
		aList.append(10);
		assertNotEquals(10, aList.first());
	}
	
	@Test
	public void testLastSuccess() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.append(9);
		aList.append(2);
		aList.append(10);
		aList.append(17);
		assertEquals(17, aList.last());
	}
	
	@Test
	public void testLastFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(5);
		aList.append(39);
		aList.append(2);
		aList.append(10);
		aList.append(13);
		assertNotEquals(2, aList.last());
	}
	
	@Test
	public void testSizeSuccess() 
	{
		SimpleList aList = new SimpleList();
		assertEquals("", aList.toString());
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.append(9);
		aList.append(2);
		aList.append(10);
		assertEquals(10, aList.size());
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		assertEquals(15, aList.size());
		aList.remove(10);
		aList.remove(9);
		aList.remove(2);
		assertEquals(11, aList.size());
	}
	
	@Test
	public void testSizeFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(5);
		aList.append(39);
		aList.append(2);
		aList.append(10);
		aList.add(2);
		aList.add(10);
		aList.add(5);
		aList.append(39);
		aList.append(2);
		aList.append(10);
		assertNotEquals(10, aList.size());
		aList.remove(39);
		aList.remove(2);
		aList.remove(5);
		aList.remove(10);
		aList.remove(5);
		aList.remove(2);
		assertNotEquals(10, aList.size());
	}
	
	@Test
	public void testToStringSuccess() 
	{
		SimpleList aList = new SimpleList();
		assertEquals("", aList.toString());
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.add(9);
		aList.add(2);
		aList.add(10);
		aList.add(9);
		assertEquals("9 10 2 9 10 2 9 10 2 9", aList.toString());
	}
	
	@Test
	public void testToStringFail() 
	{
		SimpleList aList = new SimpleList();
		aList.add(2);
		aList.add(10);
		aList.add(5);
		assertNotEquals("2 10 5", aList.toString());
	}

}
