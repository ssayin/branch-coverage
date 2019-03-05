import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;

public class TestCompute {
  Compute c;
  
  @Mock
  MessageQueue mq ;

  @Rule
  public MockitoRule rule = new MockitoJUnit.rule();

  @Test
  public void example() {
    assertTrue(true);
  }

  @Test
  public void testConstructor()
  {
	assertEquals(c.mq, this.mq);
  }

  @Test
  public void testCode3434()
  {
	when(mq.size()).thenReturn(0);
	assertEquals(c.countNumberOfOccurrences(""), -1);
	verify(mq, times(1)).size();
	verify(mq, never()).contains(any(String.class));
  }

  @Test
  public void testNotContains()
  {
	when(mq.size()).thenReturn(1);
	when(mq.contains(any(String.class))).thenReturn(false);
	assertEquals(c.countNumberOfOccurrences(""), 0);
  }

  @Test
  public void testForLoop()
  {
	when(mq.size()).thenReturn(2);
	when(mq.contains("asd")).thenReturn(true);
	when(mq.getAt(any(Integer.class))).thenReturn("abc");
	assertEquals(c.countNumberOfOccurrences("asd"), 2);
  }
}
