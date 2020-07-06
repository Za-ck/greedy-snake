package snake;

public class GameRunThread implements Runnable {
  private int runTime = 100;
  private DrawView drawView;
  private Snake snake;

  public GameRunThread(DrawView drawView, Snake snake) {
    this.drawView = drawView;
    this.snake = snake;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    while (true) {
      snake.snakeRunInterFace(); //Խ�� 
      if (SnakeGameView.gameState) {
        drawView.repaint(); //�ػ�
        try {
          Thread.sleep(runTime);
        } catch (InterruptedException e) { 
          e.printStackTrace();
        }
      }
    }
  }

}
