package junit;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class JUnitHelloWorldTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@Before
	public void before() {
		System.out.println("Before Test Case");
	}

	@Test
	public void isGreaterTest() {
		System.out.println("Test");
		JUnitHelloWorld tester = new JUnitHelloWorld();
		assertTrue("Num 1 is greater than Num 2", tester.isGreater(3, 2));
	}

	@After
	public void after() {
		System.out.println("After Test Case");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
}
