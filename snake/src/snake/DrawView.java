package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class DrawView extends Panel {
  //面板宽度高度
  public static final int WIDTH = 40;
  public static final int HEIGHT = 40;
  public static final int NUMBER = 15;
  private Image ibuffer;
  private Graphics gbuffer;
  private Snake snake;
  private Node egg;

  //构造方法
  public DrawView(Snake snake, Node egg) {
    this.snake = snake;
    this.egg = egg; 
  }


  //重写paint方法
  @Override
  public void paint(Graphics g) {
    snake.snakeMove();
    this.drawGridding(g);
    this.drawEgg(g);
    this.drawSnake(g);
    snake.eatEgg(egg);
  }

  //重写update方法
  @Override
  public void update(Graphics g) {
    if (ibuffer == null) { 

      ibuffer = createImage(DrawView.WIDTH * DrawView.NUMBER + 1, 
          DrawView.HEIGHT * DrawView.NUMBER + 1);  
      gbuffer = ibuffer.getGraphics();  
    }  
    gbuffer.setColor(getBackground());  
    gbuffer.fillRect(0, 0, DrawView.WIDTH * DrawView.NUMBER + 1, 
        DrawView.HEIGHT * DrawView.NUMBER + 1);  
    paint(gbuffer);  
    g.drawImage(ibuffer, 0, 0, this); 
  }

  /**
   * 画线.
   * 
   */
  public void drawGridding(Graphics g) {
    g.setColor(new Color(128, 128, 128));
    for (int i = 0; i < WIDTH; i++) {
      g.drawLine(0, i * NUMBER, WIDTH * NUMBER, i * NUMBER);
    }
    for (int i = 0; i < HEIGHT; i++) {
      g.drawLine(i * NUMBER, 0, i * NUMBER, WIDTH * NUMBER);
    }
  }

  /**
   * 画蛇.
   * 
   */
  public void drawSnake(Graphics g) {
    for (int i = 0; i < snake.getSnakeBody().size(); i++) {
      g.setColor(Color.white);
      if (i == 0) {
        g.setColor(Color.lightGray);
      }
      g.fillRect(snake.getSnakeBody().get(i).getNodeX(), 
          snake.getSnakeBody().get(i).getNodeY(), NUMBER, NUMBER);
    }
  }

  //画蛋
  public void drawEgg(Graphics g) {
    g.setColor(Color.yellow);
    g.fillRect(egg.getNodeX(), egg.getNodeY(), NUMBER, NUMBER);
  }
}
