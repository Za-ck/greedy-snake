package snake;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
  private static Node node = new Node(0, 0);

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testGetNodeX() {
    node.setNodeX(1);
    assertEquals(1, node.getNodeX());

  }

  @Test
  public void testGetNodeY() {
    node.setNodeY(1);
    assertEquals(1, node.getNodeY());
  }

}
