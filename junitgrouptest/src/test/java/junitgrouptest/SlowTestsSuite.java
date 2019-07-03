package junitgrouptest;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Suite.SuiteClasses({ClassATest.class, ClassBTest.class, ClassCTest.class})
public class SlowTestsSuite {

}
