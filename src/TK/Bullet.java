package TK;

import java.awt.*;

public class Bullet {

	private static final int SPEED = 10;
	public static int WIDTH = ResoureMgr.bulletD.getWidth();
	public static int HEIGHT = ResoureMgr.bulletD.getHeight();
	private boolean moving = false;

	private boolean living = true;

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
		if (!living) {
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

			living = false;
		}

	}

    public void collideWith(Tanke tanke) {
        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(tanke.getX(),tanke.getY(),Tanke.WIDTH,Tanke.HEIGHT);
        if(rect1.intersects(rect2)){
            tanke.die();
            this.die();
        }
    }

    private void die() {
	    this.living = false;
    }
}
