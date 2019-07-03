package junitmultithread;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;

@RunWith(ConcurrentTestRunner.class)
public class CountCheckTest {

	private CountCheck counter = new CountCheck();
	
	@Before
	public void initialCount(){
		counter.initialize(2);
	}
	
	@Test
	public void addOne() {
		counter.addOne();
	}

	@After
	public void testCount() {
		assertEquals("Value should be 6", 6, counter.getCount());
	}
}
