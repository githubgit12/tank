package TK;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int SPEED = 3;
	private static int WIDTH = 30, HEIGHT = 30;
	private boolean moving = false;

	private boolean live = true;

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private int x, y;

	private Dir dir;
	private TanKeFrame tf;

	public Bullet(int x, int y, Dir dir, TanKeFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		if (!live) {
			tf.bullets.remove(this);
		}
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
		if (x < 0 || y < 0 || x > TanKeFrame.GAME_WIDTH || y > TanKeFrame.GAME_HEIGHT) {

			live = false;
		}

	}
}
