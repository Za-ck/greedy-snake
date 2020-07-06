package snake;

public class Node {
  private int nodex;
  private int nodey;

  public Node(int nodex, int nodey) {
    this.nodex = nodex;
    this.nodey = nodey;
  }

  public int getNodeX() {
    return this.nodex;
  }

  public void setNodeX(int nodex) {
    this.nodex = nodex;
  }

  public int getNodeY() {
    return this.nodey;
  }

  public void setNodeY(int nodey) {
    this.nodey = nodey;
  }
} //表示了蛇身上所有的点，由这些点构成了蛇身以及蛋

