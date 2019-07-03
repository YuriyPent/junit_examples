package junitrunlistener;

import org.junit.runner.JUnitCore;

public class TestClassRun {

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new OurListener());
		runner.run(TestClassA.class, TestClassB.class);
	}
}
