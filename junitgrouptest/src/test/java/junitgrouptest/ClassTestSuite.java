package junitgrouptest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClassATest.class, ClassBTest.class, ClassCTest.class })
public class ClassTestSuite {

}
