package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SnakeGameView extends Frame {

  private JLabel jl; //名
  private DrawView drawView;
  private JPanel panel;
  private JLabel scoreTitle; //得分牌
  private JLabel score; //得分
  private JPanel rule; //规则
  private JTextArea hint;

  private Random random;
  public static boolean gameState = true; //游戏状态
  public static int gameScore = 0; //得分
  private Snake snake; //蛇
  private Node egg; //蛋
  private GameRunThread grt; //刷新线程
  private static Thread thread;

  /**
   * 构造函数.
   * 
   */
  public SnakeGameView() {
    random = new Random();
    //初始化Snake
    snake = new Snake(10 * DrawView.NUMBER + random.nextInt(19) * DrawView.NUMBER,
        10 * DrawView.NUMBER + random.nextInt(19) * DrawView.NUMBER, this);
    //初始化egg
    egg = new Node(random.nextInt(DrawView.WIDTH - 1) * DrawView.NUMBER,
        random.nextInt(DrawView.WIDTH - 1) * DrawView.NUMBER);
    //初始化面板
    drawView = new DrawView(snake, egg);
    grt = new GameRunThread(drawView, snake);
    thread = new Thread(grt);
    jl = new JLabel("SnakeGame-3.0", JLabel.CENTER);
    panel = new JPanel();
    scoreTitle = new JLabel("Score", JLabel.CENTER);
    score = new JLabel(gameScore + "", JLabel.CENTER);
    rule = new JPanel();
    hint = new JTextArea("    操作方式\n      ↑\n  ←     →\n     ↓\n\n【Esc】退出程序\n\n关于\n");
  }

  //放置蛋
  public void setEgg(int eggX, int eggY) {
    egg.setNodeX(eggX);
    egg.setNodeY(eggY);
  }

  public JLabel getJTextArea() {
    return score; 
  }

  /**
   * 界面.
   * 
   */
  public void showView() {
    jl.setFont(new Font("宋体", 1, 18)); //设置字体，0正常，1粗体
    jl.setForeground(Color.white); //设置颜色
    jl.setBounds(0, 0, DrawView.HEIGHT * DrawView.NUMBER + 70, 40);
    drawView.setBackground(new Color(51, 51, 51));
    drawView.setBounds(20, 50, DrawView.WIDTH * DrawView.NUMBER + 1, 
        DrawView.HEIGHT * DrawView.NUMBER + 1);
    panel.setLayout(null);
    panel.setBackground(new Color(0, 102, 102));
    panel.setBounds(DrawView.WIDTH * DrawView.NUMBER + 40, 50, 150, 
        DrawView.HEIGHT * DrawView.NUMBER);
    scoreTitle.setFont(new Font("宋体", 1, 18)); //设置字体，0正常，1粗体
    scoreTitle.setForeground(Color.white); //设置颜色
    scoreTitle.setBounds(0, 0, 150, 50);
    score.setFont(new Font("宋体", 1, 20)); //设置字体，0正常，1粗体
    score.setForeground(Color.white); //设置颜色
    score.setBounds(0, 50, 150, 40);
    rule.setBackground(new Color(0, 128, 128));
    rule.setBounds(0, 90, 150, 1);
    hint.setFont(new Font("宋体", 0, 16)); //设置字体，0正常，1粗体
    hint.setBounds(10, 100, 130, 150);
    hint.setBackground(new Color(0, 102, 102));

    panel.add(scoreTitle);
    panel.add(score);
    panel.add(rule);
    panel.add(hint);
    this.add(jl);
    this.setTitle("SnakeGame-3.0");
    this.setSize(DrawView.WIDTH * DrawView.NUMBER + 210, DrawView.HEIGHT * DrawView.NUMBER + 70);
    this.setLocation(500, 200);
    this.setLayout(null);

    this.setBackground(new Color(0, 128, 128));
    this.add(drawView);
    this.add(panel); //放入容器
    this.addKeyListener(new GameControl(snake)); //添加键盘监听
    this.addWindowListener(new WindowAdapter() { //添加窗口监听
      @Override
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
    this.setVisible(true);
  }

  //主方法
  public static void main(String[] args) {
    new SnakeGameView().showView();
    thread.start();
  }

}
