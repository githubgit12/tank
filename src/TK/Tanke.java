package TK;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tanke {
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	private Random random = new Random();
	private Dir dir = Dir.DOWN;
	private static final int speed = 2;

	public static int WIDTH = ResoureMgr.tankD.getWidth();
	public static int HEIGHT = ResoureMgr.tankD.getHeight();

	private boolean moving = true;

	private TanKeFrame tf = null;
	private boolean living = true;
    private Group group = Group.BAD;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Tanke(int x, int y, Dir dir, Group group, TanKeFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		if(!living) tf.tankes.remove(this);
		switch (dir){
			case LEFT:
				g.drawImage(ResoureMgr.tankL,x,y,null);
				break;
			case UP:
				g.drawImage(ResoureMgr.tankU,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResoureMgr.tankR,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResoureMgr.tankD,x,y,null);
				break;
		}

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
        //randomDir();
		if(random.nextInt(10) > 8) this.fire();
	}

	public void fire() {
		int bX = this.x + Tanke.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tanke.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bX, bY, this.dir,this.group, this.tf));

	}

	public void die() {
		this.living = false;
	}
}
