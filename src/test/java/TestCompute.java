import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {
  Compute c;
  
  MessageQueue mq;

  @Before
  public void init()
  {
	mq = mock(MessageQueue.class);
	c = new Compute(mq);
  }

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
	when(mq.contains("SuMeRkAn")).thenReturn(true);
	when(mq.getAt(any(Integer.class))).thenReturn("SuMeRkAn");
	assertEquals(c.countNumberOfOccurrences("SuMeRkAn"), 2);
	verify(mq, times(2)).getAt(any(Integer.class));
  }

  @Test
  public void testForLoop2()
  {
	when(mq.size()).thenReturn(30);
	when(mq.contains("Hello")).thenReturn(true);
	when(mq.getAt(3)).thenReturn("Hello");
	assertEquals(c.countNumberOfOccurrences("Hello"), 1);
	verify(mq, times(30)).getAt(any(Integer.class));
	
  }
}
