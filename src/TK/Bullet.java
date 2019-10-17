package TK;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private static final int SPEED = 10;
	public static int WIDTH = ResoureMgr.bulletD.getWidth();
	public static int HEIGHT = ResoureMgr.bulletD.getHeight();
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
		switch (dir){
			case LEFT:
				g.drawImage(ResoureMgr.bulletL,x,y,null);
				break;
			case UP:
				g.drawImage(ResoureMgr.bulletU,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResoureMgr.bulletR,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResoureMgr.bulletD,x,y,null);
				break;
		}

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
