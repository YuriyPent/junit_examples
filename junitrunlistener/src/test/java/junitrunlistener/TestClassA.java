package junitrunlistener;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestClassA {

	@Test
	public void test_A_1(){
		assertTrue(1==2);
	}
	
	@Test
	public void test_A_2(){
		assertTrue(true);
	}
}
