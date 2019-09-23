package TK;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int SPEED = 1;
	private static int WIDTH = 30, HEIGHT = 30;
	private boolean moving = false;

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private int x, y;

	private Dir dir;

	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		move();

	}

	private void move() {
//		if (!moving) {
//			return;
//		}
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		default:
			break;
		}

	}
}
