package practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

public class cdPanel extends Panel {
	
	//字符数量
	private static final int SIZE = 4;
	//长宽
	private static final int WIDTH = 160;	
	private static final int HEIGHT = 60;
	//干扰线
	private static final int LINES = 4;
	
	public void paint(Graphics arg0) {
		//绘制边框
		arg0.setColor(Color.black);//预先设置边框颜色
		arg0.drawRect(20, 10, WIDTH, HEIGHT);
		arg0.setColor(Color.LIGHT_GRAY);
		arg0.fillRect(20, 10, WIDTH+1, HEIGHT+1);
		
		//绘制红点
		arg0.setColor(Color.red);
		Random r = new Random();
		for(int i = 1; i <= 200; i++) {
			int x = r.nextInt(WIDTH) + 20;
			int y = r.nextInt(HEIGHT) + 10;
			arg0.drawOval(x, y, 2, 2);
		}
		
		//绘制字体
		arg0.setColor(Color.black);
		Font font = new Font("宋体", Font.BOLD, 50);
		arg0.setFont(font);
		
		char[] chars = ("1234567890" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();// toCharArray方法
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			int yan = r.nextInt(chars.length); //0~chars.length之间获得一个随机数作为索引
			char ch = chars[yan];
			sb.append(ch);
		}
		arg0.drawString(sb.toString(), 40, 60);
		
		//绘制干扰线
		for(int i = 0; i < LINES; i++) {
			arg0.setColor(setRandomColor());
			arg0.drawLine(r.nextInt(140) + 20, r.nextInt(50) + 10, r.nextInt(140) + 20, r.nextInt(50) + 10);
		}
	}
	
	//获取随机颜色
	public Color setRandomColor() {
		Random r = new Random();
		Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		return color;
	}
}
