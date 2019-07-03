package junitrunlistener;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class TestClassB {
	
	@Test
	public void test_B_1(){
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void test_B_2(){
		assertTrue(2==5);
	}
}
