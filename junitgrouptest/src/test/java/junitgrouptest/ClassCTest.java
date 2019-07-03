package junitgrouptest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SlowTests.class)
public class ClassCTest {

	@Test
	public void classC_Test1() {
		System.out.println("classC_Test1");
	}

	@Test
	public void classC_Test2() {
		System.out.println("classC_Test2");
	}
}
