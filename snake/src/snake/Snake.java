package snake;

import java.util.LinkedList;
import java.util.Random;

public class Snake {

  private LinkedList<Node> snakeBody; //蛇身
  private SnakeGameView snakeGameView;

  //Snake方向：0.上，1.右，2.下，3.左
  private int direction = 0; //方向
  private static final int UP = 0;
  private static final int RIGHT = 1;
  private static final int DOWN = 2;
  private static final int LEFT = 3;
  private static final int LENGTH_BEGIN = 3;

  private Random random;

  /**
   * 构造函数.
   * 
   */
  public Snake(int snakeHeadX, int snakeHeadY, SnakeGameView snakeGameView) {
    random = new Random();
    snakeBody = new LinkedList<>();
    //初始化蛇身
    for (int i = 0; i < LENGTH_BEGIN; i++) {
      snakeBody.add(new Node(snakeHeadX, snakeHeadY + i * DrawView.NUMBER));
    }
    this.snakeGameView = snakeGameView;
  }

  //设置方向
  public void setDirection(int direction) {
    this.direction = direction;
  }

  //获得方向
  public int getDirection() {
    return direction;
  }

  public LinkedList<Node> getSnakeBody() { 
    return this.snakeBody;
  }

  //获得头节点
  public Node getSnakeHead() {
    return snakeBody.getFirst();
  }

  /**
   * 设置头结点.
   * 
   */
  public void setSnakeHead(int a, int b) {
    snakeBody.addFirst(new Node(a, b));
  }

  public void deleteSnakeHead() {
    snakeBody.removeFirst();
  }

  //获得尾节点
  public Node getSnakeLast() {
    return snakeBody.getLast();
  }

  /**
   * 蛇移动.
   * 
   */
  public void snakeMove() {
    switch (direction) {
      case UP:
        snakeBody.addFirst(new Node(getSnakeHead().getNodeX(), 
            getSnakeHead().getNodeY() - DrawView.NUMBER));
        break;
      case RIGHT:
        snakeBody.addFirst(new Node(getSnakeHead().getNodeX() + DrawView.NUMBER, 
            getSnakeHead().getNodeY()));
        break;
      case DOWN:
        snakeBody.addFirst(new Node(getSnakeHead().getNodeX(), 
            getSnakeHead().getNodeY() + DrawView.NUMBER));
        break;
      case LEFT:
        snakeBody.addFirst(new Node(getSnakeHead().getNodeX() - DrawView.NUMBER, 
            getSnakeHead().getNodeY()));
        break;
      default:
        break;
    }
    snakeBody.removeLast();
  }

  /**
   * 蛇吃蛋.
   * 
   */
  public void eatEgg(Node egg) {
    if (this.getSnakeHead().getNodeX() == egg.getNodeX() 
        && this.getSnakeHead().getNodeY() == egg.getNodeY()) {
      //加长身子
      snakeBody.add(egg);
      //产蛋
      snakeGameView.setEgg(random.nextInt(DrawView.WIDTH - 1) * DrawView.NUMBER, 
          random.nextInt(DrawView.WIDTH - 1) * DrawView.NUMBER);
      SnakeGameView.gameScore = SnakeGameView.gameScore + 5; //加分
      snakeGameView.getJTextArea().setText(SnakeGameView.gameScore + "");
      System.out.println("吃蛋！");
    }
  }

  /**
   * 蛇越界.
   * 
   */
  public void snakeRunInterFace() {
    if (this.getSnakeHead().getNodeX() < 0 || this.getSnakeHead().getNodeY() < 0 
        || this.getSnakeHead().getNodeX() > (DrawView.WIDTH * DrawView.NUMBER) 
        || this.getSnakeHead().getNodeY() > (DrawView.WIDTH * DrawView.NUMBER)) {
      SnakeGameView.gameState = false;
    }
  }
}
