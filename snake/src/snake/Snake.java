package snake;

import java.util.LinkedList;
import java.util.Random;

public class Snake {

  private LinkedList<Node> snakeBody; //����
  private SnakeGameView snakeGameView;

  //Snake����0.�ϣ�1.�ң�2.�£�3.��
  private int direction = 0; //����
  private static final int UP = 0;
  private static final int RIGHT = 1;
  private static final int DOWN = 2;
  private static final int LEFT = 3;
  private static final int LENGTH_BEGIN = 3;

  private Random random;

  /**
   * ���캯��.
   * 
   */
  public Snake(int snakeHeadX, int snakeHeadY, SnakeGameView snakeGameView) {
    random = new Random();
    snakeBody = new LinkedList<>();
    //��ʼ������
    for (int i = 0; i < LENGTH_BEGIN; i++) {
      snakeBody.add(new Node(snakeHeadX, snakeHeadY + i * DrawView.NUMBER));
    }
    this.snakeGameView = snakeGameView;
  }

  //���÷���
  public void setDirection(int direction) {
    this.direction = direction;
  }

  //��÷���
  public int getDirection() {
    return direction;
  }

  public LinkedList<Node> getSnakeBody() { 
    return this.snakeBody;
  }

  //���ͷ�ڵ�
  public Node getSnakeHead() {
    return snakeBody.getFirst();
  }

  /**
   * ����ͷ���.
   * 
   */
  public void setSnakeHead(int a, int b) {
    snakeBody.addFirst(new Node(a, b));
  }

  public void deleteSnakeHead() {
    snakeBody.removeFirst();
  }

  //���β�ڵ�
  public Node getSnakeLast() {
    return snakeBody.getLast();
  }

  /**
   * ���ƶ�.
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
   * �߳Ե�.
   * 
   */
  public void eatEgg(Node egg) {
    if (this.getSnakeHead().getNodeX() == egg.getNodeX() 
        && this.getSnakeHead().getNodeY() == egg.getNodeY()) {
      //�ӳ�����
      snakeBody.add(egg);
      //����
      snakeGameView.setEgg(random.nextInt(DrawView.WIDTH - 1) * DrawView.NUMBER, 
          random.nextInt(DrawView.WIDTH - 1) * DrawView.NUMBER);
      SnakeGameView.gameScore = SnakeGameView.gameScore + 5; //�ӷ�
      snakeGameView.getJTextArea().setText(SnakeGameView.gameScore + "");
      System.out.println("�Ե���");
    }
  }

  /**
   * ��Խ��.
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
