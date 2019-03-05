import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }
  
  @Test
  public void testLength1() { 
	assertFalse(c.compute(0));
  }

  @Test (expected = RuntimeException.class)
  public void testRuntimeException() {
	  c.compute(0, 0, 0);
  }

  @Test
  public void testNumberEleven() {
	assertFalse(c.compute(1, 2));
  }

  @Test
  public void testSubjectHelloKitty()
  {
	assertTrue(c.compute(3, 5, 7));
  }

  @Test
  public void testSubjectLeopard()
  {
	assertFalse(c.compute(6, 8, 9));
  }
}
