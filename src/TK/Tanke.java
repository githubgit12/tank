package TK;

import java.awt.Color;
import java.awt.Graphics;

public class Tanke {
	private int x, y;
	private Dir dir = Dir.DOWN;
	private static final int speed = 5;

	private boolean moving = false;

	private TanKeFrame tf;

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Tanke(int x, int y, Dir dir, TanKeFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);
		g.setColor(c);
		move();

	}

	private void move() {
		if (!moving) {
			return;
		}
		switch (dir) {
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;
			break;
		default:
			break;
		}

	}

	public void fire() {
		tf.bullets.add(new Bullet(this.x, this.y, this.dir, this.tf));

	}

}
