package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControl implements KeyListener {
  private Snake snake;

  public GameControl(Snake snake) {
    this.snake = snake;
  }

  @Override
  public void keyReleased(KeyEvent ke) {
    switch (ke.getKeyCode()) {
      case KeyEvent.VK_UP:
        if (snake.getDirection() != 2) {
          snake.setDirection(0);
          //System.out.println("向上");
        }
        break;
      case KeyEvent.VK_RIGHT:
        if (snake.getDirection() != 3) {
          snake.setDirection(1);
          //System.out.println("向右");
        }
        break;
      case KeyEvent.VK_DOWN:
        if (snake.getDirection() != 0) {
          snake.setDirection(2);
          //System.out.println("向下");
        }
        break;
      case KeyEvent.VK_LEFT:
        if (snake.getDirection() != 1) {
          snake.setDirection(3);
          //System.out.println("向左");
        }
        break;
      case KeyEvent.VK_ENTER:
        if (SnakeGameView.gameState == true) {
          SnakeGameView.gameState = false;
        } else {
          SnakeGameView.gameState = true;
        }
        break;
      case KeyEvent.VK_ESCAPE:
        System.exit(0);
        break;
      default:
        break;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub

  }
}
