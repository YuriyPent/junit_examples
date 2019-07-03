package junitgrouptest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassBTest {

	@Test
	@Category(PerformanceTests.class)
	public void classB_Test1() {
		System.out.println("classB_Test1");
	}

	@Test
	@Category(SlowTests.class)
	public void classB_Test2() {
		System.out.println("classB_Test2");
	}
}
