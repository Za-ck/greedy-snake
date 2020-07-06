package snake;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SnakeTest {
  private static Snake snake = new Snake(0, 0, null);

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testGetDirection() {
    snake.setDirection(0);
    assertEquals(0, snake.getDirection());
    snake.setDirection(1);
    assertEquals(1, snake.getDirection());
    snake.setDirection(2);
    assertEquals(2, snake.getDirection());
    snake.setDirection(3);
    assertEquals(3, snake.getDirection());

  }

  @Test
  public void testSnakeMove() {
    snake.setDirection(0);  
    snake.snakeMove();
    assertEquals(-15, snake.getSnakeHead().getNodeY());
    snake.setDirection(1);  
    snake.snakeMove();
    assertEquals(15, snake.getSnakeHead().getNodeX());
    snake.setDirection(2);  
    snake.snakeMove();
    assertEquals(0, snake.getSnakeHead().getNodeY());
    snake.setDirection(3);  
    snake.snakeMove();
    assertEquals(0, snake.getSnakeHead().getNodeX());
    snake.snakeMove();

  }

  @Test
  public void testSnakeRunInterFace() {
    snake.setSnakeHead(-1, 1);
    snake.snakeRunInterFace();
    assertEquals(false, SnakeGameView.gameState);
    snake.deleteSnakeHead();
    snake.setSnakeHead(1, -1);
    snake.snakeRunInterFace();
    assertEquals(false, SnakeGameView.gameState);
    snake.deleteSnakeHead();
    snake.setSnakeHead(700, 1);
    snake.snakeRunInterFace();
    assertEquals(false, SnakeGameView.gameState);
    snake.deleteSnakeHead();
    snake.setSnakeHead(1, 700);
    snake.snakeRunInterFace();
    assertEquals(false, SnakeGameView.gameState);
    snake.deleteSnakeHead();

  }

}
